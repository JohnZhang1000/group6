package com.example.mycode.fragment;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvplibrary.base.BaseFragment;
import com.example.mycode.Bean;
import com.example.mycode.MyPresenter;
import com.example.mycode.R;
import com.example.mycode.adapter.HomeAdapter;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment<MyPresenter, Bean> {

    private static final String TAG = "HomeFragment";
    private RecyclerView mRec;
    private ArrayList<Bean.DataBean.DatasBean> datasBeans;
    private MyPresenter myPresenter;
    private HomeAdapter mAdapter;

    @Override
    protected MyPresenter createPresenter() {
        return myPresenter;
    }

    @Override
    protected void init() {
        myPresenter = new MyPresenter(this);
        View view = getLayoutInflater().inflate(getLayoutId(), null);
        mRec = view.findViewById(R.id.home_rec);

        mRec.setLayoutManager(new LinearLayoutManager(getContext()));
        datasBeans = new ArrayList<>();

        mAdapter = new HomeAdapter(datasBeans,getContext());
        mRec.setAdapter(mAdapter);

        iniData();
    }

    private void iniData() {
        myPresenter.start();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onSuccess(Bean bean) {
        super.onSuccess(bean);
        datasBeans.addAll(bean.getData().getDatas());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {
        super.onFail(msg);
        Log.d(TAG, "onFail: "+msg);
    }
}
