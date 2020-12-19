package com.example.day1218_04tongpao;

import com.example.day1218_04tongpao.bean.ActivityBean;
import com.example.day1218_04tongpao.bean.AssociationBean;
import com.example.day1218_04tongpao.bean.HotBean;
import com.example.day1218_04tongpao.bean.MakeBean;
import com.example.day1218_04tongpao.bean.PicBean;
import com.example.day1218_04tongpao.bean.TitleBean;
import com.example.day1218_04tongpao.bean.WikiBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
//http://cdwan.cn:7000/tongpao/discover/hot_activity.json  //活动
//http://cdwan.cn:7000/tongpao/discover/navigation.json // 标题
//http://cdwan.cn:7000/tongpao/discover/news_1.json   //热点
//http://cdwan.cn:7000/tongpao/discover/news_2.json  //造妆
//http://cdwan.cn:7000/tongpao/discover/news_3.json  //图上
//http://cdwan.cn:7000/tongpao/discover/news_4.json  //百科
//http://cdwan.cn:7000/tongpao/discover/association.json //社团

    public static final String BASE_URL = "http://cdwan.cn:7000/";

    @GET("tongpao/discover/hot_activity.json")
    Observable<ActivityBean> getActivity();
    @GET("tongpao/discover/navigation.json")
    Observable<TitleBean> getTitle();
    @GET("tongpao/discover/news_1.json")
    Observable<HotBean> getHot();
    @GET("tongpao/discover/news_2.json")
    Observable<MakeBean> getMake();
    @GET("tongpao/discover/news_3.json")
    Observable<PicBean> getPic();
    @GET("tongpao/discover/news_4.json")
    Observable<WikiBean> getWiki();
    @GET("tongpao/discover/association.json")
    Observable<AssociationBean> getAssociation();
}
