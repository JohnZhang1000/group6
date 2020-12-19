package com.example.leijunqi.mvp.presenter;

import com.example.leijunqi.mvp.callback.ResultCallBack;
import com.example.leijunqi.mvp.model.FragModel;
import com.example.leijunqi.mvp.view.IView;

public class FragPresenter {
    private final FragModel fragModel;
    private IView iView;

    public FragPresenter(IView iView) {
        this.iView = iView;
        fragModel = new FragModel();
    }
    public void StaticHot(){
        fragModel.getHot(new ResultCallBack() {
            @Override
            public void SuccessData(Object object) {
                iView.ShowSuccess(object);
            }

            @Override
            public void FileData(String err) {
                iView.ShowFile(err);
            }
        });
    }

}
