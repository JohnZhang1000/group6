package com.example.wanzhijingapplication.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wanzhijingapplication.R;
import com.example.wanzhijingapplication.SqBean;
import com.example.wanzhijingapplication.SqUtlis;
import com.example.wanzhijingapplication.mdapter.Tuijian;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuijianFragment2 extends Fragment {


    private RecyclerView rv;
    private Tuijian tuijian;
    private ArrayList<SqBean> sqBeans;

    public TuijianFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tuijian_fragment2, container, false);
        rv = view.findViewById(R.id.rv);
        initData();
        initView();
        return view;
    }

    private void initView() {
        List<SqBean> select = SqUtlis.getSqUtlis().select();
        sqBeans.addAll(select);
    }

    private void initData() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        sqBeans = new ArrayList<>();
        tuijian = new Tuijian(getActivity(), sqBeans);
        rv.setAdapter(tuijian);


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            sqBeans.clear();
            initView();
            tuijian.notifyDataSetChanged();
        }
    }
}
