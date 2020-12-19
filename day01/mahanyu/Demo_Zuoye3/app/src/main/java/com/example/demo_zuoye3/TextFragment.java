package com.example.demo_zuoye3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo_zuoye3.adapter.TextAdapter;
import com.example.demo_zuoye3.adapter.VieoAdapter;
import com.example.demo_zuoye3.bean.TextBean;
import com.example.demo_zuoye3.bean.ViewoBean;
import com.example.demo_zuoye3.prester.PicPrester;
import com.example.demo_zuoye3.view.IView;

import java.util.ArrayList;
import java.util.List;

public class TextFragment extends Fragment implements IView {
    private RecyclerView re;
    private PicPrester picPrester;
    private ArrayList<TextBean.DataBeanX.DataBean> list;
    private TextAdapter textAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_text, container, false);
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
         textAdapter = new TextAdapter(getContext(), list);
         re.setAdapter(textAdapter);
     }

    @Override
    public void showSuccessUi(Object object) {
        if (object instanceof TextBean) {
            TextBean object1 = (TextBean) object;
            List<TextBean.DataBeanX.DataBean> data = object1.getData().getData();
            list.addAll(data);
        }
        textAdapter.notifyDataSetChanged();
    }

    @Override
    public void showFailUi(String msg) {

    }
}