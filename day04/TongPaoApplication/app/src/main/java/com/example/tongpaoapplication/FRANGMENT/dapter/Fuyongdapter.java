package com.example.tongpaoapplication.FRANGMENT.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tongpaoapplication.R;
import com.example.tongpaoapplication.bean.Fenlei;

import java.util.List;

public class Fuyongdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Fenlei.DataBean.ListBean> list;


    public Fuyongdapter(Context context, List<Fenlei.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    public static final int TYPE_THREE = 0;
    public static final int TYPE_NOE = 1;
    public static final int TYPE_NULL = 2;

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getFilePathList().size() == 3) {
            return TYPE_THREE;
        } else if (list.get(position).getFilePathList().size() == 1) {
            return TYPE_NOE;
        } else {
            return TYPE_NULL;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_THREE) {
            View root = LayoutInflater.from(context).inflate(R.layout.fragment_type_three, parent, false);
            return new ThreeViewHolder(root);
        } else if (viewType == TYPE_NOE) {
            View root = LayoutInflater.from(context).inflate(R.layout.fragment_type_one, parent, false);
            return new OneViewHolder(root);
        } else {
            View root = LayoutInflater.from(context).inflate(R.layout.fragment_type_null, parent, false);
            return new NullViewHolder(root);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Fenlei.DataBean.ListBean listBean = list.get(position);
        List<Fenlei.DataBean.ListBean.FilePathListBean> filePathList = listBean.getFilePathList();

        switch (getItemViewType(position)){
            case TYPE_THREE:
                ThreeViewHolder threeViewHolder= (ThreeViewHolder) holder;
                threeViewHolder.tv_time.setText(listBean.getCreateTime());
                threeViewHolder.tv_title.setText(listBean.getTitle());
                Glide.with(context).load(filePathList.get(0).getFilePath()).into(threeViewHolder.img_pic_1);
                Glide.with(context).load(filePathList.get(1).getFilePath()).into(threeViewHolder.img_pic_2);
                Glide.with(context).load(filePathList.get(2).getFilePath()).into(threeViewHolder.img_pic_3);
                break;
            case TYPE_NOE:
                OneViewHolder oneViewHolder= (OneViewHolder) holder;
                oneViewHolder.tv_time.setText(listBean.getCreateTime());
                oneViewHolder.tv_title.setText(listBean.getTitle());
                Glide.with(context).load(filePathList.get(0).getFilePath()).into(oneViewHolder.img_pic);
                break;
            case TYPE_NULL:
                NullViewHolder nullViewHolder= (NullViewHolder) holder;
                nullViewHolder.tv_time.setText(listBean.getCreateTime());
                nullViewHolder.tv_title.setText(listBean.getTitle());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ThreeViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_title;
        public ImageView img_pic_1;
        public ImageView img_pic_2;
        public ImageView img_pic_3;
        public TextView tv_time;

        public ThreeViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.img_pic_1 = (ImageView) rootView.findViewById(R.id.img_pic_1);
            this.img_pic_2 = (ImageView) rootView.findViewById(R.id.img_pic_2);
            this.img_pic_3 = (ImageView) rootView.findViewById(R.id.img_pic_3);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
        }

    }

    public static
    class OneViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_title;
        public TextView tv_time;
        public ImageView img_pic;

        public OneViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
            this.img_pic = (ImageView) rootView.findViewById(R.id.img_pic);
        }

    }

    public static
    class NullViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_title;
        public TextView tv_time;

        public NullViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
        }

    }
}
