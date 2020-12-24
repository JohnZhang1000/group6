package com.example.day07map;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.MapView;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    private MapView mMap;
    private BaiduMapOptions options;
    private Unbinder bind;
    private BaiduMap mBaiduMap;
    private int permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission == PackageManager.PERMISSION_GRANTED){

        }else {
            String[] pers = {
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
            };
            ActivityCompat.requestPermissions(this,pers,100);
        }

        bind = ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mMap = (MapView) findViewById(R.id.map);

        options = new BaiduMapOptions();
        mBaiduMap = mMap.getMap();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMap.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMap.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMap.onDestroy();
        bind.unbind();
    }


    @OnCheckedChanged({R.id.rb1,R.id.rb2,R.id.rb3,R.id.rb4})
    public void onCheckChanged(CompoundButton compoundButton,boolean isCheck){

        switch (compoundButton.getId()){
            case R.id.rb1:
                //卫星地图
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                mBaiduMap.setBaiduHeatMapEnabled(false);
                mBaiduMap.setTrafficEnabled(false);
                break;
            case R.id.rb2:
                //普通地图 ,mBaiduMap是地图控制器对象
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                mBaiduMap.setBaiduHeatMapEnabled(false);
                mBaiduMap.setTrafficEnabled(false);
                break;
            case R.id.rb3:
                //开启热力图
                mBaiduMap.setBaiduHeatMapEnabled(true);
                mBaiduMap.setTrafficEnabled(false);
                break;
            case R.id.rb4:
                //开启交通图
                mBaiduMap.setTrafficEnabled(true);
                mBaiduMap.setBaiduHeatMapEnabled(false);
                break;
        }
    }
}
