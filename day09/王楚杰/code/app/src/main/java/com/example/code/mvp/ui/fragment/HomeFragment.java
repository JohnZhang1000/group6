package com.example.code.mvp.ui.fragment;

import android.widget.TextView;


import com.example.code.R;
import com.example.code.base.BaseFragment;
import com.example.code.base.BasePresenter;
import com.example.code.mvp.presenter.HomePresenter;

import butterknife.BindView;

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
