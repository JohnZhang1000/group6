package com.example.wangchujie.presenter;

import com.example.wangchujie.MainActivity;
import com.example.wangchujie.bean.Bean;
import com.example.wangchujie.callBack.ResultCallBack;
import com.example.wangchujie.model.MainModel;
import com.example.wangchujie.view.MainView;

public class MainPresenter {

    private final MainView view;
    private final MainModel mainModel;

    public MainPresenter(MainView view) {
        this.view = view;
        mainModel = new MainModel();
    }

    public void getData() {
        mainModel.getData(new ResultCallBack<Bean>() {
            @Override
            public void onSuccess(Bean bean) {
                view.success(bean);
            }

            @Override
            public void onFail(String msg) {
                view.fail(msg);
            }
        });
    }
}
