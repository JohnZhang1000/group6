package com.example.demo_mvp.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}
