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
import com.bumptech.glide.request.RequestOptions;
import com.umeng.zhangwentao.R;
import com.umeng.zhangwentao.fragment.shafa.databean.ShaFaTextDataBean;

import java.util.ArrayList;

/**
 * 项目名:zhangwentao
 * 包名:com.umeng.zhangwentao.adapter
 * 创建者: 张文涛
 * 创建时间: 2020/12/17
 */
public class TextRcyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ShaFaTextDataBean.DataBeanX.DataBean> list;

    public TextRcyAdapter(Context context, ArrayList<ShaFaTextDataBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHold(LayoutInflater.from(context).inflate(R.layout.text_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShaFaTextDataBean.DataBeanX.DataBean dataBean = list.get(position);
        ViewHold viewHolder = (ViewHold) holder;
        Glide.with(context).load(dataBean.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.iv_text);
        viewHolder.tv_text.setText(dataBean.getAuthor().getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHold extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_text;
        public TextView tv_text;
        public ImageView iv1;
        public TextView tv1;
        public ImageView iv2;
        public TextView tv2;
        public ImageView iv3;
        public TextView tv4;
        public ImageView iv5;
        public TextView tv5;

        public ViewHold(@NonNull View itemView) {
            super(itemView);
            this.rootView = itemView;
            this.iv_text = (ImageView) rootView.findViewById(R.id.iv_text);
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
            this.iv1 = (ImageView) rootView.findViewById(R.id.iv1);
            this.tv1 = (TextView) rootView.findViewById(R.id.tv1);
            this.iv2 = (ImageView) rootView.findViewById(R.id.iv2);
            this.tv2 = (TextView) rootView.findViewById(R.id.tv2);
            this.iv3 = (ImageView) rootView.findViewById(R.id.iv3);
            this.tv4 = (TextView) rootView.findViewById(R.id.tv4);
            this.iv5 = (ImageView) rootView.findViewById(R.id.iv5);
            this.tv5 = (TextView) rootView.findViewById(R.id.tv5);
        }
    }
//dddddd
}
