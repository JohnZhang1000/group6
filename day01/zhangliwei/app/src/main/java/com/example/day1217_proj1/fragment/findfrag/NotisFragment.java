package com.example.day1217_proj1.fragment.findfrag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day1217_proj1.R;

import java.util.ArrayList;


public class NotisFragment extends Fragment {


    private RecyclerView rcy_notis;
    private FragmentActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notis, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rcy_notis = view.findViewById(R.id.rcy_notis);
        rcy_notis.setLayoutManager(new LinearLayoutManager(activity));
        rcy_notis.addItemDecoration(new DividerItemDecoration(activity,DividerItemDecoration.VERTICAL));


    }
}