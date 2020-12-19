package com.example.day1218_04tongpao;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day1218_04tongpao.adapter.MyFragAdapter;
import com.example.day1218_04tongpao.fragment.AddFragment;
import com.example.day1218_04tongpao.fragment.FindFragment;
import com.example.day1218_04tongpao.fragment.HomeFragment;
import com.example.day1218_04tongpao.fragment.MineFragment;
import com.example.day1218_04tongpao.fragment.ShopFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager vp_tot;
    private TabLayout tab_bottom;
    private ArrayList<Fragment> list;
    private MyFragAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        vp_tot = (ViewPager) findViewById(R.id.vp_tot);
        tab_bottom = (TabLayout) findViewById(R.id.tab_bottom);
        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new FindFragment());
        list.add(new AddFragment());
        list.add(new ShopFragment());
        list.add(new MineFragment());
        adapter = new MyFragAdapter(getSupportFragmentManager(), list);
        vp_tot.setAdapter(adapter);
        tab_bottom.setupWithViewPager(vp_tot);
        tab_bottom.getTabAt(0).setText("首页");
        tab_bottom.getTabAt(1).setText("发现");
        tab_bottom.getTabAt(2).setText("");
        tab_bottom.getTabAt(3).setText("商城");
        tab_bottom.getTabAt(4).setText("我的");

    }
}