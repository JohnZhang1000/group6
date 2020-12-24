package com.example.day1224_homework;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.day1224_homework.adapter.MyFragAdapter;
import com.example.day1224_homework.fragment.AddFragment;
import com.example.day1224_homework.fragment.FindFragment;
import com.example.day1224_homework.fragment.HomeFragment;
import com.example.day1224_homework.fragment.MineFragment;
import com.example.day1224_homework.fragment.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.tab_main)
    TabLayout tabMain;
    private Unbinder bind;
    private MyFragAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new FindFragment());
        list.add(new AddFragment());
        list.add(new ShopFragment());
        list.add(new MineFragment());
        adapter = new MyFragAdapter(getSupportFragmentManager(), list);
        vpMain.setAdapter(adapter);
        tabMain.setupWithViewPager(vpMain);
        tabMain.getTabAt(0).setText("首页").setIcon(R.drawable.ic_baseline_house_24);
        tabMain.getTabAt(1).setText("发现").setIcon(R.drawable.ic_baseline_search_24);
        tabMain.getTabAt(2).setText("").setIcon(R.drawable.ic_baseline_add_circle_24);
        tabMain.getTabAt(3).setText("商城").setIcon(R.drawable.ic_baseline_local_grocery_store_24);
        tabMain.getTabAt(4).setText("我的").setIcon(R.drawable.ic_baseline_account_circle_24);


    }


    @Override
    protected void onDestroy() {
        bind.unbind();
        super.onDestroy();
    }
}