package com.example.rxjavademo.source.remote;

import com.example.rxjavademo.model.Author;

import java.util.List;

import io.reactivex.Observable;

public interface ApiService {

    Observable<List<Author>> findAllAuthors();
}
