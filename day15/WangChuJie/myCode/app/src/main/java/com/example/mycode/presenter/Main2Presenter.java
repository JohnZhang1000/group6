package com.example.mycode.presenter;

import com.example.mycode.MainActivity;
import com.example.mycode.bean.TopicBean;
import com.example.mycode.callBack.ResultCalBack;
import com.example.mycode.model.MainModel;
import com.example.mycode.view.MainView;

public class Main2Presenter {

    private final MainView view;
    private final MainModel mainModel;

    public Main2Presenter(MainView view) {
        this.view = view;
        mainModel = new MainModel();
    }

    public void getData() {
        mainModel.getData(new ResultCalBack() {
            @Override
            public void getData(TopicBean topicBean) {
                view.success(topicBean);
            }

            @Override
            public void onFail(String msg) {
                view.fail(msg);
            }
        });
    }
}
