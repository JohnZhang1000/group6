package com.example.demo_zuoye3.adapter;

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
import com.example.demo_zuoye3.App;
import com.example.demo_zuoye3.R;
import com.example.demo_zuoye3.bean.FindBean;
import com.example.demo_zuoye3.bean.Smart;

import java.util.ArrayList;

public class FindAdapter extends RecyclerView.Adapter<FindAdapter.ViewHolder> {
    private Context context;
    private ArrayList<FindBean.DataBeanX.DataBean> list;

    public FindAdapter(Context context, ArrayList<FindBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_fond, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.tv_a.setText(list.get(position).getTitle());
        holder.tv_b.setText(list.get(position).getIntro());
        Glide.with(context).load(list.get(position).getIcon()).into(holder.img);
        holder.btn_coll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.btn_coll.setText("已关注");
                Smart smart = new Smart();
                smart.setImg(list.get(position).getIcon());
                smart.setName(list.get(position).getTitle());
                smart.setTitle(list.get(position).getIntro());
                App.daoSession.getSmartDao().insert(smart);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView tv_a;
        public TextView tv_b;
        public Button btn_coll;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.img = (ImageView) itemView.findViewById(R.id.img);
            this.tv_a = (TextView) itemView.findViewById(R.id.tv_a);
            this.tv_b = (TextView) itemView.findViewById(R.id.tv_b);
            this.btn_coll=(Button) itemView.findViewById(R.id.btn_coll);
        }
    }

}
