package com.example.demo_mvp.mvp.presenter;

import com.example.demo_mvp.base.BasePresenter;
import com.example.demo_mvp.callback.RxCallBack;
import com.example.demo_mvp.mvp.model.HomeModel;
import com.example.demo_mvp.mvp.ui.fragment.HomeFragment;

public class HomePresenter extends BasePresenter {
    private HomeFragment homeFragment;
    private final HomeModel homeModel;

    public HomePresenter(HomeFragment homeFragment) {

        this.homeFragment = homeFragment;
        homeModel = new HomeModel();
    }

    @Override
    public void start() {
        homeModel.requestData(new RxCallBack() {
            @Override
            public void onSuccessData(Object o) {
              homeFragment.onSuccess(o);
            }

            @Override
            public void onErrorMsg(String msg) {
                homeFragment.onError(msg);
            }
        });
    }
}
