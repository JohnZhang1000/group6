package com.example.day1218_04tongpao.model;

import android.util.Log;

import com.example.day1218_04tongpao.ApiService;
import com.example.day1218_04tongpao.bean.ActivityBean;
import com.example.day1218_04tongpao.bean.HotBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {
    //获取网络数据
    public void getRxData(final ResultCallBack callBack){
        ApiService apiService = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);
        //列表活动解析
                apiService.getActivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ActivityBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ActivityBean activityBean) {
                        Log.e("TAG","解析成功");
                        if(callBack!=null){
                            callBack.getSuccessData(activityBean);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG","解析失败");
                        if(callBack!=null){
                            callBack.getFailData(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG","解析完成");
                    }
                });
                //竖直列表
        apiService.getHot()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        Log.e("TAG","解析hot列表成功");
                        if(callBack!=null){
                            callBack.getSuccessData(hotBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG","解析hot列表失败");
                        if(callBack!=null){
                            callBack.getFailData(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG","解析hot列表完成");
                    }
                });



    }
}
