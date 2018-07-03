package ku.edu.af.classapplication.controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import ku.edu.af.classapplication.model.File;
import ku.edu.af.classapplication.model.Lecture;
import ku.edu.af.classapplication.service.DBHepler;

public class FileController {

    private DBHepler dbHepler;

    public FileController(DBHepler dbHepler)
    {
        this.dbHepler= dbHepler;
    }

    public void insert(File file)
    {


        SQLiteDatabase db = dbHepler.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put("title",file.getTitle());
        values.put("file", file.getFile());
        values.put("lecture_id", file.getLecture_id());

        db.insert(DBHepler.TBL_FILE, null, values);

        db.close();
    }


    //select readings
    public ArrayList<File> select(Integer lectureId)
    {
        SQLiteDatabase db = dbHepler.getReadableDatabase();
        ArrayList<File> files = new ArrayList<>();

        String sql ="SELECT * FROM "+ DBHepler.TBL_FILE;// + " WHERE lecture_id = "+lectureId;

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do {

                Integer id = cursor.getInt(cursor.getColumnIndex("id"));
                String title =  cursor.getString(cursor.getColumnIndex("title"));
                String file =  cursor.getString(cursor.getColumnIndex("file"));
                Integer lecture_id = cursor.getInt(cursor.getColumnIndex("lecture_id"));

                File file1 = new File(id,title,file,lecture_id);
                files.add(file1);

            }while (cursor.moveToNext());
        }

        db.close();
        return files;
    }
}
