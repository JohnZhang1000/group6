package com.umeng.mvp_chouqu.manager;

/**
 * 项目名:zhangwentao_tongpao
 * 包名:com.umeng.mvp_chouqu.manager
 * 创建者: 张文涛
 * 创建时间: 2020/12/21
 */
public class DBManager {
    private volatile static DBManager mManger;

    private DBManager() {

    }

    public static synchronized DBManager getmManger() {
        if (mManger == null) {
            synchronized (DBManager.class) {
                if (mManger == null) {
                    mManger = new DBManager();
                }
            }
        }
        return mManger;
    }
}
