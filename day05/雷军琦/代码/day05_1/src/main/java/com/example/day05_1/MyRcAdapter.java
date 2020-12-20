package com.example.day05_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MyRcAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<PorjectsBean> list3;
    private ArrayList<Integer> list4;
    private ArrayList<Integer> list5;
    private ArrayList<Integer> list6;

    public MyRcAdapter(Context context, ArrayList<PorjectsBean> list3, ArrayList<Integer> list4, ArrayList<Integer> list5, ArrayList<Integer> list6) {
        this.context = context;
        this.list3 = list3;
        this.list4 = list4;
        this.list5 = list5;
        this.list6 = list6;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View view0 = LayoutInflater.from(context).inflate(R.layout.item_list_rcy0, parent, false);
                return new ViewHolder0(view0);
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.item_list_rcy1, parent, false);
                return new ViewHolder1(view1);
            case 2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.item_list_rcy2, parent, false);
                return new ViewHolder2(view2);
            case 3:
                View view3 = LayoutInflater.from(context).inflate(R.layout.item_list_rcy3, parent, false);
                return new ViewHolder3(view3);
            case 4:
                View view4 = LayoutInflater.from(context).inflate(R.layout.item_list_rcy4, parent, false);
                return new ViewHolder4(view4);
            case 5:
                View view5 = LayoutInflater.from(context).inflate(R.layout.item_list_rcy5, parent, false);
                return new ViewHolder5(view5);
            case 6:
                View view6 = LayoutInflater.from(context).inflate(R.layout.item_list_rcy6, parent, false);
                return new ViewHolder6(view6);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            ViewHolder0 viewHolder0 = (ViewHolder0) holder;
            Glide.with(context).load(R.drawable.rrr).apply(new RequestOptions().bitmapTransform(new RoundedCorners(25))).into(viewHolder0.iv_img);
        } else if (position == 1) {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
        } else if (position == 2) {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            Glide.with(context).load(R.drawable.yuan).apply(new RequestOptions().circleCrop()).into(viewHolder2.iv_yuan_a);
            Glide.with(context).load(R.drawable.yuan).apply(new RequestOptions().circleCrop()).into(viewHolder2.yuan_b);
            Glide.with(context).load(R.drawable.icc).apply(new RequestOptions().bitmapTransform(new RoundedCorners(25))).into(viewHolder2.iv_img);
        } else if (position == 3) {
            ViewHolder3 viewHolder3 = (ViewHolder3) holder;
            viewHolder3.rv_rcy3.setLayoutManager(new GridLayoutManager(context, 5));
            MyRcy3Adapter myReAdapter = new MyRcy3Adapter(context, list3);
            viewHolder3.rv_rcy3.setAdapter(myReAdapter);
        } else if (position == 4) {
            ViewHolder4 viewHolder4 = (ViewHolder4) holder;
            viewHolder4.rv_rcy4.setLayoutManager(new LinearLayoutManager(context));
            MyRcy4Adapter myRcyAdapter = new MyRcy4Adapter(context, list4);
            viewHolder4.rv_rcy4.setAdapter(myRcyAdapter);
        } else if (position == 5) {
            ViewHolder5 viewHolder5 = (ViewHolder5) holder;
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            viewHolder5.rv_rcy5.setLayoutManager(manager);
            MyRcy5Adapter myRcy5Adapter = new MyRcy5Adapter(context, list5);
            viewHolder5.rv_rcy5.setAdapter(myRcy5Adapter);
        }else if (position==6){
            ViewHolder6 viewHolder= (ViewHolder6) holder;
            viewHolder.rv_rcy6.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            MyRcy6Adapter myRcy6Adapter = new MyRcy6Adapter(context, list6);
            viewHolder.rv_rcy6.setAdapter(myRcy6Adapter);
        }
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public static
    class ViewHolder0 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_img;

        public ViewHolder0(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
        }

    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public TabItem ti_item1;
        public TabItem ti_item2;
        public TabItem ti_item3;
        public TabItem ti_item4;
        public TabItem ti_item5;
        public TabLayout tl_rcy1;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.ti_item1 = (TabItem) rootView.findViewById(R.id.ti_item1);
            this.ti_item2 = (TabItem) rootView.findViewById(R.id.ti_item2);
            this.ti_item3 = (TabItem) rootView.findViewById(R.id.ti_item3);
            this.ti_item4 = (TabItem) rootView.findViewById(R.id.ti_item4);
            this.ti_item5 = (TabItem) rootView.findViewById(R.id.ti_item5);
            this.tl_rcy1 = (TabLayout) rootView.findViewById(R.id.tl_rcy1);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_biao;
        public ImageView iv_img;
        public ImageView iv_yuan_a;
        public ImageView yuan_b;
        public TextView tv_biao1;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_biao = (TextView) rootView.findViewById(R.id.tv_biao);
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
            this.iv_yuan_a = (ImageView) rootView.findViewById(R.id.iv_yuan_a);
            this.yuan_b = (ImageView) rootView.findViewById(R.id.yuan_b);
            this.tv_biao1 = (TextView) rootView.findViewById(R.id.tv_biao1);
        }

    }

    public static
    class ViewHolder3 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rv_rcy3;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rv_rcy3 = (RecyclerView) rootView.findViewById(R.id.rv_rcy3);
        }

    }

    public static
    class ViewHolder4 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rv_rcy4;

        public ViewHolder4(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rv_rcy4 = (RecyclerView) rootView.findViewById(R.id.rv_rcy4);
        }

    }

    public static
    class ViewHolder5 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rv_rcy5;

        public ViewHolder5(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rv_rcy5 = (RecyclerView) rootView.findViewById(R.id.rv_rcy5);
        }

    }

    public static
    class ViewHolder6 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_biao6;
        public RecyclerView rv_rcy6;

        public ViewHolder6(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_biao6 = (TextView) rootView.findViewById(R.id.tv_biao6);
            this.rv_rcy6 = (RecyclerView) rootView.findViewById(R.id.rv_rcy6);
        }

    }
}
