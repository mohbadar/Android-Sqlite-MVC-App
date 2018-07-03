package ku.edu.af.classapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ku.edu.af.classapplication.controller.FileController;
import ku.edu.af.classapplication.model.File;
import ku.edu.af.classapplication.service.DBHepler;
import ku.edu.af.classapplication.service.Tools;

public class FileActivity extends AppCompatActivity {

    FileController fileController;
    DBHepler dbHepler;
    ListView fileListView;
    ArrayList<File> files;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);


        dbHepler = new DBHepler(this);
        fileController = new FileController(dbHepler);

        files();

        fileListView = (ListView) findViewById(R.id.files_listview);

        files = fileController.select(1);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.textview_layout, files);

        fileListView.setAdapter(adapter);

        fileListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                File file = files.get(position);

                String url = file.getFile();

                Tools.alert(FileActivity.this, "Error", "No Internet Connection");

            }
        });


        TextView titleTV= (TextView) findViewById(R.id.lecture_title_placeholder);
        TextView descriptionTV= (TextView) findViewById(R.id.lecture_description_placeholder);

        Intent intent = getIntent();
        String title =intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        Integer lectureId = intent.getIntExtra("lectureId",1);


        titleTV.setText(title);
        descriptionTV.setText(description);



    }


    public void files()
    {
        File file = new File("File Title", "/files/images/badar.jpg",1);
        File file2 = new File("File Title2", "/files/images/badar.jpg",1);
        File file3 = new File("File Title3", "/files/images/badar.jpg",1);
        File file4 = new File("File Title4", "/files/images/badar.jpg",1);


        fileController.insert(file);
        fileController.insert(file2);
        fileController.insert(file3);
        fileController.insert(file4);
    }
}
