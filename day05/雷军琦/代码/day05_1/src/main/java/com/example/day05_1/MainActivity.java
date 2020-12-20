package com.example.day05_1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SearchView sv_sou;
    private ImageView iv_lin;
    private ImageView iv_qian;
    private RecyclerView rv;
    private ArrayList<PorjectsBean> list;
    private MyRcAdapter myRcAdapter;
    private ArrayList<Integer> listi;
    private ArrayList<Integer> list5;
    private ArrayList<Integer> list6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        list.add(new PorjectsBean("seastar",R.drawable.yeu1));
        list.add(new PorjectsBean("风柒",R.drawable.yue2));
        list.add(new PorjectsBean("清芷",R.drawable.yue3));
        list.add(new PorjectsBean("花花娘子",R.drawable.yue4));
        list.add(new PorjectsBean("斜阳未冷",R.drawable.yue5));
        list.add(new PorjectsBean("seastar",R.drawable.yeu1));
        list.add(new PorjectsBean("风柒",R.drawable.yue2));
        list.add(new PorjectsBean("清芷",R.drawable.yue3));
        list.add(new PorjectsBean("花花娘子",R.drawable.yue4));
        list.add(new PorjectsBean("斜阳未冷",R.drawable.yue5));

        listi.add(R.drawable.shan);
        listi.add(R.drawable.shu);
        listi.add(R.drawable.gong);

        list5.add(R.drawable.qing);
        list5.add(R.drawable.qing);
        list5.add(R.drawable.qing);
        list5.add(R.drawable.qing);
        list5.add(R.drawable.qing);
        list5.add(R.drawable.qing);

        list6.add(R.drawable.zhou1);
        list6.add(R.drawable.zhou2);
        list6.add(R.drawable.zhou1);
        list6.add(R.drawable.zhou2);
        list6.add(R.drawable.zhou1);
        list6.add(R.drawable.zhou2);
        list6.add(R.drawable.zhou1);
        list6.add(R.drawable.zhou2);

        myRcAdapter.notifyDataSetChanged();
    }

    private void initView() {
        sv_sou = (SearchView) findViewById(R.id.sv_sou);
        iv_lin = (ImageView) findViewById(R.id.iv_lin);
        iv_qian = (ImageView) findViewById(R.id.iv_qian);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        listi = new ArrayList<>();
        list5 = new ArrayList<>();
        list6 = new ArrayList<>();
        myRcAdapter = new MyRcAdapter(this,list,listi,list5,list6);
        rv.setAdapter(myRcAdapter);
    }
}
