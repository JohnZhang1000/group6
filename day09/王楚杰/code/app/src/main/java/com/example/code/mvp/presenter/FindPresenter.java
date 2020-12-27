package com.example.code.mvp.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.code.bean.HotBean;
import com.example.code.callback.RxObserverCallBack;
import com.example.code.mvp.model.FindModel;
import com.example.code.mvp.ui.fragment.FindFragment;

import io.reactivex.disposables.Disposable;

public class FindPresenter extends BasePresenter {

    private final FindFragment findFragment;
    private final FindModel findModel;

    public FindPresenter(FindFragment fragment) {
        this.findFragment = fragment;
        findModel = new FindModel();
    }

    @Override
    public void start() {
        findModel.getHot(new RxObserverCallBack<HotBean>() {
            @Override
            public void onSuccessData(HotBean hotBean) {
                findFragment.onSuccess(hotBean);
            }

            @Override
            public void onErrorMsg(String msg) {
                findFragment.onFail(msg);
            }

            @Override
            public void onSubscribe(Disposable disposable) {
                addDisposable(disposable);
            }
        });
    }
}
