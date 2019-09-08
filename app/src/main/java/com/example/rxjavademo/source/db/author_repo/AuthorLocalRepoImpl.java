package com.example.rxjavademo.source.db.author_repo;

import com.example.rxjavademo.model.Author;
import com.example.rxjavademo.source.db.AuthorDao;

import java.util.List;

import io.reactivex.Observable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthorLocalRepoImpl implements AuthorLocalRepo {

    private AuthorDao authorDao;

    @Override
    public void save(List<Author> authors) {
        authorDao.insertAll(authors);
    }

    @Override
    public Observable<List<Author>> findAllAuthors() {
        return Observable.fromCallable(() -> authorDao.findAll());
    }
}
