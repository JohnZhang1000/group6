package com.example.demo_mvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter ,T> extends Fragment implements IBaseView<T> {

    private Unbinder mBind;
    private P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = getLayoutId();
        View view = null;
        if (layoutId != 0) {
            view = inflater.inflate(layoutId, null);

            mBind = ButterKnife.bind(this, view);
        }
        mPresenter=createPresenter();
        return view;  }

    protected abstract P createPresenter();

    public P getmPresenter() {
        if(mPresenter!=null){
            return mPresenter;
        }
        return null;
    }

    protected abstract int getLayoutId();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       init();
       initData();
    }

    protected abstract void initData();

    protected abstract void init();

    @Override
    public void onSuccess(T t) {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mBind!=null){
            mBind.unbind();
        }
        if(mPresenter!=null){
            mPresenter.detachView();
            mPresenter=null;
        }
    }
}
