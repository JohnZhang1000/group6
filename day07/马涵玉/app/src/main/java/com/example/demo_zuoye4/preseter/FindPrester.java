package com.example.demo_zuoye4.preseter;


import com.example.demo_zuoye4.callback.ResultBack;
import com.example.demo_zuoye4.model.FindModel;
import com.example.demo_zuoye4.view.IView;

public class FindPrester {
    private IView iView;
    private final FindModel picModel;

    public FindPrester(IView iView) {
        this.iView = iView;
        picModel = new FindModel();
    }

    public void start() {
        picModel.RequestData(new ResultBack() {
            @Override
            public void SuccessData(Object object) {
                iView.showSuccessUi(object);
            }

            @Override
            public void FailData(String msg) {
                iView.showFailUi(msg);
            }
        });
    }
}
