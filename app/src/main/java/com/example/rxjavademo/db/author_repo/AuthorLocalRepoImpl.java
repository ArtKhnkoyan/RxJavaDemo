package com.example.rxjavademo.db.author_repo;

import com.example.rxjavademo.db.AuthorDao;
import com.example.rxjavademo.model.Author;

import java.util.List;

import io.reactivex.Observable;

public class AuthorLocalRepoImpl implements AuthorLocalRepo {
    private AuthorDao authorDao;

    public AuthorLocalRepoImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public void save(List<Author> authors) {
        authorDao.insertAll(authors);
    }

    @Override
    public Observable<List<Author>> findAllAuthors() {
        return Observable.fromCallable(() -> authorDao.findAll());
    }
}
