package com.example.leijunqi.mvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leijunqi.R;
import com.example.leijunqi.mvp.model.bean.HotBean;
import com.example.leijunqi.mvp.view.activity.RankingActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MyRcAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HotBean.DataBean> list;
    private Boolean pan=true;

    public MyRcAdapter(Context context, ArrayList<HotBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(context).inflate(R.layout.item_thesofa_rcy, parent, false);
                return new ViewHolder0(view);
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.item_thesofa_rc, parent, false);
                return new ViewHolder1(view1);
            case 2:
                return null;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            ViewHolder0 viewHolder0 = (ViewHolder0) holder;
            if (pan){
                viewHolder0.thesofa_tl.addTab(viewHolder0.thesofa_tl.newTab());
                viewHolder0.thesofa_tl.addTab(viewHolder0.thesofa_tl.newTab());
                viewHolder0.thesofa_tl.addTab(viewHolder0.thesofa_tl.newTab());
                pan=false;
            }
            viewHolder0.thesofa_tl.getTabAt(0).setText("袍子").setIcon(R.drawable.a);
            viewHolder0.thesofa_tl.getTabAt(1).setText("社团").setIcon(R.drawable.a);
            viewHolder0.thesofa_tl.getTabAt(2).setText("排行榜").setIcon(R.drawable.a);

            viewHolder0.thesofa_tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    switch (tab.getPosition()) {
                        case 0:
                            Toast.makeText(context, "袍子", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Toast.makeText(context, "社团", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            Intent intent = new Intent(context, RankingActivity.class);
                            context.startActivity(intent);
                            break;

                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        } else if(position==1) {
            ViewHolder1 viewHolder1= (ViewHolder1) holder;
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            viewHolder1.thesofa_rc_rv.setLayoutManager(manager);
            MyReAdapter myReAdapter = new MyReAdapter(context, list);
            viewHolder1.thesofa_rc_rv.setAdapter(myReAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public static
    class ViewHolder0 extends RecyclerView.ViewHolder {
        public View rootView;
        public TabLayout thesofa_tl;

        public ViewHolder0(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.thesofa_tl = (TabLayout) rootView.findViewById(R.id.thesofa_tl);
        }

    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_genduo;
        public RecyclerView thesofa_rc_rv;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_genduo = (TextView) rootView.findViewById(R.id.tv_genduo);
            this.thesofa_rc_rv = (RecyclerView) rootView.findViewById(R.id.thesofa_rc_rv);
        }

    }
}
