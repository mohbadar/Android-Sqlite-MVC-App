package ku.edu.af.classapplication.controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import ku.edu.af.classapplication.model.Course;
import ku.edu.af.classapplication.model.Reading;
import ku.edu.af.classapplication.service.DBHepler;

public class CourseController {

    private DBHepler dbHepler;

    public CourseController(DBHepler dbHepler)
    {
        this.dbHepler=dbHepler;
    }


    public void insert(Course course)
    {


        SQLiteDatabase db = dbHepler.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put("title",course.getTitle());
        values.put("description", course.getDescription());
        values.put("year", course.getYear());

        db.insert(DBHepler.TBL_COURSE, null, values);

        db.close();
    }


    //select readings
    public ArrayList<Course> select()
    {
        SQLiteDatabase db = dbHepler.getReadableDatabase();
        ArrayList<Course> courses = new ArrayList<>();

        String sql ="SELECT * FROM "+ DBHepler.TBL_COURSE + " ORDER BY year DESC";

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do {

                Integer id = cursor.getInt(cursor.getColumnIndex("id"));
                String title =  cursor.getString(cursor.getColumnIndex("title"));
                String description =  cursor.getString(cursor.getColumnIndex("description"));
                Integer year =  cursor.getInt(cursor.getColumnIndex("year"));

                Course course = new Course(id,title,description,year);
                courses.add(course);

            }while (cursor.moveToNext());
        }

        db.close();
        return courses;
    }
}
