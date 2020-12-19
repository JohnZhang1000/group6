package com.umeng.zhangwentao_tongpao.api;

import com.umeng.zhangwentao_tongpao.databean.FaXianSheTuanDataBean;
import com.umeng.zhangwentao_tongpao.databean.HotDatabean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 项目名:zhangwentao_tongpao
 * 包名:com.umeng.zhangwentao_tongpao.api
 * 创建者: 张文涛
 * 创建时间: 2020/12/18
 */
public interface ApiSevercer {
    String BACE_URL ="http://cdwan.cn:7000/tongpao/";
    //热门活动
    @GET("discover/hot_activity.json")
    Observable<HotDatabean>getHot();
    //社团
    @GET("/discover/association.json")
    Observable<FaXianSheTuanDataBean>getFaXianSheTuan();

}
