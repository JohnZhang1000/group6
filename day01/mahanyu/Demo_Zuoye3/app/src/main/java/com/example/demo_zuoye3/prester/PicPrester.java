package com.example.demo_zuoye3.prester;

import com.example.demo_zuoye3.callback.ResultBack;
import com.example.demo_zuoye3.model.PicModel;
import com.example.demo_zuoye3.view.IView;

public class PicPrester {
    private IView iView;
    private final PicModel picModel;

    public PicPrester(IView iView) {
        this.iView = iView;
        picModel = new PicModel();
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
