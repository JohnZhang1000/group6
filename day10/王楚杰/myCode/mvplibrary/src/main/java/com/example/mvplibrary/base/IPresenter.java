package com.example.mvplibrary.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}