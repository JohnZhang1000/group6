package com.example.application;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Aserver {
    String tab="https://www.wanandroid.com/";
    @GET("project/tree/json")
    Observable<Grlis> getTabean();

    String baner="https://www.wanandroid.com/";
    @GET("banner/json")
    Observable<Baner>getBner();

    String list="http://api.m.mtime.cn/";
    @GET("PageSubArea/TrailerList.api")
    Observable<LIstBean>getList();
}
