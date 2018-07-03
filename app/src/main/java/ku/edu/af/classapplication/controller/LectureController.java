package ku.edu.af.classapplication.controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import ku.edu.af.classapplication.model.Course;
import ku.edu.af.classapplication.model.Lecture;
import ku.edu.af.classapplication.service.DBHepler;
import ku.edu.af.classapplication.service.Tools;

public class LectureController {

    DBHepler dbHepler;

    public LectureController(DBHepler dbHepler)
    {
        this.dbHepler = dbHepler;
    }

    public void insert(Lecture lecture)
    {


        SQLiteDatabase db = dbHepler.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put("title",lecture.getTitle());
        values.put("description", lecture.getDescription());
        values.put("course_id", lecture.getCourse_id());

        db.insert(DBHepler.TBL_LECTURE, null, values);

        Log.d("lecture", lecture.getTitle());

        db.close();
    }


    //select readings
    public ArrayList<Lecture> select(Integer courseId)
    {
        SQLiteDatabase db = dbHepler.getReadableDatabase();
        ArrayList<Lecture> lectures = new ArrayList<>();

        String sql ="SELECT * FROM "+ DBHepler.TBL_LECTURE;// + " WHERE course_id = "+courseId;

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do {

                Integer id = cursor.getInt(cursor.getColumnIndex("id"));
                String title =  cursor.getString(cursor.getColumnIndex("title"));
                String description =  cursor.getString(cursor.getColumnIndex("description"));
                Integer course_id = cursor.getInt(cursor.getColumnIndex("course_id"));

                Lecture lecture = new Lecture(id, title, description,course_id);
                lectures.add(lecture);

            }while (cursor.moveToNext());
        }

        db.close();
        return lectures;
    }
}
