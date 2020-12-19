package com.example.day1217_proj1.fragment.sofafrag;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day1217_proj1.Adapter.MyRcyPicAdapter;
import com.example.day1217_proj1.R;
import com.example.day1217_proj1.bean.PicBean;
import com.example.day1217_proj1.presenter.MyPresenter;
import com.example.day1217_proj1.view.IView;

import java.util.ArrayList;
import java.util.List;


public class PicFragment extends Fragment implements IView {


    private RecyclerView rcy_pic;
    private FragmentActivity activity;
    private ArrayList<PicBean.DataBeanX.DataBean> list;
    private MyPresenter myPresenter;
    private MyRcyPicAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pic, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        myPresenter = new MyPresenter(this);
        myPresenter.startChange();

    }

    private void initView(View view) {
        rcy_pic = view.findViewById(R.id.rcy_pic);
        rcy_pic.setLayoutManager(new LinearLayoutManager(activity));
        rcy_pic.addItemDecoration(new DividerItemDecoration(activity,DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        adapter = new MyRcyPicAdapter(activity, list);
        rcy_pic.setAdapter(adapter);


    }

    @Override
    public void getSuccessUi(Object obj) {
        if(obj instanceof PicBean){
            PicBean picBean = (PicBean) obj;
            List<PicBean.DataBeanX.DataBean> data = picBean.getData().getData();
            list.addAll(data);
            adapter.notifyDataSetChanged();
            Log.e("TAG","传输成功");
        }

    }

    @Override
    public void getFailUi(String msg) {
        Log.e("TAG","传输失败"+msg);

    }
}