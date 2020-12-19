package com.example.leijunqi.mvp.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.leijunqi.R;
import com.example.leijunqi.mvp.adapter.MyVpAdapter;
import com.example.leijunqi.mvp.view.fragment.RankingFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {

    private ViewPager vp_ran;
    private TabLayout tl_ran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        initView();
    }

    private void initView() {
        vp_ran = (ViewPager) findViewById(R.id.vp_ran);
        tl_ran = (TabLayout) findViewById(R.id.tl_ran);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new RankingFragment());
        list.add(new RankingFragment());
        list.add(new RankingFragment());
        MyVpAdapter myVpAdapter = new MyVpAdapter(getSupportFragmentManager(), list);
        vp_ran.setAdapter(myVpAdapter);
        tl_ran.setupWithViewPager(vp_ran);
        tl_ran.getTabAt(0).setText("经验榜");
        tl_ran.getTabAt(1).setText("土豪榜");
        tl_ran.getTabAt(2).setText("签到榜");
    }
}
