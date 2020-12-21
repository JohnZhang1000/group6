package com.example.demo_mvp.mvp.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo_mvp.R;
import com.example.demo_mvp.base.App;
import com.example.demo_mvp.base.BaseActivity;
import com.example.demo_mvp.base.BasePresenter;
import com.example.demo_mvp.manager.ContainManager;
import com.example.demo_mvp.mvp.ui.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.ll)
    LinearLayout ll;
    private boolean mIsExit;
    private Handler mHandler = new Handler();

    @Override
    protected void init() {
getSupportFragmentManager().beginTransaction()
        .replace(R.id.ll,new HomeFragment())
        .commit();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}