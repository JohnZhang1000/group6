package com.example.day1228_homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day1228_homework.R;

import java.util.ArrayList;

public class GuoAdapter extends RecyclerView.Adapter {
    private Context context;

    private ArrayList<Integer> img2;
    private ArrayList<String> name;
    private ArrayList<String> pinyin;

    public GuoAdapter(Context context, ArrayList<Integer> img2, ArrayList<String> name, ArrayList<String> pinyin) {
        this.context = context;
        this.img2 = img2;
        this.name = name;
        this.pinyin = pinyin;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_guo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Integer integer = img2.get(position);
        String na = name.get(position);
        String pin = pinyin.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.img_guo.setImageResource(integer);
        holder1.tv_name.setText(na);
        holder1.tv_pinying.setText(pin);

    }

    @Override
    public int getItemCount() {
        return img2.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img_guo;
        public TextView tv_name;
        public TextView tv_pinying;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_guo = (ImageView) rootView.findViewById(R.id.img_guo);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_pinying = (TextView) rootView.findViewById(R.id.tv_pinying);
        }

    }
}
