package com.example.demo_mvp.base;

import android.app.AppComponentFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo_mvp.manager.ContainManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class IBaseActivity<T> extends AppCompatActivity implements IBaseView<T> {

    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        if(layoutId!=0){
            setContentView(layoutId);
            mBind = ButterKnife.bind(this);
            ContainManager.addActivity(this);
            init();
            initData();

        }
    }
    protected void initData() {

    }

    protected abstract void init();



    protected abstract int getLayoutId();
    @Override
    public void onSuccess(T t) {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
    }
}
