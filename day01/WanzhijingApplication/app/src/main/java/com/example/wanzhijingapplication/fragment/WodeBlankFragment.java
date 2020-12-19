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
public class WodeBlankFragment extends Fragment {


    private TabLayout tab;
    private ViewPager pager;

    public WodeBlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_wode_blank, container, false);
        tab = view.findViewById(R.id.tab);
        pager = view.findViewById(R.id.pager);
        initData();
        return view;
    }

    private void initData() {
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new GunzhuFragment());
        fragments.add(new TuijianFragment2());
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
        tab.getTabAt(0).setText("关注");
        tab.getTabAt(1).setText("推荐");

    }

}
