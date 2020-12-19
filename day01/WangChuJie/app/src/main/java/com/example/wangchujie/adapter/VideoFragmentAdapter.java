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

import com.example.wangchujie.bean.VideoBean;

import java.util.ArrayList;

import cn.jzvd.JzvdStd;

public class VideoFragmentAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final ArrayList<VideoBean.DataBeanX.DataBean> videoBeans;
    private final Context context;

    public VideoFragmentAdapter(ArrayList<VideoBean.DataBeanX.DataBean> videoBeans, Context context) {
        this.videoBeans = videoBeans;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder0(LayoutInflater.from(context).inflate(R.layout.item_video_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder0 holder0 = (ViewHolder0) holder;
        Glide.with(context).load(videoBeans.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder0.header_img);
        holder0.name.setText(videoBeans.get(position).getAuthor().getName());
        holder0.desc.setText(videoBeans.get(position).getFeeds_text());

        holder0.mJzVideo.setUp(videoBeans.get(position).getUrl()
                , videoBeans.get(position).getAuthor().getName());
    }

    @Override
    public int getItemCount() {
        return videoBeans.size();
    }

    class ViewHolder0 extends ViewHolder {
        ImageView header_img;
        TextView name;
        TextView desc;
        JzvdStd mJzVideo;

        public ViewHolder0(@NonNull View itemView) {
            super(itemView);
            header_img = itemView.findViewById(R.id.img_item_header_img);
            name = itemView.findViewById(R.id.img_item_name);
            desc = itemView.findViewById(R.id.img_item_desc);
            mJzVideo = itemView.findViewById(R.id.jz);
        }
    }
}
