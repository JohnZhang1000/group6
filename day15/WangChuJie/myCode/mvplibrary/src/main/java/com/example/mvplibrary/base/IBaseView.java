package com.example.mvplibrary.base;

public interface IBaseView<T> {
    void onSuccess(T t);
    void onFail(String msg);
}
