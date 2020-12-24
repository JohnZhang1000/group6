package com.example.day09_01.mvp.base;

public interface IBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
}