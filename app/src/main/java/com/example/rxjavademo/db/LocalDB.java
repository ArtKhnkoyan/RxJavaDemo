package com.example.rxjavademo.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.rxjavademo.model.Author;

@Database(entities = {Author.class}, version = 1, exportSchema = false)
public abstract class LocalDB extends RoomDatabase {

    public abstract AuthorDao authorDao();
}
