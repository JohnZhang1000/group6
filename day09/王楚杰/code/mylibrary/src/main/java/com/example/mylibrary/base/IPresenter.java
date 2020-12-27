package com.example.mylibrary.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}