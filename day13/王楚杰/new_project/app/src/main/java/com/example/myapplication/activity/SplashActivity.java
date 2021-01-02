package com.example.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import com.example.mvplibrary.base.BaseActivity;
import com.example.mvplibrary.base.BasePresenter;
import com.example.myapplication.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class SplashActivity extends BaseActivity {


    private SharedPreferences sp;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init() {
        Observable.intervalRange(0,3,0,1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        long time = 2 -aLong;
                        if (time == 0){
                            sp = getSharedPreferences("sp", MODE_PRIVATE);
                            boolean flag = sp.getBoolean("flag",false);
                            if (flag){
                                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                                finish();
                            }else {
                                startActivity(new Intent(SplashActivity.this, GuildActivity.class));
                                finish();
                            }
                        }
                    }
                });
    }

    @Override
    protected void click(View view) {

    }
}