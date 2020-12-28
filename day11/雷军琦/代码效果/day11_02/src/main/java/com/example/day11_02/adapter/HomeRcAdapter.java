package com.example.day11_02.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day11_02.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class HomeRcAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Integer> img;

    public HomeRcAdapter(Context context, ArrayList<Integer> img) {
        this.context = context;
        this.img = img;
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
                View view0 = LayoutInflater.from(context).inflate(R.layout.item_list_rcy1, parent, false);
                return new ViewHolder0(view0);
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.item_list_rcy2, parent, false);
                return new ViewHolder1(view1);
            case 2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.item_list_rcy3, parent, false);
                return new ViewHolder2(view2);
            case 3:
                View view3 = LayoutInflater.from(context).inflate(R.layout.item_list_rcy4, parent, false);
                return new ViewHolder3(view3);
            case 4:
                View view4 = LayoutInflater.from(context).inflate(R.layout.item_list_rcy5, parent, false);
                return new ViewHolder4(view4);
            case 5:
                View view5 = LayoutInflater.from(context).inflate(R.layout.item_list_rcy6, parent, false);
                return new ViewHolder5(view5);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        switch (position) {
            case 0:
                ViewHolder0 viewHolder0 = (ViewHolder0) holder;
                viewHolder0.rcy_ban.setImages(img)
                        .setImageLoader(new ImageLoader() {
                            @Override
                            public void displayImage(Context context, Object path, ImageView imageView) {
                                Glide.with(context).load(path).into(imageView);
                            }
                        }).start();
                break;
            case 1:
                ViewHolder1 viewHolder1 = (ViewHolder1) holder;
                break;
            case 2:
                ViewHolder2 viewHolder2 = (ViewHolder2) holder;
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                viewHolder2.rcy3_rv.setLayoutManager(manager);
                Rcy3Adapter rcy3Adapter = new Rcy3Adapter(context);
                viewHolder2.rcy3_rv.setAdapter(rcy3Adapter);
                break;
            case 3:
                ViewHolder3 viewHolder3 = (ViewHolder3) holder;
                LinearLayoutManager managers = new LinearLayoutManager(context);
                managers.setOrientation(LinearLayoutManager.HORIZONTAL);
                viewHolder3.rcy4_rv.setLayoutManager(managers);
                Rcy4Adapter rcy4Adapter = new Rcy4Adapter(context);
                viewHolder3.rcy4_rv.setAdapter(rcy4Adapter);
                break;
            case 4:
                final ViewHolder4 viewHolder4 = (ViewHolder4) holder;
                viewHolder4.rcy5_bt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ObjectAnimator.ofFloat(viewHolder4.rcy5_bt1, View.SCALE_Y, 1, 2);
                    }
                });
                break;
            case 5:
                ViewHolder5 viewHolder5= (ViewHolder5) holder;
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public static
    class ViewHolder0 extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner rcy_ban;

        public ViewHolder0(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rcy_ban = (Banner) rootView.findViewById(R.id.rcy_ban);
        }

    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView rcy2_iv1;
        public ImageView rcy2_iv2;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rcy2_iv1 = (ImageView) rootView.findViewById(R.id.rcy2_iv1);
            this.rcy2_iv2 = (ImageView) rootView.findViewById(R.id.rcy2_iv2);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rcy3_rv;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rcy3_rv = (RecyclerView) rootView.findViewById(R.id.rcy3_rv);
        }

    }

    public static
    class ViewHolder3 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rcy4_rv;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rcy4_rv = (RecyclerView) rootView.findViewById(R.id.rcy4_rv);
        }

    }

    public static
    class ViewHolder4 extends RecyclerView.ViewHolder {
        public View rootView;
        public Button rcy5_bt1;
        public Button rcy5_bt2;
        public Button rcy5_bt3;
        public Button rcy5_bt4;

        public ViewHolder4(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rcy5_bt1 = (Button) rootView.findViewById(R.id.rcy5_bt1);
            this.rcy5_bt2 = (Button) rootView.findViewById(R.id.rcy5_bt2);
            this.rcy5_bt3 = (Button) rootView.findViewById(R.id.rcy5_bt3);
            this.rcy5_bt4 = (Button) rootView.findViewById(R.id.rcy5_bt4);
        }

    }

    public static
    class ViewHolder5 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView item_rcy6_iv;

        public ViewHolder5(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.item_rcy6_iv = (ImageView) rootView.findViewById(R.id.item_rcy6_iv);
        }

    }
}
