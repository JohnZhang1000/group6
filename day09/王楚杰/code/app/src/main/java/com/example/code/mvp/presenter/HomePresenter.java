package com.example.code.mvp.presenter;


import com.example.mylibrary.base.BasePresenter;
import com.example.code.callback.RxObserverCallBack;
import com.example.code.mvp.model.HomeModel;
import com.example.code.mvp.ui.fragment.HomeFragment;

import io.reactivex.disposables.Disposable;

public class HomePresenter extends BasePresenter {
    private HomeModel model;
    private HomeFragment mFragment;

    public HomePresenter(HomeFragment fragment) {
        this.mFragment = fragment;
        model = new HomeModel();
    }

    @Override
    public void start() {
        //2.P层收到指令之后要向M层进行进行数据请求
        model.requestData(new RxObserverCallBack() {
            @Override
            public void onSuccessData(Object o) {

                //4.P层再将数据交给V层更新UI
                mFragment.onSuccess(o);
            }

            @Override
            public void onErrorMsg(String msg) {
                //4.P层再将数据交给V层更新UI
                mFragment.onFail(msg);
            }

            @Override
            public void onSubscribe(Disposable disposable) {
                addDisposable(disposable);
            }
        });
    }
}