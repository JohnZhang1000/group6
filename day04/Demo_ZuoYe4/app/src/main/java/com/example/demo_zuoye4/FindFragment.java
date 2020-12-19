package com.example.demo_zuoye4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo_zuoye4.bean.HotBean;
import com.example.demo_zuoye4.bean.TabBean;
import com.example.demo_zuoye4.preseter.FindPrester;
import com.example.demo_zuoye4.view.IView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class FindFragment extends Fragment implements IView {
    private TabLayout tab;
    private RecyclerView re;
    private ViewPager vp;
    private TabLayout tab2;
    private FindPrester prester;
    private ArrayList<HotBean.DataBean> hotlist;
    private ArrayList<TabBean.DataBean> tablist;
    private ReAdapter reAdapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        prester = new FindPrester(this);
        prester.start();
    }

    private void initView(View view) {
        re = view.findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        hotlist = new ArrayList<>();
        tablist = new ArrayList<>();
        reAdapter = new ReAdapter(getContext(), hotlist, tablist);
        re.setAdapter(reAdapter);
    }

    @Override
    public void showSuccessUi(Object object) {
       if(object instanceof HotBean){
           HotBean object1 = (HotBean) object;
           List<HotBean.DataBean> data = object1.getData();
           hotlist.addAll(data);
       }
       reAdapter.notifyDataSetChanged();
    }

    @Override
    public void showFailUi(String msg) {

    }

//    private void initData() {
//
//
//
//    }

//    private void initView(View view) {
//        tab = view.findViewById(R.id.tab);
//        re = view.findViewById(R.id.re);
//        LinearLayoutManager manager = new LinearLayoutManager(getContext());
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
//
//        re.setLayoutManager(manager);
//        vp = view.findViewById(R.id.vp);
//        tab2 = view.findViewById(R.id.tab2);
//    }

}