package com.example.zuoye.mvp.persenter;

import com.example.zuoye.mvp.callback.ResultCallBack;
import com.example.zuoye.mvp.model.FragModel;
import com.example.zuoye.mvp.view.IView;

public class FragPersenter {
    private final FragModel fragModel;
    private IView iView;

    public FragPersenter(IView iView) {
        this.iView = iView;
        fragModel = new FragModel();
    }
    public void Picture(){
        fragModel.StaticPicture(new ResultCallBack() {
            @Override
            public void SuccessData(Object object) {
                iView.ShowScuessUi(object);
            }

            @Override
            public void FileData(String err) {
                iView.ShowFileUi(err);
            }
        });
    }
}
