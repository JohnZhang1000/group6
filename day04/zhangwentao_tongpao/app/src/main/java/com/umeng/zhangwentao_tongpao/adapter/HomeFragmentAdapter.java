package com.umeng.zhangwentao_tongpao.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 项目名:zhangwentao_tongpao
 * 包名:com.umeng.zhangwentao_tongpao.adapter
 * 创建者: 张文涛
 * 创建时间: 2020/12/18
 */
public class HomeFragmentAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment>list;

    public HomeFragmentAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> list) {
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
