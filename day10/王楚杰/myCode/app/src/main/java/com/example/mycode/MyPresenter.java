package com.example.mycode;

import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.callback.RxObserverCallBack;
import com.example.mycode.fragment.HomeFragment;
import com.example.mycode.model.MyModel;

import io.reactivex.disposables.Disposable;

public class MyPresenter extends BasePresenter<myView,Bean> {

    private final HomeFragment homeFragment;
    private final MyModel myModel;

    public MyPresenter(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
        myModel = new MyModel();
    }

    @Override
    public void start() {
        super.start();
        myModel.getData(new RxObserverCallBack<Bean>() {
            @Override
            public void onSuccessData(Bean bean) {
                homeFragment.onSuccess(bean);
            }

            @Override
            public void onErrorMsg(String msg) {
                homeFragment.onFail(msg);
            }

            @Override
            public void onSubscribe(Disposable disposable) {
                addDisposable(disposable);
            }
        });
    }
}
