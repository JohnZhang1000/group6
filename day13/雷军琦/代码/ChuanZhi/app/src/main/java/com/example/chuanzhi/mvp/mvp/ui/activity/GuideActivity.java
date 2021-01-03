package com.example.chuanzhi.mvp.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.chuanzhi.R;
import com.example.chuanzhi.adapter.MyVpAdapter;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {

    private ViewPager guide_vp;
    private ArrayList<View> list;
    private MyVpAdapter myVpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initData();
    }

    private void initData() {
        LayoutInflater from = LayoutInflater.from(this);
        View view1 = from.inflate(R.layout.item_guide_vp1, null);
        View view2 = from.inflate(R.layout.item_guide_vp2, null);
        View view3 = from.inflate(R.layout.item_guide_vp3, null);
        list.add(view1);
        list.add(view2);
        list.add(view3);
        Button bt = view3.findViewById(R.id.item_guide_bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        myVpAdapter.notifyDataSetChanged();
    }

    private void initView() {
        guide_vp = (ViewPager) findViewById(R.id.guide_vp);
        list = new ArrayList<>();
        myVpAdapter = new MyVpAdapter(list);
        guide_vp.setAdapter(myVpAdapter);
    }
}
