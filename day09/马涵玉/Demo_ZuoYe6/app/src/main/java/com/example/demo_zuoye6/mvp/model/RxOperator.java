package com.example.demo_zuoye6.mvp.model;



import com.example.demo_zuoye6.callback.RxObserverCallBack;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * 用来封装各种操作符
 */
public class RxOperator {
    //封装了线程切换
   public static Observable threadtransformer(Observable observable){
       return observable.subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());
   }
        //封装了ConCatMap操作符 网络嵌套(注册完成之后自动启动)
    public <T> ObservableSource concatMap(Observable<T> registerObservable,
                                          Observable<T> loginObservable, RxObserverCallBack<T> callBack) {
        return threadtransformer(registerObservable).
                doOnNext(obj -> {
                    callBack.onSuccessData((T) obj);
                }).
                observeOn(Schedulers.io())
                .concatMap(obj -> {
                    return loginObservable;
                });

    }
}