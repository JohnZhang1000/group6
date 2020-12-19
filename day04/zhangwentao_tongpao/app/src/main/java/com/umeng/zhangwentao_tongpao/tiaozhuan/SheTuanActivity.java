package com.umeng.zhangwentao_tongpao.tiaozhuan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.umeng.zhangwentao_tongpao.R;
import com.umeng.zhangwentao_tongpao.adapter.SheTuaAdapter;
import com.umeng.zhangwentao_tongpao.databean.FaXianSheTuanDataBean;

import java.util.ArrayList;

public class SheTuanActivity extends AppCompatActivity {

    private RecyclerView rcy_shetuan;
    private ArrayList<FaXianSheTuanDataBean.StatusBean> statusBeans;
    private SheTuaAdapter sheTuaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_tuan);
        initView();
    }

    private void initView() {
        rcy_shetuan = (RecyclerView) findViewById(R.id.rcy_shetuan);
        rcy_shetuan.setLayoutManager(new LinearLayoutManager(this));
        statusBeans = new ArrayList<>();
        sheTuaAdapter = new SheTuaAdapter();
    }
}