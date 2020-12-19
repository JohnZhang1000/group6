package com.example.demo_zuoye3.model;

import android.util.Log;

import com.example.demo_zuoye3.bean.FindBean;
import com.example.demo_zuoye3.bean.ImageBean;
import com.example.demo_zuoye3.bean.TextBean;
import com.example.demo_zuoye3.bean.ViewoBean;
import com.example.demo_zuoye3.callback.ResultBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PicModel {
    public void RequestData(final ResultBack resultBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getData(12, "pics")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ImageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ImageBean value) {
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
                .baseUrl(ApiService.BASE_URL1)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getdata(12, "video")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ViewoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ViewoBean value) {
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
        new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL2)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getTextData(10, "text","1578920275")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TextBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TextBean value) {
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
        new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL3)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .geFindData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindBean value) {
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
