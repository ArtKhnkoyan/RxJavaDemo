package com.example.rxjavademo.remote.repository.author_repo;

import com.example.rxjavademo.model.Author;

import java.util.List;

import io.reactivex.Observable;

public interface AuthorRemoteRepo {

    Observable<List<Author>> findAll();
}
