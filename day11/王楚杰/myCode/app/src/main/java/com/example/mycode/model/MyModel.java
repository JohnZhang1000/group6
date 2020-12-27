package com.example.mycode.model;

import com.example.mvplibrary.callback.RxObserverCallBack;
import com.example.mvplibrary.mvp.model.api.ApiService;
import com.example.mvplibrary.mvp.model.constants.ApiConstants;
import com.example.mycode.Bean;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {

    public void getData(RxObserverCallBack<Bean> callBack) {
        new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiConstants.sUrl)
                .build()
                .create(ApiService.class)
                .requestGetData("project/list/1/json?cid=294")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        callBack.onSubscribe(d);
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            callBack.onSuccessData(new Gson().fromJson(value.string(),Bean.class));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onErrorMsg(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
