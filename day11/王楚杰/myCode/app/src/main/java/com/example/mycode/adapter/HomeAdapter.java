package com.example.mycode.adapter;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;
import com.example.mycode.Bean;
import com.example.mycode.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class HomeAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<Bean.DataBean.DatasBean> datasBeans;
    private Context context;

    public HomeAdapter(ArrayList<Bean.DataBean.DatasBean> datasBeans, Context context) {
        this.datasBeans = datasBeans;
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
        Glide.with(context).load(datasBeans.get(position).getEnvelopePic()).into(holder0.img);
        holder0.desc.setText(datasBeans.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return datasBeans.size();
    }

    class ViewHolder0 extends ViewHolder {
        ImageView img;
        TextView desc;
        public ViewHolder0(@NonNull View itemView) {
            super(itemView);
        }
    }
}
