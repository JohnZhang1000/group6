package com.example.day1224_homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baidu.mapapi.search.sug.SuggestionResult;
import com.example.day1224_homework.R;

import java.util.ArrayList;

public class DiTuRcyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<SuggestionResult.SuggestionInfo> list;

    public DiTuRcyAdapter(Context context, ArrayList<SuggestionResult.SuggestionInfo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SuggestionResult.SuggestionInfo info = list.get(position);

        ViewHolder holder1 = (ViewHolder)holder;
        holder1.tv_area.setText(info.key);
        holder1.tv_distract.setText(info.city+" "+info.district);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_area;
        public TextView tv_distract;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_area = (TextView) rootView.findViewById(R.id.tv_area);
            this.tv_distract = (TextView) rootView.findViewById(R.id.tv_distract);
        }

    }
}
