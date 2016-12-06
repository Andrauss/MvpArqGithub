package com.br.fandrauss.mvprxarq.presenter;

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

}
