package com.example.wangchujie.view;

import com.example.wangchujie.bean.ImgBean;
import com.example.wangchujie.bean.TextBean;
import com.example.wangchujie.bean.VideoBean;

public interface SofaView {
    void success(ImgBean imgBean);

    void fail(String msg);

    void getVideo(VideoBean videoBean);

    void getText(TextBean textBean);
}
