package com.example.day09_01.mvp.mvp.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day09_01.R;
import com.example.day09_01.mvp.adapter.MyRcAdapter;
import com.example.day09_01.mvp.mvp.model.bean.HotBean;
import com.example.day09_01.mvp.mvp.presenter.ThesofaFrgPresenter;
import com.example.day09_01.mvp.mvp.ui.IView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThesofaFragment extends Fragment implements IView {

    private ArrayList<HotBean.DataBean> list;
    private MyRcAdapter myRcAdapter;

    public ThesofaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thesofa, container, false);
        initView(view);
        initData();
        return view;
    }
    private void initData() {
        new ThesofaFrgPresenter(this).start();
    }

    private void initView(View view) {
        RecyclerView rv = view.findViewById(R.id.thesofa_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        myRcAdapter = new MyRcAdapter(getContext(),list);
        rv.setAdapter(myRcAdapter);
    }

    @Override
    public void ShowSuccess(Object object) {

    }

    @Override
    public void ShowFile(String err) {

    }
}
