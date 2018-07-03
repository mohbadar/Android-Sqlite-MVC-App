package ku.edu.af.classapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ku.edu.af.classapplication.controller.LectureController;
import ku.edu.af.classapplication.model.Lecture;
import ku.edu.af.classapplication.service.DBHepler;
import ku.edu.af.classapplication.service.Tools;

public class LecturesActivity extends AppCompatActivity {

    LectureController lectureController;
    DBHepler dbHepler;
    ArrayList<Lecture> lectures;
    ListView lectureListView;
    TextView titleTV, descriptionTV, yearTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectures);

        Intent intent = getIntent();

        Integer courseId = intent.getIntExtra("id", 1);
        Integer year = intent.getIntExtra("year",2018);
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");

        titleTV = (TextView) findViewById(R.id.course_title_placeholder);
        descriptionTV = (TextView) findViewById(R.id.course_description_placeholder);
        yearTV = (TextView) findViewById(R.id.course_year_placeholder);

        yearTV.setText("Year:  "+ year);
        titleTV.setText(title);
        descriptionTV.setText(description);



        lectureListView= (ListView) findViewById(R.id.lectures_listview);

        dbHepler = new DBHepler(this);
        lectureController = new LectureController(dbHepler);

        //add test lectures
        Lecture lecture = new Lecture("Aspect Oriented Programming", "Some Description", 1);
        final Lecture lecture1 = new Lecture("Notations", "Some dDescription", 2);
        Lecture lecture2 = new Lecture("Security in Layers", "Somef Description", 31);
        Lecture lecture3 = new Lecture("Bean Configuration", "Some gDescription", 14);

        lectureController.insert(lecture);
        lectureController.insert(lecture1);
        lectureController.insert(lecture2);
        lectureController.insert(lecture3);



        lectures = lectureController.select(courseId);

        for (int i=0; i<lectures.size(); i++)
        {
            Log.e("lecture" , lectures.get(i).toString());
        }

        ArrayAdapter adapter= new ArrayAdapter(this, R.layout.textview_layout, lectures);
        lectureListView.setAdapter(adapter);

        lectureListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Tools.toast(LecturesActivity.this, "You clicked "+ position);

                Lecture lecture = lectures.get(position);

                String title = lecture.getTitle();
                String description = lecture.getDescription();
                int lectureId = lecture.getId();

                Intent intent = new Intent(LecturesActivity.this, FileActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("description", description);
                intent.putExtra("lectureId", lectureId);
                startActivity(intent);

            }
        });



    }

    public void lectures()
    {





    }

}
