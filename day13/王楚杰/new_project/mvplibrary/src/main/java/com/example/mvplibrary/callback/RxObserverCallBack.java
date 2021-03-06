package com.example.mvplibrary.callback;


import io.reactivex.disposables.Disposable;

public interface RxObserverCallBack<T> {
    void onSuccessData(T t);
    void onErrorMsg(String msg);
    void onSubscribe(Disposable disposable);
}