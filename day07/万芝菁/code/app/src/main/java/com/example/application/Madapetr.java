package com.example.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class Madapetr extends RecyclerView.Adapter {
    private Context context;
    private List<Baner.DataBean> bens;
    private List<LIstBean.TrailersBean> list;

    public Madapetr(Context context, List<Baner.DataBean> bens, List<LIstBean.TrailersBean> list) {
        this.context = context;
        this.bens = bens;
        this.list = list;
    }

    public void item(List<LIstBean.TrailersBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    private static final int TY = 0;
    private static final int TY1 = 1;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TY;
        } else {
            return TY1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TY) {
            View view = LayoutInflater.from(context).inflate(R.layout.baner, parent, false);
            return new ViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.list, parent, false);
            return new TEXTViewHolder(view);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==TY){
           ViewHolder holder1= (ViewHolder) holder;
           holder1.baner.setImages(bens).setImageLoader(new ImageLoader() {
               @Override
               public void displayImage(Context context, Object path, ImageView imageView) {
                   Baner.DataBean paths= (Baner.DataBean) path;
                   Glide.with(context).load(paths.getUrl()).into(imageView);
               }
           }).start();
        }else {
            TEXTViewHolder holder1= (TEXTViewHolder) holder;
            holder1.text.setText(list.get(position).getMovieName());
            Glide.with(context).load(list.get(position).getCoverImg()).into(holder1.img);
        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }



    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner baner;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.baner = (Banner) rootView.findViewById(R.id.baner);
        }

    }
    public static
    class TEXTViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img;
        public TextView text;

        public TEXTViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.text = (TextView) rootView.findViewById(R.id.text);
        }

    }
}
