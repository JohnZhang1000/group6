package com.example.tongpaoapplication.moudel;

import com.example.tongpaoapplication.Aserver;
import com.example.tongpaoapplication.bean.Fenlei;
import com.example.tongpaoapplication.bean.Remenbean;
import com.example.tongpaoapplication.callback.Callback;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Moudle {
    public void morremrn(final Callback callback){
        new Retrofit.Builder()
                .baseUrl(Aserver.tu)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Aserver.class)
                .getRemen()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Remenbean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Remenbean value) {
                        callback.renmen(value);

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
    public void porfen(int path,final Callback callback){
        new Retrofit.Builder()
                .baseUrl(Aserver.fenlei)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Aserver.class)
                .getfen(path)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Fenlei>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Fenlei value) {
                        callback.fenlei(value);

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
