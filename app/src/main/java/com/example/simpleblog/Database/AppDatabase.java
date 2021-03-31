package com.example.simpleblog.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.simpleblog.Entity.Blogs;
import com.example.simpleblog.Entity.Categories;

@Database(entities = {Blogs.class}, version = 1)
@TypeConverters({Categories.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract BlogDao blogDao();
    private static AppDatabase INSTANCE;
    public static AppDatabase getInstance(Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Blogss")
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;
    }
}
