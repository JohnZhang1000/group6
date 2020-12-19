package com.example.demo_zuoye3.model;

import com.example.demo_zuoye3.bean.FindBean;
import com.example.demo_zuoye3.bean.ImageBean;
import com.example.demo_zuoye3.bean.TextBean;
import com.example.demo_zuoye3.bean.ViewoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    public static String BASE_URL="http://123.56.232.18:8080/";
    @GET("serverdemo/feeds/queryHotFeedsList")
    Observable<ImageBean> getData(@Query("pageCount") int count, @Query("feedType") String type);
    public static String BASE_URL1="http://123.56.232.18:8080/";
    @GET("serverdemo/feeds/queryHotFeedsList")
    Observable<ViewoBean> getdata(@Query("pageCount") int count, @Query("feedType") String type);
    public static String BASE_URL2="http://123.56.232.18:8080/";
    @GET("serverdemo/feeds/queryHotFeedsList")
    Observable<TextBean> getTextData(@Query("pageCount") int count, @Query("feedType") String type, @Query("feedId") String id);
    public static String BASE_URL3="http://123.56.232.18:8080/";
    @GET("serverdemo//tag/queryTagList")
    Observable<FindBean> geFindData();

}
