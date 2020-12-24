package com.example.demo_zuoye6.mvp.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.demo_zuoye6.R;
import com.example.demo_zuoye6.base.App;
import com.example.demo_zuoye6.base.BaseActivity;
import com.example.demo_zuoye6.base.BasePresenter;
import com.example.demo_zuoye6.manager.ContainManager;
import com.example.demo_zuoye6.manager.ThreadPoolManager;
import com.example.demo_zuoye6.adapter.VpFragmentAdapter;
import com.example.demo_zuoye6.mvp.ui.fragment.FindFragment;
import com.example.demo_zuoye6.mvp.ui.fragment.HomeFragment;
import com.example.demo_zuoye6.mvp.ui.fragment.MyFragment;
import com.example.demo_zuoye6.mvp.ui.fragment.PicFragment;
import com.example.demo_zuoye6.mvp.ui.fragment.ShoppFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.bottom_navigation)
    TabLayout bottomNavigation;
    private boolean mIsExit;

    @Override
    protected void init() {
        setSupportActionBar(toolbar);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new FindFragment());
        fragments.add(new PicFragment());
        fragments.add(new ShoppFragment());
        fragments.add(new MyFragment());
        VpFragmentAdapter vpFragmentAdapter = new VpFragmentAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(vpFragmentAdapter);
        bottomNavigation.setupWithViewPager(vp);
        bottomNavigation.addTab(bottomNavigation.newTab().setIcon(R.drawable.home_selector).setText("首页"));
        bottomNavigation.addTab(bottomNavigation.newTab().setIcon(R.drawable.home_selector).setText("发现"));
        bottomNavigation.addTab(bottomNavigation.newTab().setIcon(R.drawable.home_selector));
        bottomNavigation.addTab(bottomNavigation.newTab().setIcon(R.drawable.home_selector).setText("商城"));
        bottomNavigation.addTab(bottomNavigation.newTab().setIcon(R.drawable.home_selector).setText("我的"));
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
                ThreadPoolManager.
                        getThreadPool(ThreadPoolManager.SCHDULE_THREADPOOL).
                        executeTimerTask(new Runnable() {
                            @Override
                            public void run() {
                                mIsExit = false;
                            }
                        }, 2, TimeUnit.SECONDS);


            } else {
                ContainManager.getmManager().clearActivity();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
