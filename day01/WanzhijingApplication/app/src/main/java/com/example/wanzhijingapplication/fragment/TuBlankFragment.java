package com.example.wanzhijingapplication.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wanzhijingapplication.R;
import com.example.wanzhijingapplication.bean.Shipin;
import com.example.wanzhijingapplication.bean.Tu;
import com.example.wanzhijingapplication.bean.WenBen;
import com.example.wanzhijingapplication.bean.WodeBean;
import com.example.wanzhijingapplication.iview.IView;
import com.example.wanzhijingapplication.mdapter.TuMadapter;
import com.example.wanzhijingapplication.precick.Precick;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuBlankFragment extends Fragment implements IView {


    private RecyclerView rv;
    private ArrayList<Tu.DataBeanX.DataBean> dataBeans;
    private TuMadapter tuMadapter;

    public TuBlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tu_blank, container, false);
        rv = view.findViewById(R.id.rv);
        initData();
        initView();
        return view;
    }

    private void initView() {
        Precick precick = new Precick(this);
        precick.portu();
    }

    private void initData() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataBeans = new ArrayList<>();
        tuMadapter = new TuMadapter(getActivity(), dataBeans);
        rv.setAdapter(tuMadapter);

    }

    @Override
    public void tupian(Tu tu) {
        dataBeans.addAll(tu.getData().getData());
        tuMadapter.item(dataBeans);

    }

    @Override
    public void shipin(Shipin shipin) {

    }

    @Override
    public void wenben(WenBen wenBen) {

    }

    @Override
    public void wode(WodeBean wenBen) {

    }

    @Override
    public void shi(String string) {
        Log.d("tag",string);
    }
}
