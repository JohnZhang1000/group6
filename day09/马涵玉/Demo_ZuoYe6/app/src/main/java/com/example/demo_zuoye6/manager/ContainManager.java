package com.example.demo_zuoye6.manager;

import android.app.Activity;
import android.content.SharedPreferences;


import com.example.demo_zuoye6.base.App;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainManager  {
    private volatile static ContainManager mManager;
    //用来两个类之间传递对象
    private static Map<String,Object> mMap;
    //定义一个集合存储所有需要添加到集合的Activity
    private static Set<Activity> mSet;
    //全局的SP 整个程序都可以用
    private static SharedPreferences mSp;
    private ContainManager(){
        if (mSet==null){
            mSet=new HashSet<Activity>();

        }
        if(mMap==null){
            mMap=new HashMap<String, Object>();
        }
        if(mSp==null){
            mSp= App.context().getSharedPreferences("config",App.MODE_PRIVATE);
        }

    }
    public void save_star(String key,String value){
        mSp.edit().putString(key,value).commit();
    }
    public boolean get_str(String key){
        return mSp.getBoolean(key,false);
    }
    public void addActivity(Activity activity){
        mSet.add(activity);
    }
    public void clearActivity(){
        for (Activity activity:mSet){
            if(activity!=null){
                activity.finish();
                System.exit(0);
            }
        }
    }
    public void putObj(String key,Object obj){
        mMap.put(key,obj);
    }
    public Object getObj(String key){
        Object object=mMap.get(key);
        return object;
    }
       public static synchronized  ContainManager getmManager(){
        synchronized (ContainManager.class){
            if(mManager==null){
                mManager=new ContainManager();
            }
        }
        return mManager;
       }

}
