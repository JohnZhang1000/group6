package com.example.wanzhijingapplication;

import com.example.wanzhijingapplication.bean.Shipin;
import com.example.wanzhijingapplication.bean.Tu;
import com.example.wanzhijingapplication.bean.WenBen;
import com.example.wanzhijingapplication.bean.WodeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Aserver {
    String tu="http://123.56.232.18:8080/serverdemo/";
    @GET("feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Observable<Tu>gettu();

    String shipin="http://123.56.232.18:8080/serverdemo/";
    @GET("feeds/queryHotFeedsList?pageCount=12&feedType=video")
    Observable<Shipin>getshipin();

    String wenben="http://123.56.232.18:8080/serverdemo/";
    @GET("feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
    Observable<WenBen>getwen();

    String wode="http://123.56.232.18:8080/";
    @GET("serverdemo//tag/queryTagList")
    Observable<WodeBean>getwode();


}
