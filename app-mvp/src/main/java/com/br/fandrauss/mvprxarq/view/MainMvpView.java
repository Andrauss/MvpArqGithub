package com.br.fandrauss.mvprxarq.view;

import java.util.List;

import com.br.fandrauss.mvprxarq.model.Repository;

public interface MainMvpView extends MvpView {

    void showRepositories(List<Repository> repositories);

    void showMessage(int stringId);

    void showProgressIndicator();
}
