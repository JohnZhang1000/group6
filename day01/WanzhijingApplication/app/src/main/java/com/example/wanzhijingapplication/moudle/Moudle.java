package com.example.wanzhijingapplication.moudle;

import com.example.wanzhijingapplication.Aserver;
import com.example.wanzhijingapplication.bean.Shipin;
import com.example.wanzhijingapplication.bean.Tu;
import com.example.wanzhijingapplication.bean.WenBen;
import com.example.wanzhijingapplication.bean.WodeBean;
import com.example.wanzhijingapplication.callback.Callback;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Moudle {
    public void mortu(final Callback callback){
        new Retrofit.Builder()
                .baseUrl(Aserver.tu)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Aserver.class)
                .gettu()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Tu>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Tu value) {
                        callback.tupian(value);

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
    public void morshipin(final Callback callback){
        new Retrofit.Builder()
                .baseUrl(Aserver.shipin)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Aserver.class)
                .getshipin()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Shipin>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Shipin value) {
                        callback.shipin(value);

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
    public void morwenzi(final Callback callback){
        new Retrofit.Builder()
                .baseUrl(Aserver.wenben)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Aserver.class)
                .getwen()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WenBen>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WenBen value) {
                        callback.wenben(value);

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
    public void mor(final Callback callback){
        new Retrofit.Builder()
                .baseUrl(Aserver.wode)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Aserver.class)
                .getwode()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WodeBean value) {
                        callback.wode(value);

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
