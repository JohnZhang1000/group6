package com.umeng.mvp_chouqu.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 项目名:zhangwentao_tongpao
 * 包名:com.umeng.mvp_chouqu.base
 * 创建者: 张文涛
 * 创建时间: 2020/12/21
 */
public abstract class BaseFragment<P extends BasePresenter, T> extends Fragment implements IBaseView<T> {
    private Unbinder mBinder;
    private P mPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = getLayoutId();
        View view = null;
        if (layoutId != 0) {
            view = inflater.inflate(layoutId, null);
            mBinder = ButterKnife.bind(this, view);

        }
        mPresenter = mPresenter = createPresenter();
        if (mPresenter != null)
            mPresenter.attachView(this);
        return view;
    }

    protected abstract P createPresenter();

    protected P getmPresenter() {
        if (mPresenter != null)
            return mPresenter;
        return null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        initData();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mBinder != null)
            mBinder.unbind();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
