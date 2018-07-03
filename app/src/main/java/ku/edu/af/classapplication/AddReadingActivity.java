package ku.edu.af.classapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import ku.edu.af.classapplication.controller.ReadingController;
import ku.edu.af.classapplication.model.Reading;
import ku.edu.af.classapplication.service.DBHepler;
import ku.edu.af.classapplication.service.Tools;

public class AddReadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reading);
    }

    public void addReading(View view) {
        EditText taskET  = (EditText) findViewById(R.id.task_textview);
        EditText descriptionET  = (EditText) findViewById(R.id.description_textview);
        EditText startDateET  = (EditText) findViewById(R.id.startDate_textview);
        EditText finishDateET  = (EditText) findViewById(R.id.finishDate_textview);

        String task = taskET.getText().toString();
        String description = descriptionET.getText().toString();
        String startDate = startDateET.getText().toString();
        String finishDate = finishDateET.getText().toString();

        DBHepler dbHepler = new DBHepler(AddReadingActivity.this);
        ReadingController readingController = new ReadingController(dbHepler);

        Reading reading= new Reading(task,description,startDate,finishDate);

        readingController.insert(reading);

        Tools.alert(this, "Congradualations", "You operation is ended successfully!");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(AddReadingActivity.this, ReadingActivity.class);
        startActivity(intent);
    }
}
