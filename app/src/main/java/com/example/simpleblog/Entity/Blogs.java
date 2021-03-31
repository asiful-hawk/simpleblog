package com.example.simpleblog.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Blogs implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @SerializedName("")
    public String title;
    @ColumnInfo
    public String description;
    @ColumnInfo
    public String cover_photo;
    @ColumnInfo
    @SerializedName("categories")
    public List<String> categories;


    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Blogs() {
    }

    public Blogs(int id, String title, String description, String cover_photo, List<String> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.cover_photo = cover_photo;
        this.categories = categories;
    }

    public Blogs(String title, String cover_photo, List<String> categories) {
        this.title = title;
        this.cover_photo = cover_photo;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover_photo() {
        return cover_photo;
    }

    public void setCover_photo(String cover_photo) {
        this.cover_photo = cover_photo;
    }
}
