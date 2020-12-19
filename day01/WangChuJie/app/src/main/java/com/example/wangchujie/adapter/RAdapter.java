package com.example.wangchujie.adapter;

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
import com.example.wangchujie.R;
import com.example.wangchujie.bean.FindBean;

import java.util.ArrayList;

public class RAdapter extends RecyclerView.Adapter {
    private ArrayList<FindBean.DataBeanX.DataBean> dataBeans;
    private Context mContext;

    public RAdapter(ArrayList<FindBean.DataBeanX.DataBean> dataBeans, Context mContext) {
        this.dataBeans = dataBeans;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item2_layout, parent, false);
        return new ViewHolder3(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder3 holder3 = (ViewHolder3) holder;
        holder3.tv_title.setText(dataBeans.get(position).getTitle());
        holder3.tv_desc.setText(dataBeans.get(position).getIntro());
        Glide.with(mContext).load(dataBeans.get(position).getIcon()).into(holder3.iv_img);
        holder3.bt_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClick.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }


    public static
    class ViewHolder3 extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_img;
        public TextView tv_title;
        public TextView tv_desc;
        public Button bt_insert;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_desc = (TextView) rootView.findViewById(R.id.tv_desc);
            this.bt_insert = (Button) rootView.findViewById(R.id.bt_insert);
        }

    }

    public interface MyClick{
        void onItemClick(int position);
    }

    private MyClick myClick;

    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
    }
}
