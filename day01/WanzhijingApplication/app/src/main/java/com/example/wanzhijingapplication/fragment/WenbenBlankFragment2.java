package com.example.wanzhijingapplication.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wanzhijingapplication.R;
import com.example.wanzhijingapplication.bean.Shipin;
import com.example.wanzhijingapplication.bean.Tu;
import com.example.wanzhijingapplication.bean.WenBen;
import com.example.wanzhijingapplication.bean.WodeBean;
import com.example.wanzhijingapplication.iview.IView;
import com.example.wanzhijingapplication.mdapter.Wenbendapter;
import com.example.wanzhijingapplication.precick.Precick;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WenbenBlankFragment2 extends Fragment implements IView {


    private RecyclerView rv;
    private ArrayList<WenBen.DataBeanX.DataBean> dataBeans;
    private Wenbendapter wenbendapter;

    public WenbenBlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_wenben_blank_fragment2, container, false);
        rv = view.findViewById(R.id.rv);
        initData();
        initView();
        return view;
    }

    private void initView() {
        Precick precick = new Precick(this);
        precick.porwenben();

    }

    private void initData() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataBeans = new ArrayList<>();
        wenbendapter = new Wenbendapter(getActivity(),dataBeans);
        rv.setAdapter(wenbendapter);

    }

    @Override
    public void tupian(Tu tu) {

    }

    @Override
    public void shipin(Shipin shipin) {

    }

    @Override
    public void wenben(WenBen wenBen) {
        dataBeans.addAll(wenBen.getData().getData());
        wenbendapter.item(dataBeans);

    }

    @Override
    public void wode(WodeBean wenBen) {

    }

    @Override
    public void shi(String string) {

    }
}
