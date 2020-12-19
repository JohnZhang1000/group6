package com.umeng.zhangwentao.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.umeng.zhangwentao.R;
import com.umeng.zhangwentao.adapter.FragmentAdapter;
import com.umeng.zhangwentao.fragment.shafa.ImgFragment;
import com.umeng.zhangwentao.fragment.shafa.TextFragment;
import com.umeng.zhangwentao.fragment.shafa.VideoFragment;

import java.util.ArrayList;

public class ShaFaFragment extends Fragment {

    private TabLayout mFragmentTab;
    private ViewPager mFragmentVp;
    private ArrayList<Fragment> fragments;
    private FragmentAdapter fragmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sha_fa, container, false);
        inintView(view);
        return view;
    }

    private void inintView(View itemView) {
        mFragmentTab = itemView.findViewById(R.id.fragment_tab);
        mFragmentVp = itemView.findViewById(R.id.fragment_vp);
        fragments = new ArrayList<>();
        fragments.add(new ImgFragment());
        fragments.add(new VideoFragment());
        fragments.add(new TextFragment());
        fragmentAdapter = new FragmentAdapter(getChildFragmentManager(), fragments);
        mFragmentVp.setAdapter(fragmentAdapter);
        mFragmentTab.setupWithViewPager(mFragmentVp);
        mFragmentTab.getTabAt(0).setText("图片");
        mFragmentTab.getTabAt(1).setText("视频");
        mFragmentTab.getTabAt(2).setText("文本");
    }
}