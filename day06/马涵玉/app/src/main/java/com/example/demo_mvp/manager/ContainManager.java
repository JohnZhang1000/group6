package com.example.demo_mvp.manager;

import android.app.Activity;
import android.content.SharedPreferences;

import androidx.core.app.ActivityCompat;

import com.example.demo_mvp.base.App;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainManager {
    private volatile static ContainManager mManager;
    private static Map<String,Object> map;
    private static Set<Activity> mSet;
    private static SharedPreferences mSp;
    private ContainManager(){
        if(map==null){
           map=new HashMap<String,Object>();
        }
        if (mSet==null){
            mSet=new HashSet<Activity>();
        }
        if (mSp==null){
            mSp= App.context().getSharedPreferences("config",App.MODE_PRIVATE);
        }
    }
    public  static void save_str(String key,String value){
        mSp.edit().putString(key,value).commit();
    }
    public  static  String get_str(String key){
        return mSp.getString(key,"");
    }
    public  static  void save_boolean(String key,Boolean value){
        mSp.edit().putBoolean(key,value).commit();
    }
    public  static  boolean get_boolean(String key,Boolean value){
        return mSp.getBoolean(key,false);
    }
    public static void addActivity(Activity activity){
        mSet.add(activity);
    }
    public static void clearActivity(){
        for (Activity activity:mSet){
            if(activity!=null){
                activity.finish();
                System.exit(0);
            }
        }
    }
    public static void putObj(String key,Object obj){
        map.put(key ,obj);
    }
    public static Object getObj(String key){
        Object object=map.get(key);
        return object;
    }
    public static synchronized ContainManager getmManager(){
        if(mManager==null){
            synchronized (ContainManager.class){
                if(mManager==null){
                    mManager=new ContainManager();
                }
            }
        }
        return mManager;
    }
}

