package com.example.chuanzhi.mvp.base;

public interface IBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
}