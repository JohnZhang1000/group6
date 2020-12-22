package com.example.day07_01.mvp.adapter;

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
import com.example.day07_01.R;
import com.example.day07_01.mvp.model.bean.IevelBean;

import java.util.ArrayList;

public class MyRanAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<IevelBean.DataBean.ExpTopBean.ListBean> list;

    public MyRanAdapter(Context context, ArrayList<IevelBean.DataBean.ExpTopBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ran_rcy, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 viewHolder1= (ViewHolder1) holder;
        IevelBean.DataBean.ExpTopBean.ListBean listBean = list.get(position);
        viewHolder1.tv_jinyan.setText(listBean.getExpScore()+"經驗");
        viewHolder1.tv_name.setText(listBean.getNickName());
        viewHolder1.tv_not.setText(listBean.getNoNum()+"");
        viewHolder1.tv_time.setText(listBean.getProvince()+"  "+listBean.getCity());
        Glide.with(context).load(listBean.getHeadUrl()).apply(new RequestOptions().circleCrop()).into(viewHolder1.iv_tou);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_not;
        public ImageView iv_tou;
        public TextView tv_name;
        public TextView tv_time;
        public TextView tv_jinyan;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_not = (TextView) rootView.findViewById(R.id.tv_not);
            this.iv_tou = (ImageView) rootView.findViewById(R.id.iv_tou);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
            this.tv_jinyan = (TextView) rootView.findViewById(R.id.tv_jinyan);
        }

    }
}
