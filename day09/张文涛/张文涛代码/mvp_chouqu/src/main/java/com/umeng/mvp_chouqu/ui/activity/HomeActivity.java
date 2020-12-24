package com.umeng.mvp_chouqu.ui.activity;


import android.view.KeyEvent;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.umeng.mvp_chouqu.R;
import com.umeng.mvp_chouqu.base.App;
import com.umeng.mvp_chouqu.base.BaseActivity;
import com.umeng.mvp_chouqu.base.BasePresenter;
import com.umeng.mvp_chouqu.engine.adapter.HomeActVpAdapter;
import com.umeng.mvp_chouqu.manager.ContainManager;
import com.umeng.mvp_chouqu.manager.ThreadPoolManager;
import com.umeng.mvp_chouqu.ui.fragment.DiscoverFragment;
import com.umeng.mvp_chouqu.ui.fragment.HomeFragment;
import com.umeng.mvp_chouqu.ui.fragment.JiaHaoFragment;
import com.umeng.mvp_chouqu.ui.fragment.MyFragment;
import com.umeng.mvp_chouqu.ui.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.home_act_vp)
    ViewPager mHomeActVp;
    @BindView(R.id.home_act_tab)
    TabLayout mHomeActTab;
    private boolean mIsExit;
    private ArrayList<Fragment> fragments;
    private HomeActVpAdapter homeActVpAdapter;

    @Override
    protected void init() {
        fragments = new ArrayList();
        fragments.add(new HomeFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new JiaHaoFragment());
        fragments.add(new ShopFragment());
        fragments.add(new MyFragment());

        homeActVpAdapter = new HomeActVpAdapter(getSupportFragmentManager(), fragments);
        mHomeActVp.setAdapter(homeActVpAdapter);
        mHomeActTab.setupWithViewPager(mHomeActVp);
        mHomeActTab.getTabAt(0).setText("首页");
        mHomeActTab.getTabAt(1).setText("发现");
        mHomeActTab.getTabAt(2).setIcon(R.drawable.icon_tab_publish);
        mHomeActTab.getTabAt(3).setText("商城");
        mHomeActTab.getTabAt(4).setText("我的");

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.home_activity;
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
}
