package com.umeng.mvp_chouqu.base;

import java.util.concurrent.TimeUnit;

/**
 * 项目名:zhangwentao_tongpao
 * 包名:com.umeng.mvp_chouqu.base
 * 创建者: 张文涛
 * 创建时间: 2020/12/22
 */
public abstract class BaseThreadPool {
    public void executeTask(Runnable runnable) {

    }

    public void executeTimerTask(Runnable runnable, long firstStartTime, long intervelTime,
                                 TimeUnit timeUnit) {
    }

    public void executeTimerTask(Runnable runnable, long delayTime
            ,TimeUnit timeUnit) {
    }

    public abstract void removeTask();

    public void removeTask(Runnable runnable) {

    }
}
