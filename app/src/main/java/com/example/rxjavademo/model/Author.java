package com.example.rxjavademo.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(tableName = "authors")
public class Author {

    @SerializedName("id")
    @Expose
    @ColumnInfo(name ="id")
    private long id;

    @SerializedName("name")
    @Expose
    @ColumnInfo(name ="name")
    private String name;

    @SerializedName("surname")
    @Expose
    @ColumnInfo(name ="surname")
    private String surname;

    @SerializedName("age")
    @Expose
    @ColumnInfo(name ="age")
    private int age;
}
