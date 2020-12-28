package com.example.day1228_homework.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day1228_homework.R;
import com.example.day1228_homework.adapter.MyRcyHomeAdapter;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private RecyclerView rcy_home;
    private FragmentActivity activity;
    private ArrayList<Integer> integers;
    private MyRcyHomeAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        //banner的资源
        integers.add(R.drawable.a1);
        adapter.notifyDataSetChanged();

    }

    private void initView(View view) {
        rcy_home = view.findViewById(R.id.rcy_home);
        rcy_home.setLayoutManager(new LinearLayoutManager(activity));
        integers = new ArrayList<>();
        adapter = new MyRcyHomeAdapter(activity, integers);
        rcy_home.setAdapter(adapter);


    }
}