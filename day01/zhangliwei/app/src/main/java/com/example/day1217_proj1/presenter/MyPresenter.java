package com.example.day1217_proj1.presenter;

import com.example.day1217_proj1.ResultCallBack;
import com.example.day1217_proj1.model.MyModel;
import com.example.day1217_proj1.view.IView;

public class MyPresenter {
    private IView iView;
    private final MyModel myModel;

    public MyPresenter(IView iView) {
        this.iView = iView;
        myModel = new MyModel();

    }
    public void startChange(){
        myModel.getRxData(new ResultCallBack() {
            @Override
            public void getSuccessUi(Object obj) {
                iView.getSuccessUi(obj);
            }

            @Override
            public void getFailUi(String msg) {
                iView.getFailUi(msg);

            }
        });
    }
}
