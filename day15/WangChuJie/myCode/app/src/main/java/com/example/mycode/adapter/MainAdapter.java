package com.example.mycode.adapter;

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
import com.example.mycode.R;
import com.example.mycode.bean.TopicBean;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<TopicBean.DataBean> topicBeans;
    private Context context;

    public MainAdapter(ArrayList<TopicBean.DataBean> topicBeans, Context context) {
        this.topicBeans = topicBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder0(LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder0 holder0 = (ViewHolder0) holder;
        Glide.with(context).load(topicBeans.get(position).getImageUrl()).into(holder0.imageUrl);
        holder0.name.setText(topicBeans.get(position).getName());
        holder0.attentionNum.setText("#"+topicBeans.get(position).getAttentionNum()+"#");
    }

    @Override
    public int getItemCount() {
        return topicBeans.size();
    }

    class ViewHolder0 extends ViewHolder {
        TextView name;
        ImageView imageUrl;
        TextView attentionNum;
        public ViewHolder0(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            imageUrl = itemView.findViewById(R.id.item_img);
            attentionNum = itemView.findViewById(R.id.item_attentionNum);
        }
    }
}
