package com.example.simpleblog.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.simpleblog.Entity.Author;
import com.example.simpleblog.Entity.Blogs;

import java.util.List;

@Dao
public interface BlogDao {
    @Query("SELECT * FROM BLOGS")
    List<Blogs> getAllBlog();
    @Query("SELECT * FROM BLOGS WHERE id = :id")
    Blogs getBlogById(int id);
    @Insert
    void insertBlogs(Blogs blogs);
}
