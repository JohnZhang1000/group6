package com.example.day11_02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day11_02.R;

public class Rcy4Adapter extends RecyclerView.Adapter {
    private Context context;

    public Rcy4Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rcy4, parent, false);
        return new ViewHolderrcy4(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderrcy4 holderrcy4 = (ViewHolderrcy4) holder;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static
    class ViewHolderrcy4 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView item_rcy3_iv;

        public ViewHolderrcy4(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.item_rcy3_iv = (ImageView) rootView.findViewById(R.id.item_rcy3_iv);
        }

    }

    public static
    class ViewHolder {
        public View rootView;
        public ImageView item_rcy4_iv;
        public TextView item_rcy4_tv1;
        public TextView item_rcy4_tv2;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.item_rcy4_iv = (ImageView) rootView.findViewById(R.id.item_rcy4_iv);
            this.item_rcy4_tv1 = (TextView) rootView.findViewById(R.id.item_rcy4_tv1);
            this.item_rcy4_tv2 = (TextView) rootView.findViewById(R.id.item_rcy4_tv2);
        }

    }
}
