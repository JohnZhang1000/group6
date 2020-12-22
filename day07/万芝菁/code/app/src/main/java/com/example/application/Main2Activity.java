package com.example.application;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Main2Activity extends AppCompatActivity {

    private ViewPager pager;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.pager);
        tab = (TabLayout) findViewById(R.id.tab);
        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.shop));
        tab.addTab(tab.newTab().setText("订单").setIcon(R.drawable.shop));
        tab.addTab(tab.newTab().setText("购物车").setIcon(R.drawable.shop));
        tab.addTab(tab.newTab().setText("地址").setIcon(R.drawable.shop));
    }
}
