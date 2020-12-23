package com.example.demo_zuoye4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RankingActivity extends AppCompatActivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        initView();
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(this));
    }
}