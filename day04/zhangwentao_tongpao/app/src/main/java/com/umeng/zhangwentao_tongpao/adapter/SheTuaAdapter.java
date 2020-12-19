package com.umeng.zhangwentao_tongpao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.umeng.zhangwentao_tongpao.R;
import com.umeng.zhangwentao_tongpao.databean.FaXianSheTuanDataBean;

import java.util.ArrayList;

/**
 * 项目名:zhangwentao_tongpao
 * 包名:com.umeng.zhangwentao_tongpao.adapter
 * 创建者: 张文涛
 * 创建时间: 2020/12/18
 */
public class SheTuaAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<FaXianSheTuanDataBean.StatusBean>list;

    public SheTuaAdapter(Context context, ArrayList<FaXianSheTuanDataBean.StatusBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater.from(context).inflate(R.layout.shetuan,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
