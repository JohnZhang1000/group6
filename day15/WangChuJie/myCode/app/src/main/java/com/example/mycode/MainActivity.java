package com.example.mycode;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvplibrary.base.BaseActivity;
import com.example.mvplibrary.base.BasePresenter;
import com.example.mycode.adapter.MainAdapter;
import com.example.mycode.bean.BannerBean;
import com.example.mycode.bean.TopicBean;
import com.example.mycode.presenter.Main2Presenter;
import com.example.mycode.presenter.MainPresenter;
import com.example.mycode.view.MainView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {


    private static final String TAG = "MainActivity";
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.rec)
    RecyclerView mRec;
    private BasePresenter presenter;
    private ArrayList<BannerBean.DataBean.PostDetailBean.ImagesBean> bannerBeans;
    private ArrayList<TopicBean.DataBean> topicBeans;
    private MainAdapter mAdapter;
    private Main2Presenter main2Presenter;

    @Override
    protected BasePresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        main2Presenter = new Main2Presenter(this);
        presenter = getmPresenter();
        bannerBeans = new ArrayList<>();
        topicBeans = new ArrayList<>();
        mRec.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        mRec.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        mAdapter = new MainAdapter(topicBeans,this);
        mRec.setAdapter(mAdapter);

    }

    @Override
    protected void initData() {
        super.initData();
        presenter.start();
        main2Presenter.getData();
    }


    @Override
    public void onSuccess(Object o) {
        super.onSuccess(o);
        BannerBean bannerBean = (BannerBean) o;
        bannerBeans.addAll(bannerBean.getData().getPostDetail().getImages());
        mBanner.setImages(bannerBeans).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                BannerBean.DataBean.PostDetailBean.ImagesBean imagesBean= (BannerBean.DataBean.PostDetailBean.ImagesBean) path;
                Glide.with(MainActivity.this).load(imagesBean.getFilePath()).into(imageView);
            }
        }).start();
    }

    @Override
    public void onFail(String msg) {
        super.onFail(msg);
        Log.d(TAG, "onFail: "+msg);
    }

    @Override
    protected void click(View view) {

    }


    @Override
    public void success(TopicBean topicBean) {
        topicBeans.addAll(topicBean.getData());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void fail(String msg) {
        Log.d(TAG, "fail: "+msg);
    }
}