package com.example.day1222_zhangliwei.mvp.mvp.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.day1222_zhangliwei.R;
import com.example.day1222_zhangliwei.mvp.base.BaseFragment;
import com.example.day1222_zhangliwei.mvp.base.BasePresenter;
import com.example.day1222_zhangliwei.mvp.mvp.presenter.HomeFrgPresenter;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.homt_frg_tv)
    TextView mHomtFrgTv;

    @Override
    protected BasePresenter createPresenter() {
        return new HomeFrgPresenter(this);
    }

    @Override
    protected void initData() {
        getmPresenter().start();
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onScuccess(Object obj) {
        String str = (String) obj;
        Log.e("TAG", str+"================");
    }


    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String msg) {
        Log.e("TAG", msg+"================");
    }


}