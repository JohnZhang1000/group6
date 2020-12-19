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
import com.example.wanzhijingapplication.mdapter.VideoFragmentAdapter;
import com.example.wanzhijingapplication.precick.Precick;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShipinBlankFragment extends Fragment implements IView {


    private RecyclerView rv1;
    private VideoFragmentAdapter videoFragmentAdapter;
    private ArrayList<Shipin.DataBeanX.DataBean> dataBeans;

    public ShipinBlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_shipin, container, false);
        rv1 = view.findViewById(R.id.rv);
        initData();
        initView();
        return view;
    }

    private void initView() {
        Precick precick = new Precick(this);
        precick.porshipin();
    }

    private void initData() {
        rv1.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataBeans = new ArrayList<>();
        videoFragmentAdapter = new VideoFragmentAdapter(dataBeans, getActivity());
        rv1.setAdapter(videoFragmentAdapter);


    }


    @Override
    public void tupian(Tu tu) {

    }

    @Override
    public void shipin(Shipin shipin) {
        dataBeans.addAll(shipin.getData().getData());
        videoFragmentAdapter.notifyDataSetChanged();

    }

    @Override
    public void wenben(WenBen wenBen) {

    }

    @Override
    public void wode(WodeBean wenBen) {

    }

    @Override
    public void shi(String string) {

    }
}
