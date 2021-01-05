package com.example.mycode.api;

import com.example.mycode.bean.TopicBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String sUrl = "http://cdwan.cn:7000/tongpao/";

    @GET("home/topic_discussed.json")
    Observable<TopicBean> getData();
}
