package ku.edu.af.classapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ku.edu.af.classapplication.controller.CourseController;
import ku.edu.af.classapplication.model.Course;
import ku.edu.af.classapplication.service.DBHepler;
import ku.edu.af.classapplication.service.Tools;

public class CourseActivity extends AppCompatActivity {

    CourseController courseController;
    ListView courseListView;
    ArrayList<Course>  courses;
    DBHepler dbHepler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        dbHepler = new DBHepler(this);

        courseController = new CourseController(dbHepler);

        //add data
        courses();

        courses = courseController.select();


        courseListView = (ListView) findViewById(R.id.course_listview);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.textview_layout, courses);

        courseListView.setAdapter(adapter);

        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course = courses.get(position);
                Intent intent = new Intent(CourseActivity.this,LecturesActivity.class);

                intent.putExtra("id", course.getId());
                intent.putExtra("title", course.getTitle());
                intent.putExtra("description", course.getDescription());
                intent.putExtra("year", course.getYear());

                startActivity(intent);
            }
        });

    }


    public void courses()
    {
        Course course = new Course("Java Programming", "This is Descriptioin ", 2018);
        Course course1 = new Course("PHP Programming", "This is Descriptioin ", 2018);
        Course course2 = new Course("PYTHON Programming", "This is Descriptioin ", 2018);
        Course course3 = new Course("Mobile Programming", "This is Descriptioin ", 2018);


        courseController.insert(course);
        courseController.insert(course1);
        courseController.insert(course2);
        courseController.insert(course3);

    }
}
