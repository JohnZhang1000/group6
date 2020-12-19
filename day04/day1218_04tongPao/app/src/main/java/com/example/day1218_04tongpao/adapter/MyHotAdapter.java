package com.example.day1218_04tongpao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day1218_04tongpao.R;
import com.example.day1218_04tongpao.bean.HotBean;

import java.util.ArrayList;

public class MyHotAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HotBean.DataBean.ListBean> list;
    private ArrayList<String> img;

    public MyHotAdapter(Context context, ArrayList<HotBean.DataBean.ListBean> list, ArrayList<String> img) {
        this.context = context;
        this.list = list;
        this.img = img;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_list_hot, null);
            return new ViewHolder(view);
        } else {
            View view2 = LayoutInflater.from(context).inflate(R.layout.layout_list_hot2, null);
            return new ViewHolder2(view2);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position % 2 == 0) {
            ViewHolder holder1 = (ViewHolder) holder;
            HotBean.DataBean.ListBean listBean = list.get(position);
           // String s = img.get(position);

            holder1.tv_title_hot.setText(listBean.getTitle());
            holder1.tv_time_hot.setText(listBean.getCreateTime());

//            Glide.with(context).load(s).into(holder1.iv_pic_1);
//            Glide.with(context).load(s).into(holder1.iv_pic_2);
//            Glide.with(context).load(s).into(holder1.iv_pic_3);

        } else {
            ViewHolder2 holder2 = (ViewHolder2) holder;
            HotBean.DataBean.ListBean listBean2 = list.get(position);
            //String s2= img.get(position);
            holder2.tv_question.setText(listBean2.getTitle());
            holder2.tv_time_ques.setText(listBean2.getCreateTime());
          //  Glide.with(context).load(s2).into(holder2.iv_pic_hot);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_title_hot;
        public ImageView iv_pic_1;
        public ImageView iv_pic_2;
        public ImageView iv_pic_3;
        public TextView tv_time_hot;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_title_hot = (TextView) rootView.findViewById(R.id.tv_title_hot);
            this.iv_pic_1 = (ImageView) rootView.findViewById(R.id.iv_pic_1);
            this.iv_pic_2 = (ImageView) rootView.findViewById(R.id.iv_pic_2);
            this.iv_pic_3 = (ImageView) rootView.findViewById(R.id.iv_pic_3);
            this.tv_time_hot = (TextView) rootView.findViewById(R.id.tv_time_hot);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_question;
        public TextView tv_time_ques;
        public ImageView iv_pic_hot;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_question = (TextView) rootView.findViewById(R.id.tv_question);
            this.tv_time_ques = (TextView) rootView.findViewById(R.id.tv_time_ques);
            this.iv_pic_hot = (ImageView) rootView.findViewById(R.id.iv_pic_hot);
        }

    }
}
