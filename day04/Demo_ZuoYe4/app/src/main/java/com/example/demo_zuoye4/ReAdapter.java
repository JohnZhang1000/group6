package com.example.demo_zuoye4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demo_zuoye4.bean.HotBean;
import com.example.demo_zuoye4.bean.TabBean;

import java.util.ArrayList;

public class ReAdapter extends RecyclerView.Adapter {
    public Context context;
    public ArrayList<HotBean.DataBean> hotlist;
    public ArrayList<TabBean.DataBean> tablist;
    private HotAdapter hotAdapter;

    public ReAdapter(Context context, ArrayList<HotBean.DataBean> hotlist, ArrayList<TabBean.DataBean> tablist) {
        this.context = context;
        this.hotlist = hotlist;
        this.tablist = tablist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_first, parent, false);
            return new FirstViewHolder(inflate);
        }
//        if (viewType == 1) {
//            View inflate = LayoutInflater.from(context).inflate(R.layout.item_re, parent, false);
//            return new HotViewHolder(inflate);
//        }
        if(viewType==1){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_two, parent, false);
           return new TwoViewHolder(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            FirstViewHolder holder1 = (FirstViewHolder) holder;
        }
//        if (itemViewType == 1) {
//            TwoViewHolder holder1 = (TwoViewHolder) holder;
//            LinearLayoutManager manager = new LinearLayoutManager(context);
//            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
//            holder1.re.setLayoutManager(manager);
//            hotAdapter = new HotAdapter(context,hotlist);
//            holder1.re.setAdapter(hotAdapter);
//        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        if (position == 1) {
            return 1;
        }
        return 2;
    }

    private class FirstViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_a;
        public LinearLayout l1;
        public ImageView iv_b;
        public LinearLayout l2;
        public ImageView iv_c;
        public LinearLayout l3;
        public FirstViewHolder(View inflate) {
            super(inflate);
            this.iv_a = (ImageView) inflate.findViewById(R.id.iv_a);
            this.l1 = (LinearLayout) inflate.findViewById(R.id.l1);
            this.iv_b = (ImageView) inflate.findViewById(R.id.iv_b);
            this.l2 = (LinearLayout) inflate.findViewById(R.id.l2);
            this.iv_c = (ImageView) inflate.findViewById(R.id.iv_c);
            this.l3 = (LinearLayout) inflate.findViewById(R.id.l3);
        }
    }


    private class TwoViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView re;

        public TwoViewHolder(View inflate) {
            super(inflate);
            re = inflate.findViewById(R.id.re);

        }
    }

    private class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder> {
       private Context context;
       private ArrayList<HotBean.DataBean> list;

        public HotAdapter(Context context, ArrayList<HotBean.DataBean> list) {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_re, parent, false);
            return new ViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          Glide.with(context).load(list.get(position).getCover()).into(holder.iv_a);
          holder.tv_a.setText(list.get(position).getTitle());
        }

        @Override
        public int getItemCount() {
            return hotlist.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView iv_a;
            public TextView tv_a;
            public TextView tv_b;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                this.iv_a = (ImageView) itemView.findViewById(R.id.iv_a);
                this.tv_a = (TextView) itemView.findViewById(R.id.tv_a);
                this.tv_b = (TextView) itemView.findViewById(R.id.tv_b);
            }
        }
    }
}
