package com.example.day1218_04tongpao.presenter;

import com.example.day1218_04tongpao.model.MyModel;
import com.example.day1218_04tongpao.model.ResultCallBack;
import com.example.day1218_04tongpao.view.IView;

public class MyPresenter {
    private IView iView;
    private final MyModel myModel;

    public MyPresenter(IView iView) {
        this.iView = iView;
        myModel = new MyModel();
    }
    public void getData(){
        myModel.getRxData(new ResultCallBack() {
            @Override
            public void getSuccessData(Object obj) {
                iView.getSuccessUi(obj);
            }

            @Override
            public void getFailData(String msg) {
                iView.getFailUi(msg);

            }
        });


    }
}
