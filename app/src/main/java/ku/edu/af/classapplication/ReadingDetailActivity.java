package ku.edu.af.classapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReadingDetailActivity extends AppCompatActivity {
    TextView taskTV, descriptionTV, startDateTV, finishDateTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_detail);

        Intent intent = getIntent();
        String task = intent.getStringExtra("task");
        String description = intent.getStringExtra("description");
        String startDate = intent.getStringExtra("startDate");
        String finishDate = intent.getStringExtra("finishDate");


        taskTV = (TextView) findViewById(R.id.taskPlaceHolder);
        descriptionTV = (TextView) findViewById(R.id.descriptionPlaceHolder);
        startDateTV = (TextView) findViewById(R.id.startDatePlaceHolder);
        finishDateTV = (TextView) findViewById(R.id.finishDatePlaceHolder);

        taskTV.setText(task);
        descriptionTV.setText(description);
        startDateTV.setText(startDate);
        finishDateTV.setText(finishDate);
    }
}
