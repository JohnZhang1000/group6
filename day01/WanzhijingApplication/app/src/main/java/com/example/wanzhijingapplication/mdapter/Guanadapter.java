package com.example.wanzhijingapplication.mdapter;

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
import com.example.wanzhijingapplication.R;
import com.example.wanzhijingapplication.bean.WodeBean;

import java.util.List;

public class Guanadapter extends RecyclerView.Adapter {
    private Context context;
    private List<WodeBean.DataBeanX.DataBean> list;

    public Guanadapter(Context context, List<WodeBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void item(List<WodeBean.DataBeanX.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.guanzhu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getActivityIcon()).into(holder1.img);
        holder1.text.setText(list.get(position).getTitle());
        holder1.text1.setText(list.get(position).getIntro());
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ioncick!=null){
                    ioncick.ioncick(position);
                }
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
        public ImageView img;
        public TextView text;
        public TextView text1;
        public Button button;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.text = (TextView) rootView.findViewById(R.id.text);
            this.text1 = (TextView) rootView.findViewById(R.id.text1);
            this.button = (Button) rootView.findViewById(R.id.button);
        }

    }
   public   interface Ioncick{
        void ioncick(int pos);
    }
    Ioncick ioncick;

    public void setIoncick(Ioncick ioncick) {
        this.ioncick = ioncick;
    }
}
