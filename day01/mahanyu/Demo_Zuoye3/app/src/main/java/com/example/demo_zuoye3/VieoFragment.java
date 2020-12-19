package com.example.demo_zuoye3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo_zuoye3.adapter.VieoAdapter;
import com.example.demo_zuoye3.bean.ImageBean;
import com.example.demo_zuoye3.bean.ViewoBean;
import com.example.demo_zuoye3.prester.PicPrester;
import com.example.demo_zuoye3.view.IView;

import java.util.ArrayList;
import java.util.List;

public class VieoFragment extends Fragment implements IView {

    private RecyclerView re;
    private PicPrester picPrester;
    private ArrayList<ViewoBean.DataBeanX.DataBean> list;
    private VieoAdapter vieoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view=inflater.inflate(R.layout.fragment_vieo, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        picPrester = new PicPrester(this);
        picPrester.start();
    }

    private void initView(View view) {
        re = view.findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        vieoAdapter = new VieoAdapter(getContext(), list);
        re.setAdapter(vieoAdapter);
    }

    @Override
    public void showSuccessUi(Object object) {
        if (object instanceof ViewoBean) {
            ViewoBean object1 = (ViewoBean) object;
            List<ViewoBean.DataBeanX.DataBean> data = object1.getData().getData();
            list.addAll(data);
        }
        vieoAdapter.notifyDataSetChanged();
    }

    @Override
    public void showFailUi(String msg) {

    }
}