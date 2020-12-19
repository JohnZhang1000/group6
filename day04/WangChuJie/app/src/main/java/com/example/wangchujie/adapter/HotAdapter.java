package com.example.wangchujie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.wangchujie.R;
import com.example.wangchujie.bean.HotBean;

import java.util.ArrayList;

public class HotAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final ArrayList<HotBean.DataBean> dataBeans;
    private final Context context;

    public HotAdapter(ArrayList<HotBean.DataBean> dataBeans, Context context) {
        this.dataBeans = dataBeans;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder0(LayoutInflater.from(context).inflate(R.layout.hot_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder0 holder0 = (ViewHolder0) holder;
        Glide.with(context).load(dataBeans.get(position).getCover()).apply(new RequestOptions().transforms(new RoundedCorners(15))).into(holder0.img);
        holder0.title.setText(dataBeans.get(position).getTitle());
        holder0.location.setText(dataBeans.get(position).getLocation());
        holder0.applyCutOffTime.setText(dataBeans.get(position).getApplyCutOffTime());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    class ViewHolder0 extends ViewHolder {
        ImageView img;
        TextView title;
        TextView location;
        TextView applyCutOffTime;

        public ViewHolder0(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.hot_item_img);
            title = itemView.findViewById(R.id.hot_item_title);
            location = itemView.findViewById(R.id.hot_item_location);
            applyCutOffTime = itemView.findViewById(R.id.hot_item_time);
        }
    }
}
