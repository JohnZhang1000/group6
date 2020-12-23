package com.example.day1222_zhangliwei.mvp.base;

public interface IBaseView<T> {
    void onSuccess(T t);
    void onError(String msg);
}
