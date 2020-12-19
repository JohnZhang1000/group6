package com.example.day1218_04tongpao.fragment.fragcenter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day1218_04tongpao.R;
import com.example.day1218_04tongpao.adapter.MyHotAdapter;
import com.example.day1218_04tongpao.bean.HotBean;
import com.example.day1218_04tongpao.presenter.MyPresenter;
import com.example.day1218_04tongpao.view.IView;

import java.util.ArrayList;
import java.util.List;


public class HotFragment extends Fragment implements IView {


    private RecyclerView rcy_hot;
    private FragmentActivity activity;
    private ArrayList<HotBean.DataBean.ListBean> list;
    private MyHotAdapter adapter;
    private ArrayList<String> beans;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hot, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        MyPresenter myPresenter = new MyPresenter(this);
        myPresenter.getData();

    }

    private void initView(View view) {
        rcy_hot = view.findViewById(R.id.rcy_hot);
        rcy_hot.setLayoutManager(new LinearLayoutManager(activity));
        list = new ArrayList<>();
        beans = new ArrayList<>();
        adapter = new MyHotAdapter(activity, list, beans);
        rcy_hot.setAdapter(adapter);


    }

    @Override
    public void getSuccessUi(Object obj) {
        if (obj instanceof HotBean) {
            HotBean hotBean = (HotBean) obj;
            List<HotBean.DataBean.ListBean> list2 = hotBean.getData().getList();
            list.addAll(list2);


            String filePath = hotBean.getData().getList().get(0).getFilePathList().get(0).getFilePath();
            beans.add(filePath);


            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void getFailUi(String msg) {
        Log.e("TAG", "hot传输成功");

    }
}