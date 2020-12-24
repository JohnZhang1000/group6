package com.example.code.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}