package com.umeng.mvp_chouqu.base;

import android.app.Application;
import android.content.Context;

import java.sql.NClob;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * 项目名:zhangwentao_tongpao
 * 包名:com.umeng.mvp_chouqu.base
 * 创建者: 张文涛
 * 创建时间: 2020/12/21
 */
public class App extends Application {
    //全局的Context 整个程序都可以用
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        inint();
    }

    private void inint() {
        mContext = this;
    }
    public  static  Context context(){
        return mContext;
    }
    public static String getStr(int p) {
        return App.context().getString(p);
    }
}
