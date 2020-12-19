package com.umeng.zhangwentao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.umeng.zhangwentao.R;
import com.umeng.zhangwentao.fragment.shafa.databean.ShaFaTuPianDataBean;

import java.util.ArrayList;

/**
 * 项目名:zhangwentao
 * 包名:com.umeng.zhangwentao.adapter
 * 创建者: 张文涛
 * 创建时间: 2020/12/17
 */
public class ImageRcyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ShaFaTuPianDataBean.DataBeanX.DataBean> list;

    public ImageRcyAdapter(Context context, ArrayList<ShaFaTuPianDataBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.imageview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShaFaTuPianDataBean.DataBeanX.DataBean bean = list.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(bean.getAuthor().getAvatar()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(viewHolder.iv_header);
        Glide.with(context).load(bean.getCover()).into(viewHolder.iv_tupian);
        Glide.with(context).load(bean.getAuthor().getAvatar()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(viewHolder.iv_xiaotu);
        viewHolder.tv_name.setText(bean.getAuthor().getName());
        viewHolder.tv_text.setText(bean.getFeeds_text());
        viewHolder.tv_xiaozi.setText(bean.getActivityText());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_header;
        public TextView tv_name;
        public TextView tv_text;
        public ImageView iv_tupian;
        public ImageView iv_xiaotu;
        public TextView tv_xiaozi;
        public ImageView iv_like;
        public TextView tv_like;
        public ImageView iv_dess;
        public TextView tv_diss;
        public ImageView iv_comm;
        public TextView tv_comm;
        public ImageView iv_shar;
        public TextView tv_shar;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_header = (ImageView) rootView.findViewById(R.id.iv_header);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
            this.iv_tupian = (ImageView) rootView.findViewById(R.id.iv_tupian);
            this.iv_xiaotu = (ImageView) rootView.findViewById(R.id.iv_xiaotu);
            this.tv_xiaozi = (TextView) rootView.findViewById(R.id.tv_xiaozi);
            this.iv_like = (ImageView) rootView.findViewById(R.id.iv_like);
            this.tv_like = (TextView) rootView.findViewById(R.id.tv_like);
            this.iv_dess = (ImageView) rootView.findViewById(R.id.iv_dess);
            this.tv_diss = (TextView) rootView.findViewById(R.id.tv_diss);
            this.iv_comm = (ImageView) rootView.findViewById(R.id.iv_comm);
            this.tv_comm = (TextView) rootView.findViewById(R.id.tv_comm);
            this.iv_shar = (ImageView) rootView.findViewById(R.id.iv_shar);
            this.tv_shar = (TextView) rootView.findViewById(R.id.tv_shar);
        }

    }
}
