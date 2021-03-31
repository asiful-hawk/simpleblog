package com.example.simpleblog.Entity;

import androidx.annotation.NonNull;
import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Categories {
    public Categories() {
    }

    @TypeConverter
    public static List<String> fromString(String value) {
        Type listType = new TypeToken<List<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String fromArrayList(List<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

//    @TypeConverter
//    public Blogs categoriesToString(String value) {
//
//        Gson gson = new Gson();
//        ArrayList<String> cat = gson.fromJson("categories", (Type) Blogs.class);
//        return new Blogs();
//    }
//
//    @TypeConverter
//    public String languagesToStoredString(Blogs blogs) {
//        String value = "";
//
//        for (String lang : blogs.getCategories())
//            value += lang + ",";
//
//        return value;
//    }






//    public List<String> categories;
//
//    public Categories(List<String> categories) {
//        this.categories = categories;
//    }
//
//    public List<String> getCategories() {
//        return categories;
//    }
//
//    public void setCategories(List<String> categories) {
//        this.categories = categories;
//    }
//
//    @SerializedName("Business")
//    @Expose
//    String business;
//    @SerializedName("Lifestyle")
//    @Expose
//    String lifestyle;
//    @SerializedName("Educational")
//    @Expose
//    String educational;
//
//    public String getBusiness() {
//        return business;
//    }
//
//    public void setBusiness(String business) {
//        this.business = business;
//    }
//
//    public String getLifestyle() {
//        return lifestyle;
//    }
//
//    public void setLifestyle(String lifestyle) {
//        this.lifestyle = lifestyle;
//    }
//
//    public String getEducational() {
//        return educational;
//    }
//
//    public void setEducational(String educational) {
//        this.educational = educational;
//    }
//
//    @TypeConverter
//    public static ArrayList<String> fromString(String string) {
//        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
//        return new Gson().fromJson(string, listType);
//    }
//    @TypeConverter
//    public static String fromArrayList(ArrayList<String> list) {
//        Gson gson = new Gson();
//        String json = gson.toJson(list);
//        return json;
//    }
}
