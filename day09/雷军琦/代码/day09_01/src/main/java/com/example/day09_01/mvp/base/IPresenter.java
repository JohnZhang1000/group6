package com.example.day09_01.mvp.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}