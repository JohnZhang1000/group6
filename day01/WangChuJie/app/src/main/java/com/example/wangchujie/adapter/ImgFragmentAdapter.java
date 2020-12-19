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
import com.bumptech.glide.request.RequestOptions;
import com.example.wangchujie.R;
import com.example.wangchujie.bean.ImgBean;

import java.util.ArrayList;

public class ImgFragmentAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<ImgBean.DataBeanX.DataBean> imgBeans;
    private Context context;

    public ImgFragmentAdapter(ArrayList<ImgBean.DataBeanX.DataBean> imgBeans, Context context) {
        this.imgBeans = imgBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder0(LayoutInflater.from(context).inflate(R.layout.item_img_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder0 holder0 = (ViewHolder0) holder;
        Glide.with(context).load(imgBeans.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder0.header_img);
        holder0.name.setText(imgBeans.get(position).getAuthor().getName());
        holder0.desc.setText(imgBeans.get(position).getFeeds_text());
        Glide.with(context).load(imgBeans.get(position).getCover()).into(holder0.img);
        holder0.text.setText(imgBeans.get(position).getActivityText());
    }

    @Override
    public int getItemCount() {
        return imgBeans.size();
    }

    class ViewHolder0 extends ViewHolder {
        ImageView header_img;
        TextView name;
        TextView desc;
        ImageView img;
        TextView text;

        public ViewHolder0(@NonNull View itemView) {
            super(itemView);
            header_img = itemView.findViewById(R.id.img_item_header_img);
            name = itemView.findViewById(R.id.img_item_name);
            desc = itemView.findViewById(R.id.img_item_desc);
            img = itemView.findViewById(R.id.img_item_img);
            text = itemView.findViewById(R.id.img_item_text);
        }
    }
}
