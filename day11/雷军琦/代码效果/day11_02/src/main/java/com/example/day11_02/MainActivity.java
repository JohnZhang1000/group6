package com.example.day11_02;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day11_02.adapter.MyVpAdapter;
import com.example.day11_02.fragment.GongFragment;
import com.example.day11_02.fragment.HomeFragment;
import com.example.day11_02.fragment.MyFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView main_title;
    private ViewPager main_vp;
    private TabLayout main_tl;
    private Toolbar main_tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        main_title = (TextView) findViewById(R.id.main_title);
        main_vp = (ViewPager) findViewById(R.id.main_vp);
        main_tl = (TabLayout) findViewById(R.id.main_tl);
        main_tb = (Toolbar) findViewById(R.id.main_tb);
        setSupportActionBar(main_tb);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new GongFragment());
        list.add(new MyFragment());
        MyVpAdapter myVpAdapter = new MyVpAdapter(getSupportFragmentManager(), list);
        main_vp.setAdapter(myVpAdapter);
        main_tl.setupWithViewPager(main_vp);
        main_tl.getTabAt(0).setText("首页");
        main_tl.getTabAt(1).setText("攻略");
        main_tl.getTabAt(2).setText("我的");
        main_tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        main_title.setText("首页");
                        break;
                    case 1:
                        main_title.setText("攻略");
                        break;
                    case 2:
                        main_title.setText("我的");
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
