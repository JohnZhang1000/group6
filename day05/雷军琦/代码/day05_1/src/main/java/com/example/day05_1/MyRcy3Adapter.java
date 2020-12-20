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

public class MyRcy3Adapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<PorjectsBean> list;

    public MyRcy3Adapter(Context context, ArrayList<PorjectsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_rcy3_rcy, parent, false);
            return new ViewHolderw(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderw viewHolderw= (ViewHolderw) holder;
        viewHolderw.tv_rcy3_name.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getImgtou()).into(viewHolderw.iv_rcy3_tou);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolderw extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_rcy3_tou;
        public TextView tv_rcy3_name;

        public ViewHolderw(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_rcy3_tou = (ImageView) rootView.findViewById(R.id.iv_rcy3_tou);
            this.tv_rcy3_name = (TextView) rootView.findViewById(R.id.tv_rcy3_name);
        }

    }
}
