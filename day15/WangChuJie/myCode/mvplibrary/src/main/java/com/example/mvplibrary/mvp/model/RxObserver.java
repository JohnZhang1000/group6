package com.example.mvplibrary.mvp.model;

import android.util.Log;


import com.example.mvplibrary.R;
import com.example.mvplibrary.base.App;
import com.example.mvplibrary.callback.RxObserverCallBack;
import com.google.gson.JsonParseException;

import java.io.IOException;

import javax.net.ssl.SSLException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxObserver<T> implements Observer {
    private static final String TAG = "RxObserver";
    private RxObserverCallBack<T> callBack;
    protected Disposable mDisPosable;

    public RxObserver(RxObserverCallBack<T> callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        if (callBack != null)
            this.mDisPosable = disposable;
    }

    @Override
    public void onNext(Object value) {
        if (callBack != null) {
            callBack.onSuccessData((T) value);
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof IOException) {
            if (callBack != null)
                callBack.onErrorMsg("网络链接异常");
        } else if (e instanceof JsonParseException) {
            if (callBack != null)
                callBack.onErrorMsg("json解析异常");
        } else if (e instanceof SSLException) {
            if (callBack != null)
                callBack.onErrorMsg("ssl证书异常");
        }
    }


    @Override
    public void onComplete() {
        Log.e(TAG, "网络请求完成了");
    }
}