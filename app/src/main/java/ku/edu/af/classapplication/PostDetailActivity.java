package ku.edu.af.classapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PostDetailActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        Intent intent= getIntent();

        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        String type = intent.getStringExtra("type");
        String file = intent.getStringExtra("file");

        TextView titleTV = (TextView) findViewById(R.id.postTitlePlaceHolder);
        TextView contentTV = (TextView) findViewById(R.id.postContentPlaceHolder);
        TextView typeTV = (TextView) findViewById(R.id.postTypePlaceHolder);


        titleTV.setText(" " +title);
        contentTV.setText(" "+content);
        typeTV.setText("Type: "+ type);

        


    }
}
