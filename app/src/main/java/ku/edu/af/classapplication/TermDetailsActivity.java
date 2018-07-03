package ku.edu.af.classapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TermDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_details);

        Intent intent = getIntent();
        String term = intent.getStringExtra("term");
        String content = intent.getStringExtra("content");

        TextView termTV = (TextView) findViewById(R.id.tarmPlaceHolder);
        TextView contentTV = (TextView) findViewById(R.id.contentPlaceHoler);

        termTV.setText(term);
        contentTV.setText(content);


    }
}
