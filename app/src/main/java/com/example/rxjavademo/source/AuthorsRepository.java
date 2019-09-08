package com.example.rxjavademo.source;

import com.example.rxjavademo.model.Author;
import com.example.rxjavademo.source.db.author_repo.AuthorLocalRepoImpl;
import com.example.rxjavademo.source.remote.repository.author_repo.AuthorRemoteRepoImpl;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthorsRepository {

    private AuthorLocalRepoImpl authorLocalRepo;
    private AuthorRemoteRepoImpl authorRemoteRepo;

    public Observable<List<Author>> findAll() {
        return Observable.mergeDelayError(authorRemoteRepo.findAll()
                .doOnNext((authors -> authorLocalRepo.save(authors)))
                .subscribeOn(Schedulers.io()), authorLocalRepo
                .findAllAuthors().subscribeOn(Schedulers.io()));
    }
}
