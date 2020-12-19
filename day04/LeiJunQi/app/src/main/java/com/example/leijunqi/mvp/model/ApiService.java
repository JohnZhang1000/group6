package com.example.leijunqi.mvp.model;

import com.example.leijunqi.mvp.model.bean.HotBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    public static final String BASE_URL="http://cdwan.cn:7000/";

    @GET("tongpao/discover/hot_activity.json")
    Observable<HotBean> getHot();
}
