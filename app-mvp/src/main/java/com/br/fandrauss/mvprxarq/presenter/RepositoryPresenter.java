package com.br.fandrauss.mvprxarq.presenter;

import android.util.Log;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import com.br.fandrauss.mvprxarq.ArchiApplication;
import com.br.fandrauss.mvprxarq.model.GithubService;
import com.br.fandrauss.mvprxarq.model.User;
import com.br.fandrauss.mvprxarq.view.RepositoryMvpView;

public class RepositoryPresenter implements Presenter<RepositoryMvpView> {

    private static final String TAG = "RepositoryPresenter";

    private RepositoryMvpView repositoryMvpView;
    private Subscription subscription;

    @Override
    public void attachView(RepositoryMvpView view) {
        this.repositoryMvpView = view;
    }

    @Override
    public void detachView() {
        this.repositoryMvpView = null;
        if (subscription != null) subscription.unsubscribe();
    }

    public void loadOwner(String userUrl) {
        ArchiApplication application = ArchiApplication.get(repositoryMvpView.getContext());
        GithubService githubService = application.getGithubService();
        subscription = githubService.userFromUrl(userUrl)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(application.defaultSubscribeScheduler())
                .subscribe(new Action1<User>() {
                    @Override
                    public void call(User user) {
                        Log.i(TAG, "Dados carregados" + user);
                        repositoryMvpView.showOwner(user);
                    }
                });
    }
}
