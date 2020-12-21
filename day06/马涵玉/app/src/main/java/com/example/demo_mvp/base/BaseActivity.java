package com.example.demo_mvp.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.demo_mvp.manager.ContainManager;

import java.util.Map;

import butterknife.ButterKnife;

import butterknife.Unbinder;


/**
 * 所有Activity都要继承的类
 *
 * @param <T>
 */
public abstract class BaseActivity<P extends BasePresenter, T> extends AppCompatActivity implements IBaseView<T> {
    private Unbinder mBind;
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        if (layoutId != 0)
            setContentView(layoutId);
        mBind = ButterKnife.bind(this);
        ContainManager.getmManager().addActivity(this);
        mPresenter = createPresenter();
        if(mPresenter!=null)
            mPresenter.attachView(this);

        init();
        initData();
    }

    protected abstract P createPresenter();

    public P getmPresenter() {
        if(mPresenter!=null){
            return mPresenter;
        }
        return null;
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
       if(mPresenter!=null){
           mPresenter.detachView();
           mPresenter=null;
       }
    }
}