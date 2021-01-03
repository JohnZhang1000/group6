package com.example.chuanzhi.mvp.mvp.model;

import com.example.mvp.di.component.OkComponent;
import com.example.mvp.mvp.model.api.ApiService;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class RxOpretorImpl {
    @Inject
    ApiService mApiService;

    public RxOpretorImpl() {

    }

    //封装一个get请求的方法
    public void requestData(String url) {
        RxOperator.threadtransformer(mApiService.requestGetData(url)).
                subscribe();

    }


    //封装一个get请求的方法
    public <T> void requestData(String url, Map<String,T> params) {
         RxOperator.threadtransformer(mApiService.requestGetData(url,params)).
                 subscribe();




    }



}