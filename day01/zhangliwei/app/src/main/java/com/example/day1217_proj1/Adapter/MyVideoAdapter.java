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
import com.example.day1217_proj1.bean.VideoBean;

import java.util.ArrayList;

import cn.jzvd.JzvdStd;

public class MyVideoAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<VideoBean.DataBeanX.DataBean> list;

    public MyVideoAdapter(Context context, ArrayList<VideoBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_list_vedio, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VideoBean.DataBeanX.DataBean dataBean = list.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.tv_shuoshuo.setText(dataBean.getFeeds_text() + "");
        holder1.jz.setUp(dataBean.getUrl(),"视频播放");
        Glide.with(context).load(dataBean.getCover()).into(holder1.iv_cover);

        holder1.rootView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder1.jz.startVideo();
                    }
                });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_shuoshuo;
        public ImageView iv_cover;
        public JzvdStd jz;
        public Button bnt_zan;
        public Button bnt_cai;
        public Button bnt_ping;
        public Button bnt_share;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_shuoshuo = (TextView) rootView.findViewById(R.id.tv_shuoshuo);
            this.iv_cover = (ImageView) rootView.findViewById(R.id.iv_cover);
            this.jz = (JzvdStd) rootView.findViewById(R.id.jz);
            this.bnt_zan = (Button) rootView.findViewById(R.id.bnt_zan);
            this.bnt_cai = (Button) rootView.findViewById(R.id.bnt_cai);
            this.bnt_ping = (Button) rootView.findViewById(R.id.bnt_ping);
            this.bnt_share = (Button) rootView.findViewById(R.id.bnt_share);
        }

    }
}
