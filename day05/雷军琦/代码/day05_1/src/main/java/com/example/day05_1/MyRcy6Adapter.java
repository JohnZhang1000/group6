package com.example.day05_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyRcy6Adapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Integer> list;

    public MyRcy6Adapter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rcy6_rcy, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(context).load(list.get(position)).into(viewHolder.iv_rcy6_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_rcy6_img;
        public TextView tv_biaoti;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_rcy6_img = (ImageView) rootView.findViewById(R.id.iv_rcy6_img);
            this.tv_biaoti = (TextView) rootView.findViewById(R.id.tv_biaoti);
        }

    }
}
