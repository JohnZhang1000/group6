package com.example.day1227_zonghe;

import androidx.annotation.NonNull;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;

import com.baidu.mapapi.map.MapView;

import com.baidu.mapapi.model.LatLng;
import com.example.day1227_zonghe.clusterutil.clustering.ClusterManager;
import com.example.day1227_zonghe.geometry.MarkerClusterDemo;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    public static MapView mMapView = null;
    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient;
    private ClusterManager<MarkerClusterDemo.MyItem> mClusterManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPermition();
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();

        mBaiduMap.setMyLocationEnabled(true);

        //---------------------------------------
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
        //--------------------------------
//定义Maker坐标点
        LatLng point = new LatLng(39.963175, 116.400244);
//构建Marker图标
//        BitmapDescriptor bitmap = BitmapDescriptorFactory
////                .fromResource(R.drawable.icon_marka);
//////构建MarkerOption，用于在地图上添加Marker
////        OverlayOptions option1 = new MarkerOptions()
////                .position(point)
////                .icon(bitmap);
//////在地图上添加Marker，并显示
////        mBaiduMap.addOverlay(option1);
        //-----------------点聚合----------------------
        //初始化点聚合管理类
        mClusterManager = new ClusterManager<MarkerClusterDemo.MyItem>(this, mBaiduMap);
        // 添加Marker点

        LatLng llA = new LatLng(39.963175, 116.400244);
        LatLng llB = new LatLng(39.942821, 116.369199);
        List<MarkerClusterDemo.MyItem> items = new ArrayList<MarkerClusterDemo.MyItem>();
        items.add(new MarkerClusterDemo.MyItem(llA));
        items.add(new MarkerClusterDemo.MyItem(llB));
        mClusterManager.addItems(items);
    }

    private void getPermition() {
        PermissionsUtil.requestPermission(this, new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permission) {

            }

            @Override
            public void permissionDenied(@NonNull String[] permission) {

            }
        },new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION});
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
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
        mLocationClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
        mMapView = null;
    }
}