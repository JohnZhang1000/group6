package com.example.application.moudle;

import com.example.application.Aserver;
import com.example.application.Baner;
import com.example.application.LIstBean;
import com.example.application.callback.Callback;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Moudle {
    public void morbaner(final Callback callback){
        new Retrofit.Builder()
                .baseUrl(Aserver.baner)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Aserver.class)
                .getBner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Baner>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Baner value) {
                        List<Baner.DataBean> data = value.getData();
                        callback.baner((Baner) data);

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.shi(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void morList(final Callback callback){
        new Retrofit.Builder()
                .baseUrl(Aserver.list)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Aserver.class)
                .getList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LIstBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LIstBean value) {
                        List<LIstBean.TrailersBean> trailers = value.getTrailers();
                        callback.list((LIstBean) trailers);

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.shi(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}

