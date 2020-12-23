package com.example.day08_01;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    private MapView mMapView = null;
    private RadioButton main_rb1;
    private RadioButton main_rb2;
    private RadioButton main_rb3;
    private RadioButton main_rb4;
    private BaiduMap mMap;
    private Unbinder mBind;
    private LocationClient mLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);
        initPermissionsUtil();
        initView();
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mMap = mMapView.getMap();
        mMap.setMyLocationEnabled(true);
        initLocationClient();
    }

    private void initLocationClient() {
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
    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mMapView == null){
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mMap.setMyLocationData(locData);
        }
    }



    private void initPermissionsUtil() {
        PermissionsUtil.requestPermission(this, new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permission) {

            }

            @Override
            public void permissionDenied(@NonNull String[] permission) {

            }
        }, new String[]{Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION});

    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        mLocationClient.stop();
        mMap.setMyLocationEnabled(false);

        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
        mMap=null;
        mBind.unbind();
        super.onDestroy();
    }

    private void initView() {
        main_rb1 = (RadioButton) findViewById(R.id.main_rb1);
        main_rb2 = (RadioButton) findViewById(R.id.main_rb2);
        main_rb3 = (RadioButton) findViewById(R.id.main_rb3);
        main_rb4 = (RadioButton) findViewById(R.id.main_rb4);

    }
    @OnCheckedChanged({R.id.main_rb1, R.id.main_rb2, R.id.main_rb3, R.id.main_rb4})
    public void onCehcedChange(CompoundButton button, boolean isChecked) {
        switch (button.getId()) {
            case R.id.main_rb1:
                //卫星图
                mMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.main_rb2:
                //普通地图
                mMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
            case R.id.main_rb3:
                //开启热力图
                mMap.setBaiduHeatMapEnabled(true);
                break;
            case R.id.main_rb4:
                //开启实时交通图
                mMap.setTrafficEnabled(true);
                break;
        }
    }
}
