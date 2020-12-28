package com.example.day1228_homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day1228_homework.R;

import java.util.ArrayList;

public class SeaAdapter extends RecyclerView.Adapter {
    private Context context;

    private ArrayList<Integer> img;

    public SeaAdapter(Context context, ArrayList<Integer> img) {
        this.context = context;
        this.img = img;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sea, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Integer integer = img.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.img_sea.setImageResource(integer);


    }

    @Override
    public int getItemCount() {
        return img.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img_sea;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_sea = (ImageView) rootView.findViewById(R.id.img_sea);
        }

    }
}
