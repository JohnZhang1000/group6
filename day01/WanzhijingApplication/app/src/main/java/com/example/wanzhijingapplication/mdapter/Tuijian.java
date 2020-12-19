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
import com.example.wanzhijingapplication.SqBean;

import java.util.List;

public class Tuijian extends RecyclerView.Adapter {
    private Context context;
    private List<SqBean> list;

    public Tuijian(Context context, List<SqBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tuijian, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        holder1.text.setText(list.get(position).getText());
        Glide.with(context).load(list.get(position).getUrl()).into(holder1.img);

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
        public Button button;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.text = (TextView) rootView.findViewById(R.id.text);
            this.button = (Button) rootView.findViewById(R.id.button);
        }

    }
}

