package com.example.myapplication.fragment;

import com.example.mvplibrary.base.BaseFragment;
import com.example.mvplibrary.base.BasePresenter;
import com.example.myapplication.R;

public class MineFragment extends BaseFragment {

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }
}
