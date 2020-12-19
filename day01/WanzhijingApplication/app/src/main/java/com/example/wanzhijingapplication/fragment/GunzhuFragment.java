package com.example.wanzhijingapplication.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wanzhijingapplication.R;
import com.example.wanzhijingapplication.SqBean;
import com.example.wanzhijingapplication.SqUtlis;
import com.example.wanzhijingapplication.bean.Shipin;
import com.example.wanzhijingapplication.bean.Tu;
import com.example.wanzhijingapplication.bean.WenBen;
import com.example.wanzhijingapplication.bean.WodeBean;
import com.example.wanzhijingapplication.iview.IView;
import com.example.wanzhijingapplication.mdapter.Guanadapter;
import com.example.wanzhijingapplication.precick.Precick;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GunzhuFragment extends Fragment implements IView {


    private RecyclerView rv;
    private ArrayList<WodeBean.DataBeanX.DataBean> dataBeans;
    private Guanadapter guanadapter;

    public GunzhuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gunzhu, container, false);
        rv = view.findViewById(R.id.rv);
        initData();
        initView();
        return view;
    }

    private void initView() {
        Precick precick = new Precick(this);
        precick.por();
    }

    private void initData() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataBeans = new ArrayList<>();
        guanadapter = new Guanadapter(getActivity(), dataBeans);
        rv.setAdapter(guanadapter);
        guanadapter.setIoncick(new Guanadapter.Ioncick() {
            @Override
            public void ioncick(int pos) {
                SqBean sqBean = new SqBean();
                WodeBean.DataBeanX.DataBean dataBean = dataBeans.get(pos);
                String title = dataBean.getTitle();
                String activityIcon = dataBean.getActivityIcon();
                sqBean.setText(title);
                sqBean.setUrl(activityIcon);
                Long insert = SqUtlis.getSqUtlis().insert(sqBean);
                if(insert>0){
                    Toast.makeText(getActivity(), "添加成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void tupian(Tu tu) {

    }

    @Override
    public void shipin(Shipin shipin) {

    }

    @Override
    public void wenben(WenBen wenBen) {

    }

    @Override
    public void wode(WodeBean wenBen) {
        dataBeans.addAll(wenBen.getData().getData());
        guanadapter.item(dataBeans);
        guanadapter.notifyDataSetChanged();

    }

    @Override
    public void shi(String string) {
        Log.d("tag",string);
    }

}
