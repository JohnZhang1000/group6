package com.example.demo_mvp.mvp.ui.fragment;

import android.util.Log;
import android.widget.TextView;

import com.example.demo_mvp.R;
import com.example.demo_mvp.base.BaseFragment;
import com.example.demo_mvp.base.BasePresenter;
import com.example.demo_mvp.mvp.presenter.HomePresenter;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.tv_home)
    TextView tvHome;

    @Override
    protected BasePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
     getmPresenter().start();
    }

    @Override
    protected void init() {

    }

    @Override
    public void onSuccess(Object o) {
        String str= (String) o;
        Log.e("TAG","请求成功"+str);

    }

    @Override
    public void onError(String msg) {
        Log.e("TAG", "请求失败："+msg);
    }
}