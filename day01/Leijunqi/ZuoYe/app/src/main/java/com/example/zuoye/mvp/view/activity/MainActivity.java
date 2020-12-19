package com.example.zuoye.mvp.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.gifdecoder.GifHeader;
import com.example.zuoye.R;
import com.example.zuoye.mvp.adapter.MyVpAdapter;
import com.example.zuoye.mvp.view.fragment.AddFragment;
import com.example.zuoye.mvp.view.fragment.FoundFragment;
import com.example.zuoye.mvp.view.fragment.HomeFragment;
import com.example.zuoye.mvp.view.fragment.MyFragment;
import com.example.zuoye.mvp.view.fragment.ThesofaFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tl = (TabLayout) findViewById(R.id.tl);
        ArrayList<Fragment> list = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        ThesofaFragment thesofaFragment = new ThesofaFragment();
        AddFragment addFragment = new AddFragment();
        FoundFragment foundFragment = new FoundFragment();
        MyFragment myFragment = new MyFragment();
        list.add(homeFragment);
        list.add(thesofaFragment);
        list.add(addFragment);
        list.add(foundFragment);
        list.add(myFragment);
        MyVpAdapter myVpAdapter = new MyVpAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(myVpAdapter);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("首页").setIcon(R.drawable.icon_tab_home);
        tl.getTabAt(1).setText("沙发").setIcon(R.drawable.icon_tab_sofa);
        tl.getTabAt(2).setIcon(R.drawable.icon_tab_publish);
        tl.getTabAt(3).setText("发现").setIcon(R.drawable.icon_tab_find);
        tl.getTabAt(4).setText("我的").setIcon(R.drawable.icon_tab_mine);
    }
}
