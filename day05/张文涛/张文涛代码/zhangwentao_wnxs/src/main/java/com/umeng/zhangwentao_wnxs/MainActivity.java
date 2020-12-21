package com.umeng.zhangwentao_wnxs;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.umeng.zhangwentao_wnxs.adapter.HomeRcyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SearchView home_sear;
    private RecyclerView home_rcy;
    private ArrayList<Object> objects;
    private HomeRcyAdapter homeRcyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   initView();
    }

    private void initView() {
        home_sear = (SearchView) findViewById(R.id.home_sear);
        home_rcy = (RecyclerView) findViewById(R.id.home_rcy);
        home_rcy.setLayoutManager(new LinearLayoutManager(this));
        objects = new ArrayList<>();
        homeRcyAdapter = new HomeRcyAdapter(getApplicationContext(),objects);
        home_rcy.setAdapter(homeRcyAdapter);
    }
}
