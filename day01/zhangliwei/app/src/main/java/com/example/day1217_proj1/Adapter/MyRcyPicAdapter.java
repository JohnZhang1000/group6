package com.example.day1217_proj1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day1217_proj1.R;
import com.example.day1217_proj1.bean.PicBean;

import java.util.ArrayList;

public class MyRcyPicAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<PicBean.DataBeanX.DataBean> list;

    public MyRcyPicAdapter(Context context, ArrayList<PicBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_list, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PicBean.DataBeanX.DataBean dataBean = list.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.tv_shuoshuo.setText(dataBean.getFeeds_text());
        Glide.with(context).load(dataBean.getCover()).into(holder1.iv_pic);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_shuoshuo;
        public ImageView iv_pic;
        public Button bnt_zan;
        public Button bnt_cai;
        public Button bnt_ping;
        public Button bnt_share;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_shuoshuo = (TextView) rootView.findViewById(R.id.tv_shuoshuo);
            this.iv_pic = (ImageView) rootView.findViewById(R.id.iv_pic);
            this.bnt_zan = (Button) rootView.findViewById(R.id.bnt_zan);
            this.bnt_cai = (Button) rootView.findViewById(R.id.bnt_cai);
            this.bnt_ping = (Button) rootView.findViewById(R.id.bnt_ping);
            this.bnt_share = (Button) rootView.findViewById(R.id.bnt_share);
        }

    }
}
