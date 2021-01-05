package com.example.mycode.callBack;

import com.example.mycode.bean.TopicBean;

public interface ResultCalBack {
    void getData(TopicBean topicBean);
    void onFail(String msg);
}
