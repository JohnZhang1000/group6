package com.example.chuanzhi.mvp.callback;

public interface RxCallBack<T> {
    void onSuccessData(T t);
    void onErrorMsg(String msg);
}