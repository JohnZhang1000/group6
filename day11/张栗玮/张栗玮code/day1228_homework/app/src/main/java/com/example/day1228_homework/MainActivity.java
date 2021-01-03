package com.example.day1228_homework;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day1228_homework.adapter.MyFragAdapter;
import com.example.day1228_homework.fragment.HomeFragment;
import com.example.day1228_homework.fragment.MyFragment;
import com.example.day1228_homework.fragment.PlanFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private TabLayout tab_main;
    private ImageView img_search;
    private ViewPager vp_main;
    private ArrayList<Fragment> list;
    private MyFragAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp_main = (ViewPager) findViewById(R.id.vp_main);
        tab_main = (TabLayout) findViewById(R.id.tab_main);
        img_search = (ImageView) findViewById(R.id.img_search);
        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new PlanFragment());
        list.add(new MyFragment());
        adapter = new MyFragAdapter(getSupportFragmentManager(), list);
        vp_main.setAdapter(adapter);
        tab_main.setupWithViewPager(vp_main);
        tab_main.getTabAt(0).setText("首页").setIcon(R.drawable.i1);
        tab_main.getTabAt(1).setText("攻略").setIcon(R.drawable.i2);
        tab_main.getTabAt(2).setText("我的").setIcon(R.drawable.i3);


    }

}