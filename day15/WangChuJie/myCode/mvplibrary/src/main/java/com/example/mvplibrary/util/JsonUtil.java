package com.example.mvplibrary.util;

import com.google.gson.Gson;

public class JsonUtil {


    public static <T> T getJson(String json,Class<T> tClass){
        return new Gson().fromJson(json,tClass);
    }
}
