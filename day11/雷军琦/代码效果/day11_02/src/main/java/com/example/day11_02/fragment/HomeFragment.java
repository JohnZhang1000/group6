package com.example.day11_02.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day11_02.adapter.HomeRcAdapter;
import com.example.day11_02.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        RecyclerView rv = view.findViewById(R.id.home_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<Integer> img = new ArrayList<>();
        img.add(R.drawable.gge1);
        img.add(R.drawable.gge2);
        img.add(R.drawable.gge3);
        img.add(R.drawable.gge4);
        HomeRcAdapter homeRcAdapter = new HomeRcAdapter(getContext(), img);
        rv.setAdapter(homeRcAdapter);
    }
}
