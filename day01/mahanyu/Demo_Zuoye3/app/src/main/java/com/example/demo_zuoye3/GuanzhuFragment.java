package com.example.demo_zuoye3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo_zuoye3.adapter.DbAdapter;
import com.example.demo_zuoye3.adapter.FindAdapter;
import com.example.demo_zuoye3.bean.FindBean;
import com.example.demo_zuoye3.bean.Smart;
import com.example.demo_zuoye3.prester.PicPrester;

import java.util.ArrayList;
import java.util.List;

public class GuanzhuFragment extends Fragment {
    private RecyclerView re;
    private ArrayList<Smart> list;
    private DbAdapter dbAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_guanzhu, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
       list.clear();
       dbAdapter.notifyDataSetChanged();
        List<Smart> smarts = App.daoSession.getSmartDao().loadAll();
        list.addAll(smarts);
        dbAdapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        re = view.findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        dbAdapter = new DbAdapter(getContext(), list);
        re.setAdapter(dbAdapter);
    }


}