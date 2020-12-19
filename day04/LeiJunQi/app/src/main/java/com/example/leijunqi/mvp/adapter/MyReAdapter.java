package com.example.leijunqi.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.leijunqi.R;
import com.example.leijunqi.mvp.model.bean.HotBean;

import java.util.ArrayList;

public class MyReAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HotBean.DataBean> list;

    public MyReAdapter(Context context, ArrayList<HotBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_re_rcy, parent, false);
        return new ViewHolder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 holder1= (ViewHolder1) holder;
        HotBean.DataBean dataBean = list.get(position);
        Glide.with(context).load(dataBean.getCover()).apply(new RequestOptions().bitmapTransform(new RoundedCorners(15))).into(holder1.iv_cover);
        holder1.tv_location.setText(dataBean.getLocation());
        String[] s = dataBean.getStartTime().split(" ");
        holder1.tv_startTime.setText(s[0]);
        holder1.tv_title.setText(dataBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_cover;
        public TextView tv_title;
        public TextView tv_location;
        public TextView tv_startTime;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_cover = (ImageView) rootView.findViewById(R.id.iv_cover);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_location = (TextView) rootView.findViewById(R.id.tv_location);
            this.tv_startTime = (TextView) rootView.findViewById(R.id.tv_startTime);
        }

    }
}
