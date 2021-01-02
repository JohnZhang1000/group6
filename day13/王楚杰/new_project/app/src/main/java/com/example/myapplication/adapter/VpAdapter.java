package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myapplication.R;
import com.example.myapplication.activity.GuildActivity;
import com.example.myapplication.activity.MainActivity;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class VpAdapter extends PagerAdapter {

    private final ArrayList<Integer> pageList;
    private Context context;
    private SharedPreferences sp;

    public VpAdapter(ArrayList<Integer> pageList, Context context) {
        this.pageList = pageList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pageList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(pageList.get(position), null);
        if (position == 2){
            TextView mTv_skip = view.findViewById(R.id.splash_tv_skip);
            mTv_skip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sp = context.getSharedPreferences("sp", MODE_PRIVATE);
                    sp.edit().putBoolean("flag",true).commit();
                    context.startActivity(new Intent(context, MainActivity.class));
                    myClick.onItemClick();
                }
            });
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public interface MyClick{
        void onItemClick();
    }

    private MyClick myClick;

    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
    }
}
