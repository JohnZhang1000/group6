package com.example.wangchujie.api;

import com.example.wangchujie.bean.HotBean;
import com.example.wangchujie.bean.TabBean;
import com.example.wangchujie.bean.TvBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    String sUrl = "http://cdwan.cn:7000/tongpao/";



    @GET("discover/hot_activity.json")
    Flowable<HotBean> getHot();

    @GET("discover/navigation.json ")
    Flowable<TabBean> getNav();

    @GET("discover/news_{type}.json")
    Flowable<TvBean> getData(@Path("type") int type);
}
