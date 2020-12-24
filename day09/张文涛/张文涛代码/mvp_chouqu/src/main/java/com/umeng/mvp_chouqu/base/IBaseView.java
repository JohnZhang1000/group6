package com.umeng.mvp_chouqu.base;

/**
 * 项目名:zhangwentao_tongpao
 * 包名:com.umeng.mvp_chouqu.base
 * 创建者: 张文涛
 * 创建时间: 2020/12/21
 */
public interface IBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
}
