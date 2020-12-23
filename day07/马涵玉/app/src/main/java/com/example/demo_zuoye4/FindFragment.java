package com.example.demo_zuoye4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo_zuoye4.adapter.MyRcAdapter;
import com.example.demo_zuoye4.bean.HotBean;
import com.example.demo_zuoye4.bean.TabBean;
import com.example.demo_zuoye4.preseter.FindPrester;
import com.example.demo_zuoye4.view.IView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class FindFragment extends Fragment implements IView {

    private RecyclerView rv;
    private ViewPager vp;
    private TabLayout tab2;
    private FindPrester prester;
    private ArrayList<HotBean.DataBean> list;
    private MyRcAdapter myRcAdapter;


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
        rv = view.findViewById(R.id.re);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        myRcAdapter = new MyRcAdapter(getContext(),list);
        rv.setAdapter(myRcAdapter);
    }
    @Override
    public void showSuccessUi(Object object) {
        if (object instanceof HotBean){
            HotBean hotBean= (HotBean) object;
            List<HotBean.DataBean> data = hotBean.getData();
            list.addAll(data);
            myRcAdapter.notifyDataSetChanged();
            Log.e("TAG","成功");
        }
    }

    @Override
    public void showFailUi(String msg) {
        Log.e("TAG","失败");
    }


}