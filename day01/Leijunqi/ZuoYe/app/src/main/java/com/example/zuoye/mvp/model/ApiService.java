package com.example.zuoye.mvp.model;

import com.example.zuoye.mvp.model.bean.PictureBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    public static final String BASE_URL1="http://123.56.232.18:8080/";

    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Observable<PictureBean> getPicture();
}
