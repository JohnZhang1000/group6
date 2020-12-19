package com.example.wanzhijingapplication.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wanzhijingapplication.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShafaFragment2 extends Fragment {


    private TabLayout tab;
    private ViewPager pager;

    public ShafaFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_shafa_fragment2, container, false);
        tab = view.findViewById(R.id.tab);
        pager = view.findViewById(R.id.pager);
        initData();
        return view;
    }

    private void initData() {
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new TuBlankFragment());
        fragments.add(new ShipinBlankFragment());
        fragments.add(new WenbenBlankFragment2());
        pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tab.setupWithViewPager(pager);
        tab.getTabAt(0).setText("图片");
        tab.getTabAt(1).setText("视频");
        tab.getTabAt(2).setText("文本");
    }

}
