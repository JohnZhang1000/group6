package com.example.day1218_04tongpao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day1218_04tongpao.R;
import com.example.day1218_04tongpao.bean.ActivityBean;

import java.util.ArrayList;

public class MyRcyHorAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ActivityBean.DataBean> list;

    public MyRcyHorAdapter(Context context, ArrayList<ActivityBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_rcy_hor, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        ActivityBean.DataBean dataBean = list.get(position);
        holder1.tv_location.setText(dataBean.getLocation());
        holder1.tv_time.setText(dataBean.getEndTime());
        holder1.tv_title.setText(dataBean.getTitle());
        Glide.with(context).load(dataBean.getCover()).into(holder1.iv_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_img;
        public TextView tv_title;
        public TextView tv_location;
        public TextView tv_time;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_location = (TextView) rootView.findViewById(R.id.tv_location);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
        }

    }
}
