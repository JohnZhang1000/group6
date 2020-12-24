package com.example.code.mvp.model;

import com.example.code.bean.HotBean;
import com.example.code.callback.RxObserverCallBack;

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
                        callBack.onSuccessData(value);
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
