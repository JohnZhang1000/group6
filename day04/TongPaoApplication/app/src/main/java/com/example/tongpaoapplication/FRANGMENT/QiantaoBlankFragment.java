package com.example.tongpaoapplication.FRANGMENT;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.tongpaoapplication.FRANGMENT.dapter.Fuyongdapter;
import com.example.tongpaoapplication.R;
import com.example.tongpaoapplication.bean.Fenlei;
import com.example.tongpaoapplication.bean.Remenbean;
import com.example.tongpaoapplication.iview.IView;
import com.example.tongpaoapplication.precick.Precick;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QiantaoBlankFragment extends Fragment implements IView {


    private final int type;
    private RecyclerView rv;
    private List<Fenlei.DataBean.ListBean> list;
    private Fuyongdapter fuyongdapter;

    public QiantaoBlankFragment(int type) {
        // Required empty public constructor
        this.type = type;
        Log.i("TAG", "QiantaoBlankFragment: "+type);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_qiantao_blank, container, false);
        rv = view.findViewById(R.id.rv);
        list = new ArrayList<>();
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        fuyongdapter = new Fuyongdapter(getActivity(), list);
        rv.setAdapter(fuyongdapter);
        initData();
        return view;
    }

    private void initData() {
        Precick precick = new Precick(this);
        precick.porfenlei(type);

    }

    @Override
    public void renmen(Remenbean remenbean) {

    }

    @Override
    public void fenlei(Fenlei fenlei) {
        List<Fenlei.DataBean.ListBean> list1 = fenlei.getData().getList();
        list.addAll(list1);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fuyongdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void shi(String string) {

    }
}
