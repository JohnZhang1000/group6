package com.example.tongpaoapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tongpaoapplication.FRANGMENT.fFaxianBlankFragment;
import com.example.tongpaoapplication.FRANGMENT.sHOUBlankFragment;
import com.google.android.material.tabs.TabLayout;

import java.io.FileReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.pager);
        tab = (TabLayout) findViewById(R.id.tab);
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new sHOUBlankFragment());
        fragments.add(new fFaxianBlankFragment());
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
       tab.getTabAt(0).setText("首页");
       tab.getTabAt(1).setText("发现");
    }
}
