package com.example.zuoye.mvp.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zuoye.R;
import com.example.zuoye.mvp.adapter.MyVpAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThesofaFragment extends Fragment {

    public ThesofaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thesofa, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        TabLayout tl = view.findViewById(R.id.thesofa_tl);
        ViewPager vp = view.findViewById(R.id.thesofa_vp);
        ArrayList<Fragment> list = new ArrayList<>();
        PictureFragment pictureFragment = new PictureFragment();
        VideoFragment videoFragment = new VideoFragment();
        TextFragment textFragment = new TextFragment();
        list.add(pictureFragment);
        list.add(videoFragment);
        list.add(textFragment);
        MyVpAdapter myVpAdapter = new MyVpAdapter(getChildFragmentManager(), list);
        vp.setAdapter(myVpAdapter);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("图片");
        tl.getTabAt(1).setText("视频");
        tl.getTabAt(2).setText("文本");
    }
}
