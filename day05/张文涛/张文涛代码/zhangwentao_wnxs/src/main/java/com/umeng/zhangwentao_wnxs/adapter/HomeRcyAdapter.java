package com.umeng.zhangwentao_wnxs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.umeng.zhangwentao_wnxs.R;

import java.util.ArrayList;

/**
 * 项目名:zhangwentao_tongpao
 * 包名:com.umeng.zhangwentao_wnxs.adapter
 * 创建者: 张文涛
 * 创建时间: 2020/12/19
 */
public class HomeRcyAdapter extends RecyclerView.Adapter {
    private Context context;
    ArrayList<Object> list;

    public HomeRcyAdapter(Context context, ArrayList<Object> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.home_1, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(R.mipmap.ic_launcher).apply(new RequestOptions().circleCrop()).into(viewHolder.iv_hader1);
        Glide.with(context).load(R.mipmap.ic_launcher).apply(new RequestOptions().circleCrop()).into(viewHolder.iv_hader2);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public CardView car;
        public ImageView iv_tuijian;
        public ImageView iv_feihua;
        public ImageView iv_shequn;
        public ImageView iv_paihang;
        public ImageView iv_vip;
        public LinearLayout ll_top;
        public LinearLayout ll_text;
        public TextView tv_time;
        public RelativeLayout rl_top;
        public ImageView iv_hader1;
        public ImageView iv_hader2;
        public ImageView yinghua1;
        public ImageView yinghua2;
        public Button bt_yuyue;
        public RelativeLayout rl_2;
        public Button bt2;
        public Button bt1;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.car = (CardView) rootView.findViewById(R.id.car);
            this.iv_tuijian = (ImageView) rootView.findViewById(R.id.iv_tuijian);
            this.iv_feihua = (ImageView) rootView.findViewById(R.id.iv_feihua);
            this.iv_shequn = (ImageView) rootView.findViewById(R.id.iv_shequn);
            this.iv_paihang = (ImageView) rootView.findViewById(R.id.iv_paihang);
            this.iv_vip = (ImageView) rootView.findViewById(R.id.iv_vip);
            this.ll_top = (LinearLayout) rootView.findViewById(R.id.ll_top);
            this.ll_text = (LinearLayout) rootView.findViewById(R.id.ll_text);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
            this.rl_top = (RelativeLayout) rootView.findViewById(R.id.rl_top);
            this.iv_hader1 = (ImageView) rootView.findViewById(R.id.iv_hader1);
            this.iv_hader2 = (ImageView) rootView.findViewById(R.id.iv_hader2);
            this.yinghua1 = (ImageView) rootView.findViewById(R.id.yinghua1);
            this.yinghua2 = (ImageView) rootView.findViewById(R.id.yinghua2);
            this.bt_yuyue = (Button) rootView.findViewById(R.id.bt_yuyue);
            this.rl_2 = (RelativeLayout) rootView.findViewById(R.id.rl_2);
            this.bt2 = (Button) rootView.findViewById(R.id.bt2);
            this.bt1 = (Button) rootView.findViewById(R.id.bt1);
        }

    }
//dddddd
}
