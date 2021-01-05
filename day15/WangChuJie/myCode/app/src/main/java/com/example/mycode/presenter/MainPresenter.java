package com.example.mycode.presenter;


import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.callback.RxObserverCallBack;
import com.example.mvplibrary.mvp.model.RxOpretorImpl;
import com.example.mvplibrary.mvp.model.constants.ApiConstants;
import com.example.mvplibrary.util.JsonUtil;
import com.example.mycode.MainActivity;
import com.example.mycode.bean.BannerBean;
import com.example.mycode.bean.TopicBean;

import java.io.IOException;

import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class MainPresenter extends BasePresenter {

    private final MainActivity mainActivity;
    private final RxOpretorImpl rxOpretor;

    public MainPresenter(MainActivity mainActivity) {
        super();
        this.mainActivity = mainActivity;
        rxOpretor = new RxOpretorImpl();
    }

    @Override
    public void start() {
        super.start();
        rxOpretor.rxGetRequest(ApiConstants.banner_Url, new RxObserverCallBack() {
            @Override
            public void onSuccessData(Object o) {
                ResponseBody responseBody = (ResponseBody) o;
                try {
                    BannerBean bean = JsonUtil.getJson(responseBody.string(), BannerBean.class);
                    mainActivity.onSuccess(bean);
                } catch (IOException e) {
                    e.printStackTrace();
                    mainActivity.onFail(e.toString());
                }

            }

            @Override
            public void onErrorMsg(String msg) {
                mainActivity.onFail(msg);
            }

            @Override
            public void onSubscribe(Disposable disposable) {
                addDisposable(disposable);
            }
        });

    }


}
