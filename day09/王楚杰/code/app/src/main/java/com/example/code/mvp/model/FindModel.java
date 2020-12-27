package com.example.code.mvp.model;

import com.example.code.bean.HotBean;
import com.example.code.callback.RxObserverCallBack;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class FindModel {
    public void getHot(RxObserverCallBack<HotBean> callBack) {

        new OkManager().proApiService()
                .requestGetData("discover/hot_activity.json")
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
                            String string = value.string();
                            HotBean hotBean = new Gson().fromJson(string, HotBean.class);
                            callBack.onSuccessData(hotBean);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
