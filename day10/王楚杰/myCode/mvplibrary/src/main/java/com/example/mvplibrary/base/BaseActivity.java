package com.example.mvplibrary.base;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvplibrary.manager.ContainManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter, T> extends AppCompatActivity implements IBaseView<T> {

    private Unbinder bind;
    private P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Activity 加载布局
        int layoutId = getLayoutId();
        if (layoutId != 0) {
            setContentView(layoutId);
        }
        bind = ButterKnife.bind(this);
        //将所有的Activity添加到集合里面
        ContainManager.getmManager().addActivity(this);
        //创建P层对象并且关联V层
        mPresenter = createPresenter();
        if (mPresenter != null)
            mPresenter.attachView(this);
        //初始化view
        init();
        //初始化数据
        initData();
    }

    protected abstract P createPresenter();

    //获取P层对象
    protected  P getmPresenter(){
        if (mPresenter != null){
            return mPresenter;
        }
        return null;
    }


    protected void initData() {

    }


    @Override
    public void onSuccess(T t) {

    }

    @Override
    public void onFail(String msg) {

    }

    protected abstract int getLayoutId();

    protected abstract void init();

    protected abstract void click(View view);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
        if (mPresenter != null){
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
