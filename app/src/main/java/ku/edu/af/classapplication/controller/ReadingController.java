package ku.edu.af.classapplication.controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import ku.edu.af.classapplication.*;

import ku.edu.af.classapplication.model.Reading;
import ku.edu.af.classapplication.service.DBHepler;

public class ReadingController {

    private DBHepler dbHelper;

    public ReadingController(DBHepler dbHelper)
    {
        this.dbHelper=dbHelper;
    }

    public void insert(Reading reading)
    {


        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put("task", reading.getTask());
        values.put("description",reading.getDescription());
        values.put("startDate", reading.getStartDate());
        values.put("finishDate", reading.getFinishDate());

        db.insert(DBHepler.TBL_READING, null, values);

        db.close();
    }


    //select readings
    public ArrayList<Reading> select()
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<Reading> readings = new ArrayList<>();

        String sql ="SELECT * FROM "+ DBHepler.TBL_READING;

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do {

                String task = cursor.getString(cursor.getColumnIndex("task"));
                String description =  cursor.getString(cursor.getColumnIndex("description"));
                String startDate =  cursor.getString(cursor.getColumnIndex("startDate"));
                String finishDate =  cursor.getString(cursor.getColumnIndex("finishDate"));

                Reading reading = new Reading(task,description,startDate,finishDate);
                readings.add(reading);

            }while (cursor.moveToNext());
        }

        db.close();
        return readings;
    }
}
