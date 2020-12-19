package com.example.tongpaoapplication.FRANGMENT.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tongpaoapplication.R;
import com.example.tongpaoapplication.bean.Remenbean;

import java.util.List;

public class Madapter extends RecyclerView.Adapter {
    private Context context;
    private List<Remenbean.DataBean> list;

    public Madapter(Context context, List<Remenbean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void item(List<Remenbean.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.remen, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getCover()).into(holder1.img);
        holder1.text1.setText(list.get(position).getTitle());
        holder1.text2.setText(list.get(position).getLocation());
        holder1.text3.setText(list.get(position).getStartTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img;
        public TextView text1;
        public TextView text2;
        public TextView text3;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.text1 = (TextView) rootView.findViewById(R.id.text1);
            this.text2 = (TextView) rootView.findViewById(R.id.text2);
            this.text3 = (TextView) rootView.findViewById(R.id.text3);
        }

    }
}
