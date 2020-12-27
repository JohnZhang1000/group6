package com.example.code.mvp.ui.fragment;


import com.example.code.R;
import com.example.mylibrary.base.BaseFragment;
import com.example.mylibrary.base.BasePresenter;
import com.example.code.mvp.presenter.HomePresenter;

public class HomeFragment extends BaseFragment {

    @Override
    protected BasePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onSuccess(Object o) {
        super.onSuccess(o);
    }

    @Override
    public void onFail(String msg) {
        super.onFail(msg);
    }
}
