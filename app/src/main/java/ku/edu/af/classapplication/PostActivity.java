package ku.edu.af.classapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ku.edu.af.classapplication.controller.PostController;
import ku.edu.af.classapplication.model.Post;
import ku.edu.af.classapplication.service.DBHepler;

public class PostActivity extends AppCompatActivity {

    PostController postController;
    ListView postListView;
    DBHepler dbHepler;
    ArrayList<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        dbHepler = new DBHepler(this);
        postListView = (ListView) findViewById(R.id.postListView);
        postController = new PostController(dbHepler);

        //add posts
        posts();


        posts= postController.select();



        ArrayAdapter adapter= new ArrayAdapter(this, R.layout.textview_layout,posts);

        postListView.setAdapter(adapter);

        postListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Post post = posts.get(position);

                Intent intent = new Intent(PostActivity.this, PostDetailActivity.class);
                intent.putExtra("title", post.getTitle());
                intent.putExtra("content", post.getContent());
                intent.putExtra("file", post.getFile());
                intent.putExtra("type", post.getType());

                startActivity(intent);

            }
        });
    }

    private void posts() {

        Post post = new Post("Post Title 1", "Post Content 1" , "/files/index.jpg", "announcement");
        Post post1 = new Post("Post Title 2", "Post Content 2" , "/files/index.jpg", "announcement");
        Post post2 = new Post("Post Title 3", "Post Content 3" , "/files/index.jpg", "article");
        Post post3 = new Post("Post Title 4", "Post Content 4" , "/files/index.jpg", "article");

        postController.insert(post);
        postController.insert(post1);
        postController.insert(post2);
        postController.insert(post3);

    }
}
