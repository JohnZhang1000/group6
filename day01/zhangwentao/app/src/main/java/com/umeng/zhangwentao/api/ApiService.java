package com.umeng.zhangwentao.api;

import com.umeng.zhangwentao.fragment.faxian.FaXianTuiJianDataBean;
import com.umeng.zhangwentao.fragment.shafa.databean.ShaFaTextDataBean;
import com.umeng.zhangwentao.fragment.shafa.databean.ShaFaTuPianDataBean;
import com.umeng.zhangwentao.fragment.shafa.databean.ShaFaVideoDataBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 项目名:zhangwentao
 * 包名:com.umeng.zhangwentao.api
 * 创建者: 张文涛
 * 创建时间: 2020/12/17
 */
public interface ApiService {
    String BASE_URL="http://123.56.232.18:8080/serverdemo/";
    //沙发图片url
    @GET("feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Observable<ShaFaTuPianDataBean>getShaFaTuPian();
    //沙发视频url
    @GET("feeds/queryHotFeedsList?pageCount=12&feedType=video")
    Observable<ShaFaVideoDataBean>getShaFaVideo();
    //沙发文本url
    @GET("feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
    Observable<ShaFaTextDataBean>getShaFaText();
    //发现推荐url
    @GET("tag/queryTagList")
    Observable<FaXianTuiJianDataBean>getFaXianTuiJian();
}
