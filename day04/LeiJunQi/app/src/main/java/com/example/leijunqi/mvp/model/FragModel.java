package com.example.leijunqi.mvp.model;

import com.example.leijunqi.mvp.callback.ResultCallBack;
import com.example.leijunqi.mvp.model.bean.HotBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragModel {
    public void getHot(final ResultCallBack callBack){
        new Retrofit.Builder().
                baseUrl(ApiService.BASE_URL).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).
                build().create(ApiService.class).getHot().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<HotBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HotBean value) {
                if (callBack!=null){
                    callBack.SuccessData(value);
                }
            }

            @Override
            public void onError(Throwable e) {
                if (callBack!=null){
                    callBack.FileData(e.getMessage());
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
