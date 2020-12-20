package com.example.day05_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyRcy4Adapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Integer> list;

    public MyRcy4Adapter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rcy4_rcy, parent, false);
        return new ViewHolders(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolders viewHolders = (ViewHolders) holder;
        Glide.with(context).load(list.get(position)).into(viewHolders.iv_rcy4_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolders extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_rcy4_img;

        public ViewHolders(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_rcy4_img = (ImageView) rootView.findViewById(R.id.iv_rcy4_img);
        }

    }
}
