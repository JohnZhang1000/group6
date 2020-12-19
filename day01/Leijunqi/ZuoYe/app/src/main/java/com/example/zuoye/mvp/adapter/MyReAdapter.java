package com.example.zuoye.mvp.adapter;

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
import com.example.zuoye.R;
import com.example.zuoye.mvp.model.bean.PictureBean;

import java.util.List;

public class MyReAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<PictureBean.DataBeanX.DataBean> list;

    public MyReAdapter(Context context, List<PictureBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_picture_rcy, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        PictureBean.DataBeanX.DataBean dataBean = list.get(position);
        viewHolder.tv_feeds_text.setText(dataBean.getFeeds_text());
        viewHolder.tv_name.setText(dataBean.getAuthor().getName());
        viewHolder.tv_title.setText(dataBean.getActivityText());
        Glide.with(context).load(dataBean.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.iv_tou);
        Glide.with(context).load(dataBean.getCover()).into(viewHolder.iv_cover);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_tou;
        public TextView tv_name;
        public TextView tv_title;
        public TextView tv_feeds_text;
        public ImageView iv_cover;
        public ImageView iv_cell_like;
        public ImageView iv_cell_diss;
        public ImageView iv_cell_comment;
        public ImageView iv_cell_share;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_tou = (ImageView) rootView.findViewById(R.id.iv_tou);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_feeds_text = (TextView) rootView.findViewById(R.id.tv_feeds_text);
            this.iv_cover = (ImageView) rootView.findViewById(R.id.iv_cover);
            this.iv_cell_like = (ImageView) rootView.findViewById(R.id.iv_cell_like);
            this.iv_cell_diss = (ImageView) rootView.findViewById(R.id.iv_cell_diss);
            this.iv_cell_comment = (ImageView) rootView.findViewById(R.id.iv_cell_comment);
            this.iv_cell_share = (ImageView) rootView.findViewById(R.id.iv_cell_share);
        }

    }
}
