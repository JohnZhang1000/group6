package com.example.zuoye.mvp.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zuoye.R;
import com.example.zuoye.mvp.adapter.MyReAdapter;
import com.example.zuoye.mvp.model.bean.PictureBean;
import com.example.zuoye.mvp.persenter.FragPersenter;
import com.example.zuoye.mvp.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment implements IView {

    private List<PictureBean.DataBeanX.DataBean> list;
    private MyReAdapter myReAdapter;

    public PictureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picture, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        new FragPersenter(this).Picture();
    }

    private void initView(View view) {
        RecyclerView rv = view.findViewById(R.id.picture_rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        myReAdapter = new MyReAdapter(getContext(), list);
        rv.setAdapter(myReAdapter);
    }

    @Override
    public void ShowScuessUi(Object object) {
        if (object instanceof PictureBean){
            PictureBean pictureBean= (PictureBean) object;
            List<PictureBean.DataBeanX.DataBean> data = pictureBean.getData().getData();
            list.addAll(data);
            myReAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void ShowFileUi(String err) {

    }
}
