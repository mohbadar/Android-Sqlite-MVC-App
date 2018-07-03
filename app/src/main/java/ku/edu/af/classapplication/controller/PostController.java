package ku.edu.af.classapplication.controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import ku.edu.af.classapplication.model.Lecture;
import ku.edu.af.classapplication.model.Post;
import ku.edu.af.classapplication.service.DBHepler;

public class PostController {

    private DBHepler dbHepler;

    public PostController(DBHepler dbHepler)
    {
        this.dbHepler = dbHepler;
    }

    public void insert(Post post)
    {


        SQLiteDatabase db = dbHepler.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put("title",post.getTitle());
        values.put("content", post.getContent());
        values.put("type", post.getType());
        values.put("file", post.getFile());

        db.insert(DBHepler.TBL_POST, null, values);

        db.close();
    }


    //select readings
    public ArrayList<Post> select()
    {
        SQLiteDatabase db = dbHepler.getReadableDatabase();
        ArrayList<Post> posts = new ArrayList<>();

        String sql ="SELECT * FROM "+ DBHepler.TBL_POST;

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do {

                Integer id = cursor.getInt(cursor.getColumnIndex("id"));
                String title =  cursor.getString(cursor.getColumnIndex("title"));
                String content =  cursor.getString(cursor.getColumnIndex("content"));
                String type =  cursor.getString(cursor.getColumnIndex("type"));
                String file =  cursor.getString(cursor.getColumnIndex("file"));

                Post post =new Post(id, title,content,type,file);
                posts.add(post);

            }while (cursor.moveToNext());
        }

        db.close();
        return posts;
    }
}
