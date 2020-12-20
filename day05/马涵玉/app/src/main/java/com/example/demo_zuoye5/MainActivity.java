package com.example.demo_zuoye5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView re;
    private ArrayList<Integer> list;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {

        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i=0;i<10;i++){
            list1.add(R.drawable.b);
        }
        list.addAll(list1);

        ArrayList<String> strings1 = new ArrayList<>();
        for (int i=0;i<10;i++){
            strings1.add("每日推荐");
        }
        strings.addAll(strings1);
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        list = new ArrayList<>();
        strings = new ArrayList<>();
        re.setLayoutManager(new LinearLayoutManager(this));
        ReAdaper reAdaper = new ReAdaper(this, list, strings);
        re.setAdapter(reAdaper);
    }
}