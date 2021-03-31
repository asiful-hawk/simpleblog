package com.example.simpleblog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.simpleblog.Database.AppDatabase;
import com.example.simpleblog.Entity.Blogs;

public class CreateBlog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_blog);


        final EditText title = findViewById(R.id.blogTitle);
        final EditText desc = findViewById(R.id.blogDesc);
        Button createBtn = findViewById(R.id.blogCreate);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createBlog(title.getText().toString(), desc.getText().toString());
            }
        });
    }

    private void createBlog(String title, String desc){
        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
        Blogs blogs = new Blogs();
        blogs.title = title;
        blogs.description = desc;
        db.blogDao().insertBlogs(blogs);
        finish();
    }
}