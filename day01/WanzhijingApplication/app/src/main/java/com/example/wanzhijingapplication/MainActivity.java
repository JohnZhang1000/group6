package com.example.wanzhijingapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.wanzhijingapplication.fragment.AddBlankFragment2;
import com.example.wanzhijingapplication.fragment.BlankFragment;
import com.example.wanzhijingapplication.fragment.FaxianBlankFragment2;
import com.example.wanzhijingapplication.fragment.ShafaFragment2;
import com.example.wanzhijingapplication.fragment.WodeBlankFragment;
import com.google.android.material.tabs.TabLayout;

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
        fragments.add(new BlankFragment());
        fragments.add(new ShafaFragment2());
        fragments.add(new AddBlankFragment2());
        fragments.add(new FaxianBlankFragment2());
        fragments.add(new WodeBlankFragment());
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
        tab.getTabAt(0).setText("首页").setIcon(R.drawable.icon_tab_home);
        tab.getTabAt(1).setText("沙发").setIcon(R.drawable.icon_tab_sofa);
        tab.getTabAt(2).setIcon(R.drawable.icon_tab_publish);
        tab.getTabAt(3).setText("发现").setIcon(R.drawable.icon_tab_find);
        tab.getTabAt(4).setText("我的").setIcon(R.drawable.icon_tab_mine);
    }
}
