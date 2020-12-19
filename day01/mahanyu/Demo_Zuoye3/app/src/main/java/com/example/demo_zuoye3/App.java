package com.example.demo_zuoye3;

import android.app.Application;
import android.telephony.SmsManager;

import com.example.demo_zuoye3.db.DaoMaster;
import com.example.demo_zuoye3.db.DaoSession;

public class App extends Application {


    public static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(this,"person");
        daoSession = new DaoMaster(helper.getWritableDatabase()).newSession();
    }
}
