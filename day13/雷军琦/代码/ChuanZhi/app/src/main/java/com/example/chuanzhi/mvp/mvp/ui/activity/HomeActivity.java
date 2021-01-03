package com.example.chuanzhi.mvp.mvp.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.chuanzhi.R;
import com.example.chuanzhi.adapter.HomeVpAdapter;
import com.example.chuanzhi.mvp.mvp.ui.fragment.FaxianFragment;
import com.example.chuanzhi.mvp.mvp.ui.fragment.HomeFragment;
import com.example.chuanzhi.mvp.mvp.ui.fragment.MyFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ViewPager home_vp;
    private TabLayout home_tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        home_vp = (ViewPager) findViewById(R.id.home_vp);
        home_tl = (TabLayout) findViewById(R.id.home_tl);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new FaxianFragment());
        list.add(new MyFragment());
        HomeVpAdapter homeVpAdapter = new HomeVpAdapter(getSupportFragmentManager(), list);
        home_vp.setAdapter(homeVpAdapter);
        home_tl.setupWithViewPager(home_vp);
        home_tl.getTabAt(0).setText("首页");
        home_tl.getTabAt(1).setText("发现");
        home_tl.getTabAt(2).setText("我的");
    }
}
