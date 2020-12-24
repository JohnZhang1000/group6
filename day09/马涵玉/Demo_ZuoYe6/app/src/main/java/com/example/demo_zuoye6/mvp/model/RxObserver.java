package com.example.demo_zuoye6.mvp.model;

import android.util.Log;


import com.example.demo_zuoye6.R;
import com.example.demo_zuoye6.base.App;
import com.example.demo_zuoye6.callback.RxObserverCallBack;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.net.ConnectException;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxObserver<T> implements Observer {
    private RxObserverCallBack<T> callBack;


    public RxObserver(RxObserverCallBack<T> callBack) {
        this.callBack = callBack;
    }


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(Object value) {
        callBack.onSuccessData((T) value);
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof IOException) {
            callBack.onErrorMsg(getString(R.string.connec_exception));
        } else if (e instanceof JsonParseException) {
            callBack.onErrorMsg(getString(R.string.json_parse_exception));
        } else if (e instanceof SSLException) {
            callBack.onErrorMsg(getString(R.string.ssl_exception));
        }
    }

    private String getString(int p) {
        return App.context().getString(p);
    }


    @Override
    public void onComplete() {
Log.e("TAG",App.getStr(R.string.complete));
    }
}