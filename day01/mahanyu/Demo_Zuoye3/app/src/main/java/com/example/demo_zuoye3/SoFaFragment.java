package com.example.demo_zuoye3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SoFaFragment extends Fragment {

    private TabLayout tab;
    private ViewPager vp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_so_fa, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PicFragment());
        fragments.add(new VieoFragment());
        fragments.add(new TextFragment());
        VpAdapter vpAdapter = new VpAdapter(getChildFragmentManager(), fragments);
        vp.setAdapter(vpAdapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("图片");
        tab.getTabAt(1).setText("视频");
        tab.getTabAt(2).setText("文本");
    }

    private void initView(View view) {
        tab = view.findViewById(R.id.tab);
        vp = view.findViewById(R.id.vp);
    }
}