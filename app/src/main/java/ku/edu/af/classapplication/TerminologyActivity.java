package ku.edu.af.classapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ku.edu.af.classapplication.controller.TerminologyController;
import ku.edu.af.classapplication.model.Terminology;
import ku.edu.af.classapplication.service.DBHepler;

public class TerminologyActivity extends AppCompatActivity {

    TerminologyController terminologyController;
    DBHepler dbHepler;
    ListView terminologyListView;
    ArrayList<Terminology> terminologies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminology);

        dbHepler = new DBHepler(this);

        terminologyController = new TerminologyController(dbHepler);

        terms();

        terminologies = terminologyController.select();


        terminologyListView = (ListView) findViewById(R.id.termminologyListView);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.textview_layout, terminologies);



        terminologyListView.setAdapter(adapter);

        terminologyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Terminology terminology = terminologies.get(position);
                Intent intent =new Intent(TerminologyActivity.this, TermDetailsActivity.class);
                intent.putExtra("term", terminology.getTerm());
                intent.putExtra("content", terminology.getContent());

                startActivity(intent);
            }
        });

        Button button = (Button) findViewById(R.id.addingNewTerminologyBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TerminologyActivity.this, AddTerminologyActivity.class);
                startActivity(intent);
            }
        });

    }

    public void terms()
    {
        Terminology terminology = new Terminology("Machine Learning", "Learning from data.");
        Terminology terminology1 = new Terminology("Supervised Learning", "Learning from previous data.");
        Terminology terminology2 = new Terminology("Un-supervised Learning", "Finding from patterns.");

        terminologyController.insert(terminology);
        terminologyController.insert(terminology1);
        terminologyController.insert(terminology2);
    }
}
