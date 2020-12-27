package com.example.demo_zuoye6.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}