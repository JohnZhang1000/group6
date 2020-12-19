package com.example.wangchujie.presenter;


import com.example.wangchujie.bean.ImgBean;
import com.example.wangchujie.bean.TextBean;
import com.example.wangchujie.bean.VideoBean;
import com.example.wangchujie.callBack.ResultCallBack;
import com.example.wangchujie.model.SofaModel;
import com.example.wangchujie.view.SofaView;

public class SofaPresenter {

    private final SofaView view;
    private final SofaModel sofaModel;

    public SofaPresenter(SofaView view) {
        this.view = view;
        sofaModel = new SofaModel();
    }

    public void getImg(int pageCount) {
        sofaModel.getImg(pageCount,new ResultCallBack<ImgBean>() {
            @Override
            public void onSuccess(ImgBean imgBean) {
                view.success(imgBean);
            }

            @Override
            public void onFail(String msg) {
                view.fail(msg);
            }
        });
    }

    public void getVideo() {
        sofaModel.getVideo(new ResultCallBack<VideoBean>() {
            @Override
            public void onSuccess(VideoBean videoBean) {
                view.getVideo(videoBean);
            }

            @Override
            public void onFail(String msg) {
                view.fail(msg);
            }
        });
    }

    public void getText(int pageCount) {
        sofaModel.getText(pageCount,new ResultCallBack<TextBean>() {
            @Override
            public void onSuccess(TextBean textBean) {
                view.getText(textBean);
            }

            @Override
            public void onFail(String msg) {
                view.fail(msg);
            }
        });
    }
}
