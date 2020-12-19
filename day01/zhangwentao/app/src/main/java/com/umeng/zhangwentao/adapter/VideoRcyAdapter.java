package com.umeng.zhangwentao.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.umeng.zhangwentao.R;
import com.umeng.zhangwentao.fragment.shafa.databean.ShaFaVideoDataBean;

import java.util.ArrayList;

/**
 * 项目名:zhangwentao
 * 包名:com.umeng.zhangwentao.adapter
 * 创建者: 张文涛
 * 创建时间: 2020/12/17
 */
public class VideoRcyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ShaFaVideoDataBean.DataBeanX.DataBean> list;

    public VideoRcyAdapter(Context context, ArrayList<ShaFaVideoDataBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.video_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShaFaVideoDataBean.DataBeanX.DataBean dataBean = list.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(dataBean.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.video_heder);
        viewHolder.video_name.setText(dataBean.getAuthor().getName());
        viewHolder.video_video.setVideoURI(Uri.parse(dataBean.getUrl()));
        viewHolder.video_video.start();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView video_heder;
        public TextView video_name;
        public TextView video_text;
        public VideoView video_video;
        public ImageView iv_like1;
        public ImageView iv_dess;
        public ImageView iv_comm;
        public ImageView iv_shar1;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.video_heder = (ImageView) rootView.findViewById(R.id.video_heder);
            this.video_name = (TextView) rootView.findViewById(R.id.video_name);
            this.video_text = (TextView) rootView.findViewById(R.id.video_text);
            this.video_video = (VideoView) rootView.findViewById(R.id.video_video);
            this.iv_like1 = (ImageView) rootView.findViewById(R.id.iv_like1);
            this.iv_dess = (ImageView) rootView.findViewById(R.id.iv_dess);
            this.iv_comm = (ImageView) rootView.findViewById(R.id.iv_comm);
            this.iv_shar1 = (ImageView) rootView.findViewById(R.id.iv_shar1);
        }

    }
//dddddd
}
