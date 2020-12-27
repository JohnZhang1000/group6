package com.example.mycode.fragment;

import com.example.mvplibrary.base.BaseFragment;
import com.example.mycode.Bean;
import com.example.mycode.MyPresenter;
import com.example.mycode.R;

public class FindFragment extends BaseFragment<MyPresenter, Bean> {
    @Override
    protected MyPresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }
}
