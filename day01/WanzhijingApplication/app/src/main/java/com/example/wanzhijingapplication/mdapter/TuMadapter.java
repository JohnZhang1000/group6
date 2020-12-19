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
import com.example.wanzhijingapplication.bean.Tu;

import java.util.List;

public class TuMadapter extends RecyclerView.Adapter {
    private Context context;
    private List<Tu.DataBeanX.DataBean> list;

    public TuMadapter(Context context, List<Tu.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void item(List<Tu.DataBeanX.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tupian, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder1.img);
        holder1.text.setText(list.get(position).getAuthor().getName());
        holder1.text1.setText(list.get(position).getFeeds_text());
        Glide.with(context).load(list.get(position).getCover()).into(holder1.imgs);
        holder1.text2.setText(list.get(position).getActivityText());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img;
        public TextView text;
        public TextView text1;
        public ImageView imgs;
        public TextView text2;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.text = (TextView) rootView.findViewById(R.id.text);
            this.text1 = (TextView) rootView.findViewById(R.id.text1);
            this.imgs = (ImageView) rootView.findViewById(R.id.imgs);
            this.text2 = (TextView) rootView.findViewById(R.id.text2);
        }

    }
}
