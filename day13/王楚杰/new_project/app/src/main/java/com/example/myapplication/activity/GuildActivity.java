package com.example.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.mvplibrary.base.BaseActivity;
import com.example.mvplibrary.base.BasePresenter;
import com.example.myapplication.R;
import com.example.myapplication.adapter.VpAdapter;

import java.util.ArrayList;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuildActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    private VpAdapter mAdapter;
    private ArrayList<Integer> imgs;
    private View view;
    private SharedPreferences sp;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guild;
    }

    @Override
    protected void init() {
        mAdapter = new VpAdapter(getPageList(), this);
        vp.setAdapter(mAdapter);

        mAdapter.setMyClick(new VpAdapter.MyClick() {
            @Override
            public void onItemClick() {
                finish();
            }
        });
    }

    private ArrayList<Integer> getPageList() {
        imgs = new ArrayList<>();
        imgs.add(R.layout.page1);
        imgs.add(R.layout.page2);
        imgs.add(R.layout.page3);
        return imgs;
    }

    @Override
    protected void click(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}