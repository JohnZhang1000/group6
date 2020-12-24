package com.umeng.mvp_chouqu.di.component;

import com.umeng.mvp_chouqu.mvp.model.OkManager;
import com.umeng.mvp_chouqu.mvp.model.RxOpretorImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 项目名:zhangwentao_tongpao
 * 包名:com.umeng.mvp_chouqu.di.component
 * 创建者: 张文涛
 * 创建时间: 2020/12/22
 */
//注射器
@Singleton
@Component(modules = OkManager.class)

public interface  OkComponent {
    //自定义的方法
    void getSingleApiService(RxOpretorImpl impl);
}
