package com.example.demo_mvp.base;

public interface IBaseView<T> {
    void onSuccess(T t);
    void onError(String msg);
}
