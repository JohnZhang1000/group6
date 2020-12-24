package com.example.code.base;

interface IBaseView<T> {
    void onSuccess(T t);
    void onFail(String msg);
}
