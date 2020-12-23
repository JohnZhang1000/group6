package com.example.demo_zuoye4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new FindFragment());
        fragments.add(new MoreFragment());
        fragments.add(new ShoppFragment());
        fragments.add(new MyFragment());
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(vpAdapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("首页").setIcon(R.drawable.homeselector);
        tab.getTabAt(1).setIcon(R.drawable.homeselector).setText("发现");
        tab.getTabAt(2).setIcon(R.drawable.homeselector);
        tab.getTabAt(3).setText("发现").setIcon(R.drawable.homeselector);
        tab.getTabAt(4).setText("我的").setIcon(R.drawable.homeselector);
    }


    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
    }
}