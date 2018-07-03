package ku.edu.af.classapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import ku.edu.af.classapplication.controller.ReadingController;
import ku.edu.af.classapplication.model.Reading;
import ku.edu.af.classapplication.service.DBHepler;

public class ReadingActivity extends AppCompatActivity {

    ReadingController readingController;
    ArrayList<Reading> readings;

    ListView readingListView;
    DBHepler dbHepler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        dbHepler = new DBHepler(this);
        readingController = new ReadingController(dbHepler);

        readings();

        readings = readingController.select();

        readingListView = (ListView) findViewById(R.id.readingListView);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.textview_layout, readings);
        readingListView.setAdapter(adapter);

        readingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Reading reading = readings.get(position);

                Intent intent = new Intent(ReadingActivity.this, ReadingDetailActivity.class);
                intent.putExtra("task", reading.getTask());
                intent.putExtra("description", reading.getDescription());
                intent.putExtra("startDate", reading.getStartDate());
                intent.putExtra("finishDate", reading.getFinishDate());
                startActivity(intent);

            }
        });


        ///add reading btn handler

        Button button = (Button) findViewById(R.id.addingNewReadingBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadingActivity.this, AddReadingActivity.class);
                startActivity(intent);
            }
        });

    }


    //add readings
    public void readings(){
        Reading reading = new Reading("Java Programming", "Needs to be finished in three days. Needs to be finished in three days.Needs to be finished in three days.", "2018-04-12", "2018-04-15");
        Reading reading1 = new Reading("PHP Programming", "Needs to be  finished in three days. Needs to be finished in three days.Needs to be finished in three days.", "2018-04-11", "2019-04-15");
        Reading reading2 = new Reading("Mobile Programming", "Needs to be  dds finished in three days. Needs to be finished in three days.Needs to be finished in three days.", "2017-04-12", "2019-04-15");

        readingController.insert(reading);
        readingController.insert(reading1);
        readingController.insert(reading2);
    }
}
