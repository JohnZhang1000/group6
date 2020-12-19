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
import com.example.wangchujie.bean.TvBean;

import java.nio.file.Path;
import java.util.ArrayList;

public class TVAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<TvBean.DataBean.ListBean> tvBeans;
    private Context context;

    public TVAdapter(ArrayList<TvBean.DataBean.ListBean> tvBeans, Context context) {
        this.tvBeans = tvBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new ViewHolder0(LayoutInflater.from(context).inflate(R.layout.tv_item1_layout, parent, false));
        } else if (viewType == 1) {
            return new ViewHolder1(LayoutInflater.from(context).inflate(R.layout.tv_item2_layout, parent, false));
        } else {
            return new ViewHolder2(LayoutInflater.from(context).inflate(R.layout.tv_item3_layout, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int type = getItemViewType(position);

        if (type == 0) {
            ViewHolder0 holder0 = (ViewHolder0) holder;
            holder0.title.setText(tvBeans.get(position).getTitle());
            if (tvBeans.get(position).getFilePathList().size()>0){
                Glide.with(context).load(tvBeans.get(position).getFilePathList().get(0).getFilePath()).into(holder0.img1);
                Glide.with(context).load(tvBeans.get(position).getFilePathList().get(1).getFilePath()).into(holder0.img2);
                Glide.with(context).load(tvBeans.get(position).getFilePathList().get(2).getFilePath()).into(holder0.img3);
            }
            holder0.time.setText(tvBeans.get(position).getCreateTime());
        } else if (type == 1) {
            ViewHolder1 holder1 = (ViewHolder1) holder;
            holder1.title.setText(tvBeans.get(position).getTitle());
            Glide.with(context).load(tvBeans.get(position).getFilePathList().get(0).getFilePath()).into(holder1.img);
            holder1.time.setText(tvBeans.get(position).getCreateTime());
        } else {
            ViewHolder2 holder2 = (ViewHolder2) holder;
            holder2.title.setText(tvBeans.get(position).getTitle());
            holder2.time.setText(tvBeans.get(position).getCreateTime());
        }

    }

    @Override
    public int getItemCount() {
        return tvBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return 0;
        } else if (position % 3 == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    class ViewHolder0 extends ViewHolder {
        TextView title;
        ImageView img1;
        ImageView img2;
        ImageView img3;
        TextView time;

        public ViewHolder0(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_item_title);
            img1 = itemView.findViewById(R.id.tv_item_img1);
            img2 = itemView.findViewById(R.id.tv_item_img2);
            img3 = itemView.findViewById(R.id.tv_item_img3);
            time = itemView.findViewById(R.id.tv_item_time);
        }
    }

    class ViewHolder1 extends ViewHolder {
        TextView title;
        ImageView img;
        TextView time;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_item2_title);
            img = itemView.findViewById(R.id.tv_item2_img);
            time = itemView.findViewById(R.id.tv_item2_time);
        }
    }

    class ViewHolder2 extends ViewHolder {
        TextView title;
        TextView time;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_item3_title);
            time = itemView.findViewById(R.id.tv_item3_time);
        }
    }

}
