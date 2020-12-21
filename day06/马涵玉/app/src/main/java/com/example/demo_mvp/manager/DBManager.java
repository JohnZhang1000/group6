package com.example.demo_mvp.manager;

public class DBManager {
    private volatile static DBManager mManager;
    private DBManager(){

    }
    public static synchronized DBManager getmManager(){
        if (mManager==null){
            synchronized (DBManager.class){
                mManager=new DBManager();
            }
        }
        return mManager;
    }
}
