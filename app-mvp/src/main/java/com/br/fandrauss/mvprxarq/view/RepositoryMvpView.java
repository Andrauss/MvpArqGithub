package com.br.fandrauss.mvprxarq.view;

import com.br.fandrauss.mvprxarq.model.User;

public interface RepositoryMvpView extends MvpView {

    void showOwner(final User owner);

}
