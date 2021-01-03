package com.example.chuanzhi.mvp.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}