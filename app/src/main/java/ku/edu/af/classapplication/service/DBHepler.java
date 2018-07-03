package ku.edu.af.classapplication.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHepler extends SQLiteOpenHelper {

    private static final  String DB_NAME = "classapp";
    private static final  Integer DB_VERSION = 1;


    public static final  String TBL_TERMINOLOGY = "terminology";
    public static final  String TBL_READING = "reading";
    public static final  String TBL_POST ="posts";
    public static final  String TBL_COURSE ="courses";
    public static final  String TBL_LECTURE ="lectures";
    public static final  String TBL_FILE ="files";





    public DBHepler(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_terminology_table = "CREATE TABLE "+TBL_TERMINOLOGY+ " (id INT PRIMARY KEY, term TEXT, content TEXT);";
        String create_reading_table = "CREATE TABLE "+TBL_READING+ " (id INT PRIMARY KEY, task TEXT, description TEXT, startDate TEXT, finishDate TEXT);";

        String create_course_table = "CREATE TABLE "+ TBL_COURSE + " (id INT PRIMARY KEY, title TEXT, description TEXT, year INT);";
        String create_lecture_table="CREATE TABLE "+TBL_LECTURE + " (id INT PRIMARY KEY, title TEXT, description TEXT, course_id INT);";
        String create_file_table="CREATE TABLE "+TBL_FILE + " (id INT PRIMARY KEY, title TEXT, file TEXT, lecture_id INT);";
        String create_post_table="CREATE TABLE "+TBL_POST + " (id INT PRIMARY KEY, title TEXT, content TEXT, type TEXT, file TEXT);";



        db.execSQL(create_terminology_table);
        db.execSQL(create_reading_table);
        db.execSQL(create_post_table);
        db.execSQL(create_course_table);
        db.execSQL(create_lecture_table);
        db.execSQL(create_file_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
