package com.example.day1217_proj1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day1217_proj1.Adapter.MyFragAdapter;
import com.example.day1217_proj1.fragment.AddFragment;
import com.example.day1217_proj1.fragment.FindFragment;
import com.example.day1217_proj1.fragment.HomeFragment;
import com.example.day1217_proj1.fragment.MainFragment;
import com.example.day1217_proj1.fragment.SofaFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new SofaFragment());
        list.add(new AddFragment());
        list.add(new FindFragment());
        list.add(new MainFragment());
        MyFragAdapter adapter = new MyFragAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("首页").setIcon(R.drawable.icon_tab_home);
        tab.getTabAt(1).setText("沙发").setIcon(R.drawable.icon_tab_sofa);
        tab.getTabAt(2).setText("").setIcon(R.drawable.icon_tab_publish);
        tab.getTabAt(3).setText("发现").setIcon(R.drawable.icon_tab_find);
        tab.getTabAt(4).setText("我的").setIcon(R.drawable.icon_tab_mine);
    }
}