package ku.edu.af.classapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import ku.edu.af.classapplication.controller.TerminologyController;
import ku.edu.af.classapplication.model.Terminology;
import ku.edu.af.classapplication.service.DBHepler;
import ku.edu.af.classapplication.service.Tools;

public class AddTerminologyActivity extends AppCompatActivity {

    TerminologyController terminologyController;
    DBHepler dbHepler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_terminology);

        dbHepler = new DBHepler(this);

        terminologyController= new TerminologyController(dbHepler);

        ImageButton button = (ImageButton) findViewById(R.id.addNewTerminology);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText termTV = (EditText) findViewById(R.id.term_textview);
                EditText contentTV = (EditText) findViewById(R.id.content_textview);

                String term = termTV.getText().toString();
                String content = contentTV.getText().toString();

                Terminology terminology= new Terminology(term, content);

                terminologyController.insert(terminology);

                Tools.alert(AddTerminologyActivity.this, "Congradualations", "You operation is ended successfully!");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(AddTerminologyActivity.this, TerminologyActivity.class);
                startActivity(intent);

            }
        });

    }
}
