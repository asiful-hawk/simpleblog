package com.example.simpleblog.Service;

import com.example.simpleblog.Entity.Blogs;
import com.example.simpleblog.Entity.Categories;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BlogService {

    @GET("db")
    Call<List<Blogs>> getBlogs();


}
