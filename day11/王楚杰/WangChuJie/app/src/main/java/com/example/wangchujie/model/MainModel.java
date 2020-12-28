package com.example.wangchujie.model;

import android.util.Log;

import com.example.wangchujie.api.ApiService;
import com.example.wangchujie.bean.Bean;
import com.example.wangchujie.callBack.ResultCallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel {
    public void getData(ResultCallBack<Bean> callBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.sUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Bean bean) {
                        callBack.onSuccess(bean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callBack.onFail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
