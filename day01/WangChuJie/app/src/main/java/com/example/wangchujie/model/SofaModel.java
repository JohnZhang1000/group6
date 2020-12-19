package com.example.wangchujie.model;

import com.example.wangchujie.api.ApiService;
import com.example.wangchujie.bean.ImgBean;
import com.example.wangchujie.bean.TextBean;
import com.example.wangchujie.bean.VideoBean;
import com.example.wangchujie.callBack.ResultCallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SofaModel {
    public void getImg(int pageCount, final ResultCallBack<ImgBean> callBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.imgUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getImg(pageCount)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ImgBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ImgBean imgBean) {
                        callBack.onSuccess(imgBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getVideo(final ResultCallBack<VideoBean> callBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.videoUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getVideo(12)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<VideoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideoBean videoBean) {
                        callBack.onSuccess(videoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getText(int pageCount, final ResultCallBack<TextBean> callBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.textUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getText(pageCount)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<TextBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TextBean textBean) {
                        callBack.onSuccess(textBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
