package com.example.wangchujie.api;

import com.example.wangchujie.bean.FindBean;
import com.example.wangchujie.bean.ImgBean;
import com.example.wangchujie.bean.TextBean;
import com.example.wangchujie.bean.VideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String imgUrl = "http://123.56.232.18:8080/";
    String videoUrl = "http://123.56.232.18:8080/";
    String textUrl = "http://123.56.232.18:8080/";
    String findUrl = "http://123.56.232.18:8080/";

    @GET("serverdemo/feeds/queryHotFeedsList?feedType=pics")
    Observable<ImgBean> getImg(@Query("pageCount") int page);

    @GET("serverdemo/feeds/queryHotFeedsList?feedType=video")
    Observable<VideoBean> getVideo(@Query("pageCount") int page);

    @GET("serverdemo/feeds/queryHotFeedsList?feedType=text&feedId=1578920275")
    Observable<TextBean> getText(@Query("pageCount") int page);

    @GET("serverdemo//tag/queryTagList")
    Observable<FindBean> getFind();
}
