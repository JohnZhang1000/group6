package com.example.demo_zuoye5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReAdaper extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Integer> list;
    private ArrayList<String> strings;

    public ReAdaper(Context context, ArrayList<Integer> list, ArrayList<String> strings) {
        this.context = context;
        this.list = list;
        this.strings = strings;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_first, parent, false);
            return new FirstViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_two, parent, false);
            return new TwoViewHolder(inflate);
        }
        if (viewType == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_three, parent, false);
            return new ThreeViewHolder(inflate);
        }
        if (viewType == 3) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_four, parent, false);
            return new FourViewHolder(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 2) {
            ThreeViewHolder viewHolder1 = (ThreeViewHolder) holder;
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            viewHolder1.re.setLayoutManager(manager);
            MyReAdapter myReAdapter = new MyReAdapter(context, list, strings);
            viewHolder1.re.setAdapter(myReAdapter);
        }
        if (itemViewType == 3) {
            FourViewHolder holder1 = (FourViewHolder) holder;
            holder1.btn_a.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            holder1.btn_b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        if (position == 1) {
            return 1;
        }
        if (position == 2) {
            return 2;
        }
        if (position == 3) {
            return 3;
        }
        if (position == 4) {
            return 4;
        }
        if (position == 5) {
            return 5;
        }
        return 6;

    }

    private class FirstViewHolder extends RecyclerView.ViewHolder {
        public FirstViewHolder(View inflate) {
            super(inflate);
        }
    }

    private class TwoViewHolder extends RecyclerView.ViewHolder {
        public TwoViewHolder(View inflate) {
            super(inflate);
        }
    }

    private class ThreeViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView re;

        public ThreeViewHolder(View inflate) {
            super(inflate);
            this.re = (RecyclerView) inflate.findViewById(R.id.re);
        }
    }

    private class FourViewHolder extends RecyclerView.ViewHolder {
        public Button btn_b;
        public Button btn_a;
        public FourViewHolder(View inflate) {
            super(inflate);
            this.btn_b = (Button) inflate.findViewById(R.id.btn_b);
            this.btn_a = (Button) inflate.findViewById(R.id.btn_a);
        }
    }



}
