package ku.edu.af.classapplication;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import ku.edu.af.classapplication.controller.ReadingController;
import ku.edu.af.classapplication.model.Reading;
import ku.edu.af.classapplication.model.Terminology;
import ku.edu.af.classapplication.service.DBHepler;
import ku.edu.af.classapplication.service.Tools;

public class MainActivity extends AppCompatActivity {



    DBHepler dbHepler;


    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments her

                        return true;
                    }
                });








        //action section
        ListView actionListView = (ListView) findViewById(R.id.action_listview);

        ArrayAdapter action_adapter =ArrayAdapter.createFromResource(this,R.array.action_list,R.layout.textview_layout);
        actionListView.setAdapter(action_adapter);

        actionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, TerminologyActivity.class);
                        startActivity(intent);
                        break;

                    case 1:
                        Intent createTermIntent = new Intent(MainActivity.this, AddTerminologyActivity.class);
                        startActivity(createTermIntent);
                        break;


                    case 2:
                        Intent listReadingsIntent = new Intent(MainActivity.this, ReadingActivity.class);
                        startActivity(listReadingsIntent);
                        break;

                    case 3:
                        Intent createReadingIntent = new Intent(MainActivity.this, AddReadingActivity.class);
                        startActivity(createReadingIntent);
                        break;

                    case 4:
                        Intent listPostIntent = new Intent(MainActivity.this, PostActivity.class);
                        startActivity(listPostIntent);
                        break;


                    case 5:
                        Intent listCoursesIntent = new Intent(MainActivity.this, CourseActivity.class);
                        startActivity(listCoursesIntent);
                        break;
                }
            }
        });

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

        }


        return super.onOptionsItemSelected(item);
    }


}
