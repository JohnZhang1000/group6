package com.example.demo_zuoye3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demo_zuoye3.App;
import com.example.demo_zuoye3.R;
import com.example.demo_zuoye3.bean.Smart;
import com.example.demo_zuoye3.db.SmartDao;

import java.util.ArrayList;
import java.util.List;

public class DbAdapter extends RecyclerView.Adapter<DbAdapter.ViewHlder> {
    private Context context;
    private ArrayList<Smart> list;

    public DbAdapter(Context context, ArrayList<Smart> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_fond, parent, false);
        return new ViewHlder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHlder holder, final int position) {
        Glide.with(context).load(list.get(position).getImg()).into(holder.img);
        holder.tv_a.setText(list.get(position).getName());
        holder.tv_b.setText(list.get(position).getTitle());
        holder.btn_coll.setText("取消关注");
//        holder.btn_coll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                List<Smart> list = App.daoSession.getSmartDao().queryBuilder()
//                        .where(SmartDao.Properties.Mid.eq().build().list();
//                for (Smart s:list){
//                    App.daoSession.getSmartDao().delete(s);
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHlder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView tv_a;
        public TextView tv_b;
        public Button btn_coll;

        public ViewHlder(@NonNull View itemView) {
            super(itemView);
            this.img = (ImageView) itemView.findViewById(R.id.img);
            this.tv_a = (TextView) itemView.findViewById(R.id.tv_a);
            this.tv_b = (TextView) itemView.findViewById(R.id.tv_b);
            this.btn_coll=(Button) itemView.findViewById(R.id.btn_coll);
        }
    }


}
