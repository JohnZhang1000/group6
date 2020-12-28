package com.example.wangchujie.callBack;

import com.example.wangchujie.bean.Bean;

public interface ResultCallBack<T> {

    void onSuccess(T t);
    void onFail(String msg);
}
