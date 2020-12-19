package com.example.day1217_proj1;

import com.example.day1217_proj1.bean.FindBean;
import com.example.day1217_proj1.bean.PicBean;
import com.example.day1217_proj1.bean.TextBean;
import com.example.day1217_proj1.bean.VideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
   // http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics  沙发—图片
   // http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video 沙发—视频
   // http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275 沙发— 文本
   // http://123.56.232.18:8080/serverdemo//tag/queryTagList          发现—推荐
    public static final String BASE_URL = "http://123.56.232.18:8080/serverdemo/";
    @GET("feeds/queryHotFeedsList")
    Observable<PicBean> getDataPic(@Query("pageCount")int pageCount,@Query("feedType")String feedType);
    @GET("feeds/queryHotFeedsList")
    Observable<VideoBean> getDataVideo(@Query("pageCount")int pageCount, @Query("feedType")String feedType);
    @GET("feeds/queryHotFeedsList")
    Observable<TextBean> getDataText(@Query("pageCount")int pageCount,
                                     @Query("feedType")String feedType,@Query("feedId")int feedId);
    @GET("/tag/queryTagList")
    Observable<FindBean> getDataFind();

}
