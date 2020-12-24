package com.umeng.mvp_chouqu.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}