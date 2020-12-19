package com.example.day1217_proj1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day1217_proj1.Adapter.MyFragAdapter;
import com.example.day1217_proj1.R;
import com.example.day1217_proj1.fragment.sofafrag.PicFragment;
import com.example.day1217_proj1.fragment.sofafrag.TextFragment;
import com.example.day1217_proj1.fragment.sofafrag.VideoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SofaFragment extends Fragment {


    private TabLayout tab_sofa;
    private ViewPager vp_sofa;
    private ArrayList<Fragment> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sofa, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
    }

    private void initView(View view) {
        tab_sofa = view.findViewById(R.id.tab_sofa);
        vp_sofa = view.findViewById(R.id.vp_sofa);
        list = new ArrayList<>();
        list.add(new PicFragment());
        list.add(new VideoFragment());
        list.add(new TextFragment());
        MyFragAdapter adapter = new MyFragAdapter(getChildFragmentManager(), list);
        vp_sofa.setAdapter(adapter);
        tab_sofa.setupWithViewPager(vp_sofa);
        tab_sofa.getTabAt(0).setText("图片");
        tab_sofa.getTabAt(1).setText("视频");
        tab_sofa.getTabAt(2).setText("文本");


    }
}