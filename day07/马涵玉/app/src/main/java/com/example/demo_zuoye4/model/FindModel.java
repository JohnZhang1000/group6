package com.example.demo_zuoye4.model;

import android.util.Log;


import com.example.demo_zuoye4.bean.HotBean;
import com.example.demo_zuoye4.bean.TabBean;
import com.example.demo_zuoye4.callback.ResultBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FindModel {
    public void RequestData(final ResultBack resultBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getHotData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotBean value) {
                        if (resultBack != null) {
                            resultBack.SuccessData(value);
                            Log.e("TAG", "成功" + value.toString());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (resultBack != null) {
                            resultBack.FailData(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getTAbData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TabBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TabBean value) {
                        if (resultBack != null) {
                            resultBack.SuccessData(value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (resultBack != null) {
                            resultBack.FailData(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
