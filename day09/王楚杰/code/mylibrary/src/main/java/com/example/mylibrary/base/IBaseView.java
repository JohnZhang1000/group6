package com.example.mylibrary.base;

interface IBaseView<T> {
    void onSuccess(T t);
    void onFail(String msg);
}
