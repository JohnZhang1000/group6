package com.example.day1222_zhangliwei.mvp.mvp.model.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {
    //没有任何参数的get请求
    @GET
    Observable<ResponseBody> requestGetData(@Url String url);

    //没有任何参数但是有请求头的get请求
    @GET
    <T> Observable<ResponseBody> requestGetData(@Url String url, @HeaderMap HashMap<String, T> headers);

    //只有参数的get请求
    @GET
    <T> Observable<ResponseBody> requestGetData(@Url String url, @QueryMap Map<String, T> params);


    //既有请求头也有参数的get请求
    @GET
    <T> Observable<ResponseBody> requestGetData(@Url String url,
                                                @HeaderMap Map<String, T> headers,
                                                @QueryMap Map<String, T> params);

    //请求体是键值对的请求

    //没有参数的post请求
    @POST
    @FormUrlEncoded
    Observable<ResponseBody> requestPostData(@Url String url);


    //带请求头没有参数的post请求
    @POST
    @FormUrlEncoded
    <T>
    Observable<ResponseBody> requestPostData(@Url String url, @HeaderMap HashMap<String, T> headers);


    //没有请求头但是有参数的post请求
    @POST
    @FormUrlEncoded
    <T>
    Observable<ResponseBody> requestPostData(@Url String url, @FieldMap Map<String, T> params);


    //既有请求头也有参数的post请求
    @POST
    @FormUrlEncoded
    <T>
    Observable<ResponseBody> requestPostData(@Url String url, @HeaderMap Map<String, T> headers,
                                             @FieldMap Map<String, T> params);
}
