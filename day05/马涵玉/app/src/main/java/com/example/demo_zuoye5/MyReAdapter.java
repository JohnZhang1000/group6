package com.example.demo_zuoye5;

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

public class MyReAdapter extends RecyclerView.Adapter<MyReAdapter.ViewhOlder> {
    private Context context;
    private ArrayList<Integer> list;
    private ArrayList<String> strings;

    public MyReAdapter(Context context, ArrayList<Integer> list, ArrayList<String> strings) {
        this.context = context;
        this.list = list;
        this.strings = strings;
    }

    @NonNull
    @Override
    public ViewhOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_a, parent, false);
        return new ViewhOlder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewhOlder holder, int position) {
        Glide.with(context).load(list.get(position)).into(holder.iv_a);
        holder.tv_b.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewhOlder extends RecyclerView.ViewHolder {
        public ImageView iv_a;
        public TextView tv_b;

        public ViewhOlder(@NonNull View itemView) {
            super(itemView);
            this.iv_a = (ImageView) itemView.findViewById(R.id.iv_a);
            this.tv_b = (TextView) itemView.findViewById(R.id.tv_b);
        }
    }

}
