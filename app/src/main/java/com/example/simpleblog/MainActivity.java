package com.example.simpleblog;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.simpleblog.Client.RestClient;
import com.example.simpleblog.Database.AppDatabase;
import com.example.simpleblog.Entity.Blogs;
import com.example.simpleblog.Entity.Categories;
import com.example.simpleblog.Service.BlogService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private BlogAdapter blogAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlogAdapter blogAdapter = new BlogAdapter(getApplicationContext());
        Button createBlg = findViewById(R.id.blogAdd);
        createBlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, CreateBlog.class), 100);
            }
        });
        initializeRecycler();
        loadBlog();
    }


    private void initializeRecycler(){
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        blogAdapter = new BlogAdapter(this);
        recyclerView.setAdapter(blogAdapter);
        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
        BlogService blogService = RestClient.getRetrofitInstance().create(BlogService.class);


        blogService.getBlogs().enqueue(new Callback<List<Blogs>>() {
            @Override
            public void onResponse(Call<List<Blogs>> call, Response<List<Blogs>> response) {
                try {
                    List<Blogs> blogsList = (List<Blogs>) response.body();

                    for (int i = 0; i < blogsList.size(); i++) {
                        String title = blogsList.get(i).getTitle();
                        String coverP = blogsList.get(i).getCover_photo();
                        List<String> cat = blogsList.get(i).getCategories();

                        String desc = blogsList.get(i).getDescription();
                        int id = blogsList.get(i).getId();
                        if (db.blogDao().getBlogById(i) == null) {
                            Blogs blogs = new Blogs();
                            blogs.setTitle(title);
                            blogs.setCover_photo(coverP);
                            for(int j = 0; j<cat.size();j++){
                                String cate = cat.get(j) + ",";
                            }
                            blogs.setId(id);
                            blogs.setDescription(desc);
                        } else {
                            loadBlog();
                        }

                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<List<Blogs>> call, Throwable t) {
                t.printStackTrace();
            }

        });
    }

    private void loadBlog(){
        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
        List<Blogs> blogs = db.blogDao().getAllBlog();
        blogAdapter.setBlogsList(blogs);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == 100){
            loadBlog();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}