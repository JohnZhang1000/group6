package com.umeng.zhangwentao_tongpao;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.umeng.zhangwentao_tongpao.adapter.HomeFragmentAdapter;
import com.umeng.zhangwentao_tongpao.mainfragment.DiscoverFragment;
import com.umeng.zhangwentao_tongpao.mainfragment.HomeFragment;
import com.umeng.zhangwentao_tongpao.mainfragment.MoreFragment;
import com.umeng.zhangwentao_tongpao.mainfragment.MyFragment;
import com.umeng.zhangwentao_tongpao.mainfragment.StoreFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager home_vp;
    private TabLayout home_tab;
    private ArrayList<Fragment> fragments;
    private HomeFragmentAdapter homeFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        home_vp = (ViewPager) findViewById(R.id.home_vp);
        home_tab = (TabLayout) findViewById(R.id.home_tab);
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new MoreFragment());
        fragments.add(new MyFragment());
        fragments.add(new StoreFragment());
        homeFragmentAdapter = new HomeFragmentAdapter(getSupportFragmentManager(),fragments);
        home_vp.setAdapter(homeFragmentAdapter);
        home_tab.setupWithViewPager(home_vp);
        home_tab.getTabAt(0).setText("首页");
        home_tab.getTabAt(1).setText("发现");
        home_tab.getTabAt(2).setIcon(R.drawable.icon_tab_publish);
        home_tab.getTabAt(3).setText("商城");
        home_tab.getTabAt(4).setText("我的");

    }
}