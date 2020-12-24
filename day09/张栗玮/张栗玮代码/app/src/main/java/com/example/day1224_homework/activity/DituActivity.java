package com.example.day1224_homework.activity;

import android.Manifest;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.example.day1224_homework.R;
import com.example.day1224_homework.adapter.DiTuRcyAdapter;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DituActivity extends AppCompatActivity {
    @BindView(R.id.et_city)
    EditText etCity;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.dt_rcy)
    RecyclerView dtRcy;
    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient;
    @BindView(R.id.bmapView2)
    MapView bmapView2;
    private Unbinder bind;
    private SuggestionSearch mSuggestionSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ditu);
        bind = ButterKnife.bind(this);
        getPermition();
    }

    private void getPermition() {
        PermissionsUtil.requestPermission(this, new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permission) {

            }

            @Override
            public void permissionDenied(@NonNull String[] permission) {

            }
        }, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION});
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        bmapView2.onResume();
        mBaiduMap = bmapView2.getMap();//得到地图对象
        mBaiduMap.setMyLocationEnabled(true);//开启定位图层
        //定位初始化
        mLocationClient = new LocationClient(this);
        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);

//设置locationClientOption
        mLocationClient.setLocOption(option);

//注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();

        mLocationClient.registerLocationListener(myLocationListener);
//开启地图定位图层
        mLocationClient.start();

        //-------------------模糊查询------------------------
       // 创建Sug检索实例
        mSuggestionSearch = SuggestionSearch.newInstance();
        mSuggestionSearch.setOnGetSuggestionResultListener(listener);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String city = etCity.getText().toString();
                String search = etSearch.getText().toString();


                mSuggestionSearch.requestSuggestion(new SuggestionSearchOption()
                        .city(city+"")
                        .keyword(s+""));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
    private OnGetSuggestionResultListener listener = new OnGetSuggestionResultListener() {
        @Override
        public void onGetSuggestionResult(SuggestionResult suggestionResult) {
            //处理sug检索结果

            dtRcy.setLayoutManager(new LinearLayoutManager(DituActivity.this));
            dtRcy.addItemDecoration(new DividerItemDecoration(DituActivity.this,DividerItemDecoration.VERTICAL));
            ArrayList<SuggestionResult.SuggestionInfo> list = (ArrayList<SuggestionResult.SuggestionInfo>) suggestionResult.getAllSuggestions();
            if(list!=null&&list.size()>0){
                DiTuRcyAdapter adapter = new DiTuRcyAdapter(DituActivity.this, list);
                dtRcy.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }


        }
    };

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || bmapView2 == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        bmapView2.onPause();
    }


    @Override
    protected void onDestroy() {
        mLocationClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
        bind.unbind();
        //  bmapView2.onDestroy();
        mSuggestionSearch.destroy();
        bmapView2 = null;
        super.onDestroy();
    }
}