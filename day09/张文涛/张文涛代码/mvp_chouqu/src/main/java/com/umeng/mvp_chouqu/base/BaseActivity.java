package com.umeng.mvp_chouqu.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.umeng.mvp_chouqu.manager.ContainManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 项目名:zhangwentao_tongpao
 * 包名:com.umeng.mvp_chouqu.base
 * 创建者: 张文涛
 * 创建时间: 2020/12/21
 */
public abstract class BaseActivity<P extends BasePresenter, T> extends AppCompatActivity implements IBaseView<T> {
    private Unbinder mBind;
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        int layoutId = getLayoutId();
        if (layoutId != 0) {
            setContentView(layoutId);
            mBind = ButterKnife.bind(this);
            ContainManager.getmManager().addActivity(this);
            //1.创建P层对象并关联V层
            mPresenter = createPresenter();
            if (mPresenter != null)
                mPresenter.attachView(this);
            //初始化view
            init();
            //初始化数据
            initData();

        }
    }

    protected abstract P createPresenter();

    //获取P层对象
    protected P getmPresenter() {
        if (mPresenter != null) {
            return mPresenter;
        }
        return null;
    }

    protected void initData() {

    }

    protected abstract void init();

    protected abstract int getLayoutId();

    @Override
    public void onScuccess(T t) {

    }

    @Override
    public void onError(String msg) {

    }

    //释放资源
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
