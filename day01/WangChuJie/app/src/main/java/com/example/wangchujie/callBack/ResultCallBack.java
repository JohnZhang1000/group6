package com.example.wangchujie.callBack;

public interface ResultCallBack<T> {
    void onSuccess(T t);
    void onFail(String msg);
}
