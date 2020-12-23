package com.example.application;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ViewPager pager;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.pager);
        tab = (TabLayout) findViewById(R.id.tab);
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment2());
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tab.setupWithViewPager(pager);
        tab.getTabAt(0).setText("我的");
        tab.getTabAt(1).setText("我的");

    }
}
