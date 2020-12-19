package com.umeng.zhangwentao_tongpao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.umeng.zhangwentao_tongpao.R;
import com.umeng.zhangwentao_tongpao.databean.HotDatabean;

import java.util.ArrayList;

/**
 * 项目名:zhangwentao_tongpao
 * 包名:com.umeng.zhangwentao_tongpao.adapter
 * 创建者: 张文涛
 * 创建时间: 2020/12/18
 */
public class FaXianRcyAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<HotDatabean.DataBean> list;
    private HotDatabean.DataBean bean;

    public FaXianRcyAdapter(Context context, ArrayList<HotDatabean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.remen, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HotDatabean.DataBean bean = list.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(bean.getCover()).into(viewHolder.remen_iv);
        viewHolder.femen_tv.setText(bean.getTitle());
        viewHolder.femen_tv2.setText(bean.getLocation());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView remen_iv;
        public TextView femen_tv;
        public TextView femen_tv2;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.remen_iv = (ImageView) rootView.findViewById(R.id.remen_iv);
            this.femen_tv = (TextView) rootView.findViewById(R.id.femen_tv);
            this.femen_tv2 = (TextView) rootView.findViewById(R.id.femen_tv2);
        }

    }
}
