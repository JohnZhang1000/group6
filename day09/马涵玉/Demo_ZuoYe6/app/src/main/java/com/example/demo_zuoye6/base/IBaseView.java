package com.example.demo_zuoye6.base;

public interface IBaseView<T> {
    void onSuccess(T t);
    void onError(String msg);
}
