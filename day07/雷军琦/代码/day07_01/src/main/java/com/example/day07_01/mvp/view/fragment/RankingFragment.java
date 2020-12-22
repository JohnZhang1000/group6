package com.example.day07_01.mvp.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.day07_01.R;
import com.example.day07_01.mvp.adapter.MyRanAdapter;
import com.example.day07_01.mvp.model.bean.IevelBean;
import com.example.day07_01.mvp.presenter.FragPresenter;
import com.example.day07_01.mvp.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankingFragment extends Fragment implements IView {

    private ArrayList<IevelBean.DataBean.ExpTopBean.ListBean> list;
    private MyRanAdapter myRanAdapter;

    public RankingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ranking, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        new FragPresenter(this).StaticLevel();
    }

    private void initView(View view) {
        RecyclerView rv = view.findViewById(R.id.rv_ranking);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        list = new ArrayList<>();
        myRanAdapter = new MyRanAdapter(getContext(), list);
        rv.setAdapter(myRanAdapter);
    }

    @Override
    public void ShowSuccess(Object object) {
        if (object instanceof IevelBean){
            IevelBean ievelBean= (IevelBean) object;
            List<IevelBean.DataBean.ExpTopBean.ListBean> lists = ievelBean.getData().getExpTop().getList();
            list.addAll(lists);
            myRanAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void ShowFile(String err) {

    }
}
