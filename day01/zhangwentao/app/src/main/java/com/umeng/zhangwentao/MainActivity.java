package com.umeng.zhangwentao;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.umeng.zhangwentao.adapter.FragmentAdapter;
import com.umeng.zhangwentao.fragment.FaXianFragment;
import com.umeng.zhangwentao.fragment.HomeFragment;
import com.umeng.zhangwentao.fragment.JaHaoFragment;
import com.umeng.zhangwentao.fragment.ShaFaFragment;
import com.umeng.zhangwentao.fragment.WoDeFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager home_vp;
    private ArrayList<Fragment> fragments;
    private FragmentAdapter fragmentAdapter;
    private TabLayout home_tab;

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
        fragments.add(new ShaFaFragment());
        fragments.add(new JaHaoFragment());
        fragments.add(new FaXianFragment());
        fragments.add(new WoDeFragment());
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        home_vp.setAdapter(fragmentAdapter);
        home_tab.setupWithViewPager(home_vp);
        home_tab.getTabAt(0).setText("首页").setIcon(R.drawable.icon_tab_home);
        home_tab.getTabAt(1).setText("沙发").setIcon(R.drawable.icon_tab_sofa);
        home_tab.getTabAt(2).setIcon(R.drawable.icon_tab_publish);
        home_tab.getTabAt(3).setText("发现").setIcon(R.drawable.icon_tab_find);
        home_tab.getTabAt(4).setText("我的").setIcon(R.drawable.icon_tab_mine);
    }
}