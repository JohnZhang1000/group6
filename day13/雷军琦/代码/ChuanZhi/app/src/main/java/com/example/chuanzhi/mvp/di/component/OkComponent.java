package com.example.chuanzhi.mvp.di.component;

import com.example.mvp.di.module.OKManager;
import com.example.mvp.mvp.model.RxOpretorImpl;

import javax.inject.Singleton;

import dagger.Component;

//注射器
@Singleton
@Component(modules = OKManager.class)
public interface OkComponent {
    //自定义的方法
    void getSingleApiService(RxOpretorImpl impl);
}