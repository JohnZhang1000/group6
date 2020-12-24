package com.umeng.mvp_chouqu.engine.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 项目名:zhangwenmvptao_tongpao
 * 包名:com.umeng.mvp_chouqu.engine.adapter
 * 创建者: 张文涛
 * 创建时间: 2020/12/22
 */
public class HomeActVpAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment>list;
    public HomeActVpAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
//dddddd
}
