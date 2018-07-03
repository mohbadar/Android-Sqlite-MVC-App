package ku.edu.af.classapplication.controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import ku.edu.af.classapplication.model.Reading;
import ku.edu.af.classapplication.model.Terminology;
import ku.edu.af.classapplication.service.DBHepler;

public class TerminologyController {

    private DBHepler dbHelper;

    public TerminologyController(DBHepler dbHelper)
    {
        this.dbHelper=dbHelper;
    }

    public void insert(Terminology terminology)
    {


        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put("term", terminology.getTerm());
        values.put("content", terminology.getContent());

        db.insert(DBHepler.TBL_TERMINOLOGY, null, values);

        db.close();
    }

    //select terms

    //select readings
    public ArrayList<Terminology> select()
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<Terminology> terminologies = new ArrayList<>();

        String sql ="SELECT * FROM  "+ DBHepler.TBL_TERMINOLOGY;

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do {

                String task = cursor.getString(cursor.getColumnIndex("term"));
                String content =  cursor.getString(cursor.getColumnIndex("content"));

                Terminology terminology = new Terminology(task,content);
                terminologies.add(terminology);

            }while (cursor.moveToNext());
        }

        db.close();
        return terminologies;
    }

}
