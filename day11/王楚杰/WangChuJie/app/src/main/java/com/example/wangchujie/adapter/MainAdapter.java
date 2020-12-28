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
import com.example.wangchujie.R;
import com.example.wangchujie.bean.Bean;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<Bean.DataBean.PostDetailBean.LikeDetailsBean> likeDetailsBeans;
    private Context context;

    public MainAdapter(ArrayList<Bean.DataBean.PostDetailBean.LikeDetailsBean> likeDetailsBeans, Context context) {
        this.likeDetailsBeans = likeDetailsBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder0(LayoutInflater.from(context).inflate(R.layout.item_layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder0 holder0 = (ViewHolder0) holder;
        Glide.with(context).load(likeDetailsBeans.get(position).getHeadUrl()).into(holder0.img);
        holder0.title.setText(likeDetailsBeans.get(position).getNickName());
    }

    @Override
    public int getItemCount() {
        return likeDetailsBeans.size();
    }

    class ViewHolder0 extends ViewHolder {
        ImageView img;
        TextView title;
        public ViewHolder0(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_img);
            title = itemView.findViewById(R.id.item_title);
        }
    }
}
