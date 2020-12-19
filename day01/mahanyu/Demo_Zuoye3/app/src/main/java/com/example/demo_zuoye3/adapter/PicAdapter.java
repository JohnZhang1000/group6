package com.example.demo_zuoye3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.demo_zuoye3.R;
import com.example.demo_zuoye3.bean.ImageBean;

import java.util.ArrayList;

public class PicAdapter extends RecyclerView.Adapter<PicAdapter.ViewHOlder> {
    private Context context;
    private ArrayList<ImageBean.DataBeanX.DataBean> list;

    public PicAdapter(Context context, ArrayList<ImageBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_pic, parent, false);
        return new ViewHOlder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHOlder holder, int position) {

        Glide.with(context).load(list.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder.img);
        holder.tv_name.setText(list.get(position).getAuthor().getName());
        Glide.with(context).load(list.get(position).getCover()).into(holder.iv_a);
        holder.tv_title.setText(list.get(position).getFeeds_text());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHOlder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView tv_name;
        public TextView tv_title;
        public ImageView iv_a;

        public ViewHOlder(@NonNull View itemView) {
            super(itemView);
            this.img = (ImageView) itemView.findViewById(R.id.img);
            this.tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            this.tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            this.iv_a = (ImageView) itemView.findViewById(R.id.iv_a);
        }
    }


}
