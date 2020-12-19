package com.example.tongpaoapplication;

import com.example.tongpaoapplication.bean.Fenlei;
import com.example.tongpaoapplication.bean.QianBean;
import com.example.tongpaoapplication.bean.Remenbean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Aserver {
    String tu="http://cdwan.cn:7000/tongpao/";
    @GET("discover/hot_activity.json")
    Observable<Remenbean>getRemen();

    String qian="http://cdwan.cn:7000/tongpao/";
    @GET("discover/navigation.json ")
    Observable<QianBean>getqian();

    String fenlei="http://cdwan.cn:7000/tongpao/";
    @GET("discover/news_{path}.json")
    Observable<Fenlei>getfen(@Path("path") int path);

}
