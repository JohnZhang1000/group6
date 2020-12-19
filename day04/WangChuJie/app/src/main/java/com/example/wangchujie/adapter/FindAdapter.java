package com.example.wangchujie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;


import com.example.wangchujie.R;
import com.example.wangchujie.bean.HotBean;

import java.util.ArrayList;

public class FindAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    private ArrayList<HotBean.DataBean> dataBeans;
    private HotAdapter mAdapter;

    public FindAdapter(Context context, ArrayList<HotBean.DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder0(LayoutInflater.from(context).inflate(R.layout.find_top_layout, parent, false));

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder0 holder0 = (ViewHolder0) holder;
        holder0.rec.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        mAdapter = new HotAdapter(dataBeans, context);
        holder0.rec.setAdapter(mAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder0 extends ViewHolder {

        RecyclerView rec;

        public ViewHolder0(@NonNull View itemView) {
            super(itemView);
            rec = itemView.findViewById(R.id.hot_rec);
        }
    }

}
