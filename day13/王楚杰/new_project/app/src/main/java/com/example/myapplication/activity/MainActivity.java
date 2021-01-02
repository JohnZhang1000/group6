package com.example.myapplication.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mvplibrary.base.App;
import com.example.mvplibrary.base.BaseActivity;
import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.manager.ContainManager;
import com.example.myapplication.R;
import com.example.myapplication.fragment.CourseFragment;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.fragment.MineFragment;
import com.example.myapplication.fragment.StudyFragment;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.lin)
    LinearLayout lin;
    @BindView(R.id.tab)
    TabLayout tab;
    private boolean mIsExit;
    private Handler mHandler = new Handler();
    private HomeFragment homeFragment;
    private CourseFragment courseFragment;
    private StudyFragment studyFragment;
    private MineFragment mineFragment;
    private FragmentManager manager;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        manager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        courseFragment = new CourseFragment();
        studyFragment = new StudyFragment();
        mineFragment = new MineFragment();
        manager.beginTransaction().add(R.id.lin,homeFragment)
                .add(R.id.lin, courseFragment)
                .add(R.id.lin,studyFragment)
                .add(R.id.lin,mineFragment)
                .hide(courseFragment)
                .hide(studyFragment)
                .hide(mineFragment).commit();

        initTab();
    }

    private void initTab() {
        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.home_selector));
        tab.addTab(tab.newTab().setText("选课").setIcon(R.drawable.course_selector));
        tab.addTab(tab.newTab().setText("学习").setIcon(R.drawable.study_selector));
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.mine_selector));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        manager.beginTransaction().show(homeFragment)
                                .hide(courseFragment)
                                .hide(studyFragment)
                                .hide(mineFragment).commit();
                        break;
                    case 1:
                        manager.beginTransaction().show(courseFragment)
                                .hide(homeFragment)
                                .hide(studyFragment)
                                .hide(mineFragment).commit();
                        break;
                    case 2:
                        manager.beginTransaction().show(studyFragment)
                                .hide(courseFragment)
                                .hide(homeFragment)
                                .hide(mineFragment).commit();
                        break;
                    case 3:
                        manager.beginTransaction().show(mineFragment)
                                .hide(courseFragment)
                                .hide(studyFragment)
                                .hide(homeFragment).commit();
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

    @Override
    protected void click(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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