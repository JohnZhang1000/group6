package com.example.demo_mvp.callback;

public interface RxCallBack<T> {
    void onSuccessData(T t);
    void  onErrorMsg(String msg);
}
