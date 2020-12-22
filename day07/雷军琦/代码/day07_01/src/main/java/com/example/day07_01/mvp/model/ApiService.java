package com.example.day07_01.mvp.model;

import com.example.day07_01.mvp.model.bean.HotBean;
import com.example.day07_01.mvp.model.bean.IevelBean;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    public static final String BASE_URL="http://cdwan.cn:7000/";

    @GET("tongpao/discover/hot_activity.json")
    Observable<HotBean> getHot();

    @GET("tongpao/discover/rank_level.json")
    Observable<IevelBean> getLevel();
}
