package com.example.zuoye.mvp.model;

import android.util.Log;

import com.example.zuoye.mvp.callback.ResultCallBack;
import com.example.zuoye.mvp.model.bean.PictureBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragModel {
    public void StaticPicture(final ResultCallBack callBack){
        new Retrofit.Builder().
                baseUrl(ApiService.BASE_URL1).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                build().create(ApiService.class).getPicture().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<PictureBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(PictureBean value) {
                if (callBack!=null){
                    callBack.SuccessData(value);
                    Log.e("TAG","图片数据请求成功");
                }
            }

            @Override
            public void onError(Throwable e) {
                if (callBack!=null){
                    callBack.FileData(e.getMessage());
                    Log.e("TAG","图片数据请求失败");
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }

}
