package com.example.rxjavademo.db.author_repo;

import com.example.rxjavademo.model.Author;

import java.util.List;

import io.reactivex.Observable;

public interface AuthorLocalRepo {

    void save(List<Author> authors);

    Observable<List<Author>> findAllAuthors();
}
