package com.example.day1217_proj1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.day1217_proj1.Adapter.MyFragAdapter;
import com.example.day1217_proj1.R;
import com.example.day1217_proj1.fragment.findfrag.NotisFragment;
import com.example.day1217_proj1.fragment.findfrag.TuiFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class FindFragment extends Fragment {


    private TabLayout tab_find;
    private ViewPager vp_find;
    private FragmentActivity activity;
    private ArrayList<Fragment> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab_find = view.findViewById(R.id.tab_find);
        vp_find = view.findViewById(R.id.vp_find);
        list = new ArrayList<>();
        list.add(new NotisFragment());
        list.add(new TuiFragment());
        MyFragAdapter adapter = new MyFragAdapter(getChildFragmentManager(), list);
        vp_find.setAdapter(adapter);
        tab_find.setupWithViewPager(vp_find);
        tab_find.getTabAt(0).setText("关注");
        tab_find.getTabAt(1).setText("推荐");


    }
}