package com.example.code.mvp.ui.activity;

import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.code.R;
import com.example.mylibrary.base.App;
import com.example.mylibrary.base.BaseActivity;
import com.example.mylibrary.base.BasePresenter;
import com.example.code.engine.adapter.VpFragmentAdapter;
import com.example.code.manager.ContainManager;
import com.example.code.mvp.ui.fragment.AddFragment;
import com.example.code.mvp.ui.fragment.FindFragment;
import com.example.code.mvp.ui.fragment.HomeFragment;
import com.example.code.mvp.ui.fragment.MineFragment;
import com.example.code.mvp.ui.fragment.ShopFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.tab)
    TabLayout mTab;
    private boolean mIsExit;

    private Handler mHandler = new Handler();
    private ArrayList<Fragment> fragments;
    private VpFragmentAdapter mAdapter;

    @Override
    protected void init() {

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

    @Override
    protected void click(View view) {
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    //监听返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //TODO  2秒内连续点击两次 退出程序，  如果第二次点击超过2秒了，会Toast提示再按一次退出程序
            if (!mIsExit) {
                mIsExit = true;
                Toast.makeText(App.context(), "再按一次退出程序", Toast.LENGTH_LONG).show();
                //2秒之后把变量值改成true
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mIsExit = false;
                    }
                }, 2000);
            } else {
                ContainManager.getmManager().clearActivity();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

}
