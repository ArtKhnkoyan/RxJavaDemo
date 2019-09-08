package com.example.rxjavademo.remote.repository.author_repo;

import com.example.rxjavademo.Constants;
import com.example.rxjavademo.model.Author;
import com.example.rxjavademo.remote.ApiService;
import com.example.rxjavademo.remote.BaseRemote;

import java.util.List;

import io.reactivex.Observable;

public class AuthorRemoteRepoImpl extends BaseRemote implements AuthorRemoteRepo {

    @Override
    public Observable<List<Author>> findAll() {
        return create(ApiService.class, Constants.BASE_URL).findAllAuthors();
    }
}
