package com.example.day10_01;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnGetSuggestionResultListener {

    private Button bt_ditu;
    private SearchView main_sv;
    private ListView mSugListView;
    private SuggestionSearch mSuggestionSearch = null;
    private static boolean isPermissionRequested = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();
        initView();
    }

    private void initView() {
        bt_ditu = (Button) findViewById(R.id.bt_ditu);
        bt_ditu.setOnClickListener(this);
        main_sv = (SearchView) findViewById(R.id.main_sv);
        mSuggestionSearch = SuggestionSearch.newInstance();
        mSuggestionSearch.setOnGetSuggestionResultListener(this);
        main_sv.setOnClickListener(this);
        mSugListView = (ListView) findViewById(R.id.sug_list);
        main_sv.setIconified(false);
        main_sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)) {  // 文本工具 检测是否为空，检测空，是输入文本改变 并且为空时触发，刚点击时候虽然为空，但是文本内容没有改变
                    // 设置 容器 的更新
                    mSuggestionSearch.requestSuggestion((new SuggestionSearchOption())
                            .keyword(newText) // 关键字
                            .city("北京"));
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_ditu:
                Intent intent = new Intent(MainActivity.this, MarkerClusterDemo.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onGetSuggestionResult(SuggestionResult suggestionResult) {
        if (suggestionResult == null || suggestionResult.getAllSuggestions() == null) {
            return;
        }

        List<HashMap<String, String>> suggest = new ArrayList<>();
        ArrayList<LatLng> list = new ArrayList<>();
        for (SuggestionResult.SuggestionInfo info : suggestionResult.getAllSuggestions()) {
            if (info.getKey() != null && info.getDistrict() != null && info.getCity() != null) {
                HashMap<String, String> map = new HashMap<>();
                map.put("key",info.getKey());
                map.put("city",info.getCity());
                map.put("dis",info.getDistrict());
                list.add(info.getPt());
                suggest.add(map);
            }
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext(),
                suggest,
                R.layout.item_layout,
                new String[]{"key", "city","dis"},
                new int[]{R.id.sug_key, R.id.sug_city, R.id.sug_dis});
        mSugListView.setAdapter(simpleAdapter);
        simpleAdapter.notifyDataSetChanged();
        mSugListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,MarkerClusterDemoTwo.class);
                intent.putExtra("latitude",list.get((int)id).latitude);
                intent.putExtra("longitude",list.get((int)id).longitude);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSuggestionSearch.destroy();
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= 23 && !isPermissionRequested) {

            isPermissionRequested = true;

            ArrayList<String> permissionsList = new ArrayList<>();

            String[] permissions = {
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.INTERNET,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.MODIFY_AUDIO_SETTINGS,
                    Manifest.permission.WRITE_SETTINGS,
                    Manifest.permission.ACCESS_WIFI_STATE,
                    Manifest.permission.CHANGE_WIFI_STATE,
                    Manifest.permission.CHANGE_WIFI_MULTICAST_STATE


            };

            for (String perm : permissions) {
                if (PackageManager.PERMISSION_GRANTED != checkSelfPermission(perm)) {
                    permissionsList.add(perm);
                    // 进入到这里代表没有权限.
                }
            }

            if (permissionsList.isEmpty()) {
                return;
            } else {
                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]), 0);
            }
        }
    }
}
