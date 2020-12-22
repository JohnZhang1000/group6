package com.example.day07_01.mvp.presenter;

import com.example.day07_01.mvp.callback.ResultCallBack;
import com.example.day07_01.mvp.model.FragModel;
import com.example.day07_01.mvp.view.IView;


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
    public void StaticLevel(){
        fragModel.getLevel(new ResultCallBack() {
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
