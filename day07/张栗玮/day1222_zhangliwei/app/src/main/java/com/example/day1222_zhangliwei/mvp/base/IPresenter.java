package com.example.day1222_zhangliwei.mvp.base;

public interface IPresenter<T> {
    void start();
    void start(T...t);
}
