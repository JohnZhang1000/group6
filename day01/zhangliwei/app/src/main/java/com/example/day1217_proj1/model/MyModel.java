package com.example.day1217_proj1.model;

import android.util.Log;

import com.example.day1217_proj1.ApiService;
import com.example.day1217_proj1.ResultCallBack;
import com.example.day1217_proj1.bean.PicBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {

     public void getRxData(final ResultCallBack callBack){
         ApiService apiService = new Retrofit.Builder()
                 .baseUrl(ApiService.BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .build()
                 .create(ApiService.class);

                 //图片解析
         apiService.getDataPic(12,"pics")
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<PicBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(PicBean picBean) {
                         Log.e("TAG","解析成功");
                         if(callBack!=null){
                             callBack.getSuccessUi(picBean);
                         }

                     }

                     @Override
                     public void onError(Throwable e) {
                         Log.e("TAG","解析失败"+e.getMessage());
                         if(callBack!=null){
                             callBack.getFailUi(e.getMessage());
                         }
                     }

                     @Override
                     public void onComplete() {
                         Log.e("TAG","解析完成");
                     }
                 });
     }
}
