package com.example.demo_zuoye4.model;


import com.example.demo_zuoye4.bean.HotBean;
import com.example.demo_zuoye4.bean.ItemBean;
import com.example.demo_zuoye4.bean.TabBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    public static String BASE_URL="http://cdwan.cn:7000/tongpao/";
    @GET("discover/hot_activity.json")
    Observable<HotBean> getHotData();
    @GET("discover/navigation.json")
    Observable<TabBean> getTAbData();

}
