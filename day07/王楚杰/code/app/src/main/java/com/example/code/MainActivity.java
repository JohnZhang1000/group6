package com.example.code;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);

        mTab.addTab(mTab.newTab().setText("首页").setIcon(R.drawable.icon_tab_home));
        mTab.addTab(mTab.newTab().setText("发现").setIcon(R.drawable.icon_tab_sofa));
        mTab.addTab(mTab.newTab().setIcon(R.drawable.icon_tab_publish));
        mTab.addTab(mTab.newTab().setText("商城").setIcon(R.drawable.icon_tab_find));
        mTab.addTab(mTab.newTab().setText("我的").setIcon(R.drawable.icon_tab_mine));

    }
}
