package com.example.wangchujie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.wangchujie.adapter.VpFragmentAdapter;
import com.example.wangchujie.fragment.AddFragment;
import com.example.wangchujie.fragment.FindFragment;
import com.example.wangchujie.fragment.HomeFragment;
import com.example.wangchujie.fragment.MineFragment;
import com.example.wangchujie.fragment.ShopFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<Fragment> fragments;
    private VpFragmentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);


        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new FindFragment());
        fragments.add(new AddFragment());
        fragments.add(new ShopFragment());
        fragments.add(new MineFragment());

        mAdapter = new VpFragmentAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(mAdapter);

        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("首页").setIcon(R.drawable.icon_tab_home);
        mTab.getTabAt(1).setText("发现").setIcon(R.drawable.icon_tab_sofa);
        mTab.getTabAt(2).setIcon(R.drawable.icon_tab_publish);
        mTab.getTabAt(3).setText("商城").setIcon(R.drawable.icon_tab_find);
        mTab.getTabAt(4).setText("我的").setIcon(R.drawable.icon_tab_mine);
    }
}
