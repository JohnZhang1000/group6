package com.example.day1224_homework.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.day1224_homework.R;
import com.example.day1224_homework.activity.DituActivity;
import com.example.day1224_homework.activity.WeizhiActivity;
import com.example.day1224_homework.adapter.MyFragAdapter;
import com.example.day1224_homework.fragment2.PaihangFragment;
import com.example.day1224_homework.fragment2.PaoziFragment;
import com.example.day1224_homework.fragment2.ShetuanFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.Unbinder;


public class FindFragment extends Fragment {


    private FragmentActivity activity;
    private Unbinder bind;
    private ArrayList<Fragment> list;
    private MyFragAdapter adapter;
    private TabLayout tab_find;
    private ViewPager vp_find;

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
        list.add(new PaoziFragment());
        list.add(new ShetuanFragment());
        list.add(new PaihangFragment());
        adapter = new MyFragAdapter(getChildFragmentManager(), list);
        vp_find.setAdapter(adapter);
        tab_find.setupWithViewPager(vp_find);
        tab_find.getTabAt(0).setText("袍子");
        tab_find.getTabAt(1).setText("社团");
        tab_find.getTabAt(2).setText("排行");
        tab_find.addTab(tab_find.newTab().setText("地图").setIcon(R.drawable.ic_baseline_healing_24));
        tab_find.addTab(tab_find.newTab().setText("位置").setIcon(R.drawable.ic_baseline_room_24));

        tab_find.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:
                        //跳转到地图页面
                        startActivity(new Intent(activity, DituActivity.class));
                        break;
                    case 4:
                        //跳转到定位页面
                        startActivity(new Intent(activity, WeizhiActivity.class));


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


}