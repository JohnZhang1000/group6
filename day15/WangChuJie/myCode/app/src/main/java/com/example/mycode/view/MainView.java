package com.example.mycode.view;

import com.example.mycode.bean.TopicBean;

public interface MainView {
    void success(TopicBean topicBean);

    void fail(String msg);
}
