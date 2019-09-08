package com.example.rxjavademo.source.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.rxjavademo.model.Author;

import java.util.List;

@Dao
public interface AuthorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Author> authors);

    @Query("SELECT * FROM authors")
    List<Author> findAll();

}
