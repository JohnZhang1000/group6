package com.example.day1228_homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day1228_homework.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MyRcyHomeAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Integer> list;
    private LinearLayoutManager linearLayoutManager;
    private ViewHolder holder1;

    public MyRcyHomeAdapter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else if (position == 3) {
            return 3;
        } else if (position == 4) {
            return 4;
        } else if (position == 5) {
            return 5;
        } else if (position == 6) {
            return 6;
        }
        return 7;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view0 = LayoutInflater.from(context).inflate(R.layout.layout_banner, parent, false);
            return new ViewHolder(view0);
        } else if (viewType == 1) {
            View view2 = LayoutInflater.from(context).inflate(R.layout.layout_2out, parent, false);
            return new ViewHolder(view2);
        } else if (viewType == 2) {
            View view3 = LayoutInflater.from(context).inflate(R.layout.layout_3sea, parent, false);
            return new ViewHolder(view3);
        } else if (viewType == 3) {
            View view4 = LayoutInflater.from(context).inflate(R.layout.lauyout_4guo, parent, false);
            return new ViewHolder(view4);
        } else if (viewType == 4) {
            View view5 = LayoutInflater.from(context).inflate(R.layout.layout_5mei, parent, false);
            return new ViewHolder(view5);
        } else if (viewType == 5) {
            View view6 = LayoutInflater.from(context).inflate(R.layout.layout_6town, parent, false);
            return new ViewHolder(view6);
        } else if (viewType == 6) {
            return null;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            Integer integer = list.get(position);
            ViewHolder holder1 = (ViewHolder) holder;
            holder1.item_banner.setImages(list)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(context).load(path).into(imageView);
                        }
                    }).start();


        } else if (position == 1) {


        } else if (position == 2) {
            holder1 = (ViewHolder) holder;
            linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            holder1.rcy_sea.setLayoutManager(linearLayoutManager);
            ArrayList<Integer> img = new ArrayList<>();
            img.add(R.drawable.a4);
            img.add(R.drawable.a5);
            SeaAdapter seaAdapter = new SeaAdapter(context, img);
            holder1.rcy_sea.setAdapter(seaAdapter);

        } else if (position == 3) {
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            holder1.rcy_guo.setLayoutManager(linearLayoutManager);
            ArrayList<Integer> img2 = new ArrayList<>();
            img2.add(R.drawable.a7);
            img2.add(R.drawable.a8);
            img2.add(R.drawable.a9);
            ArrayList<String> name = new ArrayList<>();
            name.add("大理");
            name.add("成都");
            name.add("杭州");
            ArrayList<String> pinyin = new ArrayList<>();
            pinyin.add("DALI");
            pinyin.add("CHENGDU");
            pinyin.add("HANGZHOU");
            GuoAdapter guoAdapter = new GuoAdapter(context, img2,name,pinyin);
            holder1.rcy_guo.setAdapter(guoAdapter);


        } else if (position == 4) {

        } else if (position == 5) {

        } else if (position == 6) {

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner item_banner;
        public RecyclerView rcy_sea;
        public RecyclerView rcy_guo;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.item_banner = (Banner) rootView.findViewById(R.id.item_banner);
            this.rcy_sea = (RecyclerView) rootView.findViewById(R.id.rcy_sea);
            this.rcy_guo = (RecyclerView) rootView.findViewById(R.id.rcy_guo);

        }

    }
}
