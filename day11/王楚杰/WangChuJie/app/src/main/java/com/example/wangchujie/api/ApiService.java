package com.example.wangchujie.api;

import com.example.wangchujie.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {


    String sUrl = "http://cdwan.cn:7000/";

    @GET("tongpao/home/recommend.json")
    Observable<Bean> getData();
}
