package com.example.mycode;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mvplibrary.base.BaseActivity;
import com.example.mvplibrary.engine.adapter.VpFragmentAdapter;
import com.example.mycode.fragment.FindFragment;
import com.example.mycode.fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MyPresenter, Bean> {

    private MyPresenter myPresenter;
    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> fragments;
    private VpFragmentAdapter mAdapter;


    @Override
    protected MyPresenter createPresenter() {
        return myPresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);

        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new FindFragment());

        mAdapter = new VpFragmentAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(mAdapter);
        tab.setupWithViewPager(vp);

        tab.getTabAt(0).setText("首页");
        tab.getTabAt(1).setText("发现");
    }

    @Override
    protected void click(View view) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}