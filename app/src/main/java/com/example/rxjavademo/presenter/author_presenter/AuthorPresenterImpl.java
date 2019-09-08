package com.example.rxjavademo.presenter.author_presenter;

import com.example.rxjavademo.model.Author;
import com.example.rxjavademo.source.AuthorsRepository;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuthorPresenterImpl implements AuthorPresenter {

    private AuthorsRepository authorsRepository;
    private Scheduler scheduler;
    private Disposable disposable;

    public AuthorPresenterImpl(AuthorsRepository authorsRepository, Scheduler scheduler) {
        this.authorsRepository = authorsRepository;
        this.scheduler = scheduler;
    }

    @Override
    public void setAuthors() {
        disposable = authorsRepository.findAll().observeOn(scheduler).subscribeWith(new DisposableObserver<List<Author>>() {

            @Override
            public void onNext(List<Author> authors) {

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void detach() {
        this.disposable.dispose();
    }
}
