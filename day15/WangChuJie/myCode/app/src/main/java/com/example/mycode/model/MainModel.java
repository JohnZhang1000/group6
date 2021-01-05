package com.example.mycode.model;

import com.example.mvplibrary.mvp.model.api.ApiService;
import com.example.mvplibrary.mvp.model.constants.ApiConstants;
import com.example.mycode.api.Api;
import com.example.mycode.bean.TopicBean;
import com.example.mycode.callBack.ResultCalBack;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel {
    public void getData(ResultCalBack calBack) {
        new Retrofit.Builder()
                .baseUrl(Api.sUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class)
                .getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<TopicBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TopicBean value) {
                        calBack.getData(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        calBack.onFail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
