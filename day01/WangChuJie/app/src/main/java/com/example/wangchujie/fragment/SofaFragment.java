package com.example.wangchujie.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.wangchujie.R;
import com.example.wangchujie.adapter.VpFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SofaFragment extends Fragment {

    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> fragments;
    private VpFragmentAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_safa, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTab = view.findViewById(R.id.tab2);
        mVp = view.findViewById(R.id.vp2);

        fragments = new ArrayList<>();
        fragments.add(new ImgFragment());
        fragments.add(new VideoFragment());
        fragments.add(new TextFragment());

        mAdapter = new VpFragmentAdapter(getChildFragmentManager(), fragments);
        mVp.setAdapter(mAdapter);
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("图片");
        mTab.getTabAt(1).setText("视频");
        mTab.getTabAt(2).setText("文本");
    }

}
