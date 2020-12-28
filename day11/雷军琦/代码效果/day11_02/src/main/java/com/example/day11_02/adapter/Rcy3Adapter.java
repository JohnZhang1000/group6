package com.example.day11_02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day11_02.R;

public class Rcy3Adapter extends RecyclerView.Adapter {
    private Context context;

    public Rcy3Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rcy3, parent, false);
        return new ViewHolderrcy3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderrcy3 holderrcy3= (ViewHolderrcy3) holder;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static
    class ViewHolderrcy3 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView item_rcy3_iv;

        public ViewHolderrcy3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.item_rcy3_iv = (ImageView) rootView.findViewById(R.id.item_rcy3_iv);
        }

    }
}
