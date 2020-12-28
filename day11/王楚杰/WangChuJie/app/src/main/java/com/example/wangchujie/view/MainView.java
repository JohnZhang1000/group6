package com.example.wangchujie.view;

import com.example.wangchujie.bean.Bean;

public interface MainView {

    void success(Bean bean);

    void fail(String msg);
}
