package com.example.day07map;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.example.day07map.searchroute.RouteLineAdapter;
import com.example.day07map.searchroute.SelectRouteDialog;
import com.example.day07map.util.BikingRouteOverlay;
import com.example.day07map.util.NodeUtils;
import com.example.day07map.util.OverlayManager;

public class BikingNavActivity extends AppCompatActivity implements BaiduMap.OnMapClickListener,
        OnGetRoutePlanResultListener {

    /**
     * 北京
     */
    private EditText mStCity;
    /**
     * 西二旗地铁站
     */
    private AutoCompleteTextView mStNode;
    private LinearLayout mInputSearch;
    /**
     * 北京
     */
    private EditText mEdCity;
    /**
     * 百度科技园
     */
    private AutoCompleteTextView mEdNode;
    /**
     * 查询路线
     */
    private Button mDrive;
    /**
     * 骑行类型（选中普通骑行模式，不选中电动车模式）
     */
    private CheckBox mRidingType;
    private MapView mMap;
    /**
     * 自定义起终点图标
     */
    private Button mCustomicon;
    private Button mPre;
    private Button mNext;
    private BaiduMap mBaidumap;
    private RoutePlanSearch mSearch;
    private NodeUtils mNodeUtils;
    private RouteLine mRouteLine;
    private OverlayManager routeOverlay = null;
    boolean mUseDefaultIcon = false;
    private BikingRouteResult mBikingRouteResult = null;
    private boolean hasShowDialog = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biking_nav);
        initView();
    }

    private void initView() {
        mStCity = (EditText) findViewById(R.id.st_city);
        mStNode = (AutoCompleteTextView) findViewById(R.id.st_node);
        mInputSearch = (LinearLayout) findViewById(R.id.input_search);
        mEdCity = (EditText) findViewById(R.id.ed_city);
        mEdNode = (AutoCompleteTextView) findViewById(R.id.ed_node);
        mDrive = (Button) findViewById(R.id.drive);
        mRidingType = (CheckBox) findViewById(R.id.ridingType);
        mMap = (MapView) findViewById(R.id.map);
        mCustomicon = (Button) findViewById(R.id.customicon);
        mPre = (Button) findViewById(R.id.pre);
        mNext = (Button) findViewById(R.id.next);

        // 初始化地图
        mBaidumap = mMap.getMap();
        // 地图点击事件处理
        mBaidumap.setOnMapClickListener(this);
        // 初始化搜索模块，注册事件监听
        mSearch = RoutePlanSearch.newInstance();
        mSearch.setOnGetRoutePlanResultListener(this);
        mNodeUtils = new NodeUtils(this, mBaidumap);
    }



    public void searchButtonProcess(View v) {
        // 重置浏览节点的路线数据
        mRouteLine = null;
        mPre.setVisibility(View.INVISIBLE);
        mNext.setVisibility(View.INVISIBLE);
        mBaidumap.clear();

        // 设置起终点信息 起点参数
        PlanNode startNode = PlanNode.withCityNameAndPlaceName(mStCity.getText().toString().trim(),
                mStNode.getText().toString().trim());
        // 终点参数
        PlanNode endNode = PlanNode.withCityNameAndPlaceName(mEdCity.getText().toString().trim(),
                mEdNode.getText().toString().trim());
        // 步行路线规划参数
        BikingRoutePlanOption bikingRoutePlanOption = new BikingRoutePlanOption().from(startNode).to(endNode);
        // 骑行类型（0：普通骑行模式，1：电动车模式）默认是普通模式
        if (mRidingType.isChecked()) {
            bikingRoutePlanOption.ridingType(0);
        } else {
            bikingRoutePlanOption.ridingType(1);
        }
        // 发起骑行路线规划检索
        mSearch.bikingSearch(bikingRoutePlanOption);
    }


    /**
     * 节点浏览
     */
    public void nodeClick(View v) {
        if (null != mRouteLine) {
            mNodeUtils.browseRoutNode(v, mRouteLine);
        }
    }


    /**
     * 切换路线图标，刷新地图使其生效
     * 注意： 起终点图标使用中心对齐.
     */
    public void changeRouteIcon(View v) {
        if (routeOverlay == null) {
            return;
        }
        if (mUseDefaultIcon) {
            ((Button) v).setText("自定义起终点图标");
            Toast.makeText(this, "将使用系统起终点图标", Toast.LENGTH_SHORT).show();

        } else {
            ((Button) v).setText("系统起终点图标");
            Toast.makeText(this, "将使用自定义起终点图标", Toast.LENGTH_SHORT).show();
        }
        mUseDefaultIcon = !mUseDefaultIcon;
        routeOverlay.removeFromMap();
        routeOverlay.addToMap();
    }

    @Override
    public void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult) {

    }

    @Override
    public void onGetTransitRouteResult(TransitRouteResult transitRouteResult) {

    }

    @Override
    public void onGetMassTransitRouteResult(MassTransitRouteResult massTransitRouteResult) {

    }

    @Override
    public void onGetDrivingRouteResult(DrivingRouteResult drivingRouteResult) {

    }

    @Override
    public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {

    }

    /**
     * 骑行路线结果回调
     *
     * @param result  骑行路线结果
     *
     */
    @Override
    public void onGetBikingRouteResult(BikingRouteResult result) {
        if(null == result){
            return;
        }
        if (result.error != SearchResult.ERRORNO.NO_ERROR) {
            Toast.makeText(BikingNavActivity.this, "抱歉，未找到结果", Toast.LENGTH_SHORT).show();
        }
        if (result.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
            // 起终点或途经点地址有岐义，通过以下接口获取建议查询信息
            // result.getSuggestAddrInfo()
            AlertDialog.Builder builder = new AlertDialog.Builder(BikingNavActivity.this);
            builder.setTitle("提示");
            builder.setMessage("检索地址有歧义，请重新设置。\n可通过getSuggestAddrInfo()接口获得建议查询信息");
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
            return;
        }
        if (result.error == SearchResult.ERRORNO.NO_ERROR) {
            mPre.setVisibility(View.VISIBLE);
            mNext.setVisibility(View.VISIBLE);

            if (result.getRouteLines().size() > 1) {
                 mBikingRouteResult = result;
                if (!hasShowDialog) {
                    SelectRouteDialog selectRouteDialog = new SelectRouteDialog(BikingNavActivity.this,
                            result.getRouteLines(),
                            RouteLineAdapter.Type.DRIVING_ROUTE);
                    selectRouteDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            hasShowDialog = false;
                        }
                    });
                    selectRouteDialog.setOnItemInDlgClickLinster(new SelectRouteDialog.OnItemInDlgClickListener() {
                        public void onItemClick(int position) {
                            mRouteLine = mBikingRouteResult.getRouteLines().get(position);
                            BikingRouteOverlay overlay = new MyBikingRouteOverlay(mBaidumap);
                            mBaidumap.setOnMarkerClickListener(overlay);
                            routeOverlay = overlay;
                            overlay.setData(mBikingRouteResult.getRouteLines().get(position));
                            overlay.addToMap();
                            overlay.zoomToSpan();
                        }

                    });
                    selectRouteDialog.show();
                    hasShowDialog = true;
                }
            } else if (result.getRouteLines().size() == 1) {
                mRouteLine = result.getRouteLines().get(0);
                BikingRouteOverlay overlay = new MyBikingRouteOverlay(mBaidumap);
                routeOverlay = overlay;
                mBaidumap.setOnMarkerClickListener(overlay);
                overlay.setData(result.getRouteLines().get(0));
                overlay.addToMap();
                overlay.zoomToSpan();
                mPre.setVisibility(View.VISIBLE);
                mNext.setVisibility(View.VISIBLE);
            } else {
                Log.d("route result", "结果数<0");
                return;
            }

        }
    }

    private class MyBikingRouteOverlay extends BikingRouteOverlay {
        private MyBikingRouteOverlay(BaiduMap baiduMap) {
            super(baiduMap);
        }

        @Override
        public BitmapDescriptor getStartMarker() {
            if (mUseDefaultIcon) {
                return BitmapDescriptorFactory.fromResource(R.drawable.icon_st);
            }
            return null;
        }

        @Override
        public BitmapDescriptor getTerminalMarker() {
            if (mUseDefaultIcon) {
                return BitmapDescriptorFactory.fromResource(R.drawable.icon_en);
            }
            return null;
        }
    }


    @Override
    public void onMapClick(LatLng point) {
        mBaidumap.hideInfoWindow();
    }

    @Override
    public void onMapPoiClick(MapPoi poi) {

    }



    @Override
    protected void onPause() {
        super.onPause();
        mMap.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMap.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mSearch != null) {
            // 释放检索对象
            mSearch.destroy();
        }
        mBaidumap.clear();
        //  释放地图控件
        mMap.onDestroy();
    }
}
