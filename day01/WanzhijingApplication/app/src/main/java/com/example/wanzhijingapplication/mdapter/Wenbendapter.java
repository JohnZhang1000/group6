package com.example.wanzhijingapplication.mdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.wanzhijingapplication.R;
import com.example.wanzhijingapplication.bean.WenBen;

import java.util.List;

public class Wenbendapter extends RecyclerView.Adapter {
    private Context context;
    private List<WenBen.DataBeanX.DataBean> list;

    public Wenbendapter(Context context, List<WenBen.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void item(List<WenBen.DataBeanX.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wenben, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder1.img);
        holder1.texts.setText(list.get(position).getFeeds_text());
        holder1.text22.setText(list.get(position).getAuthor().getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img;
        public TextView texts;
        public TextView text22;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.texts = (TextView) rootView.findViewById(R.id.texts);
            this.text22 = (TextView) rootView.findViewById(R.id.text22);
        }

    }
}
