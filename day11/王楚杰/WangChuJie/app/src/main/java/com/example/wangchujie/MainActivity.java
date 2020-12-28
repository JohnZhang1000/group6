package com.example.wangchujie;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wangchujie.adapter.MainAdapter;
import com.example.wangchujie.api.ApiService;
import com.example.wangchujie.bean.Bean;
import com.example.wangchujie.presenter.MainPresenter;
import com.example.wangchujie.view.MainView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = "MainActivity";
    private Toolbar toolbar;
    private RecyclerView rec1;
    private RecyclerView rec2;
    private ArrayList<Bean.DataBean.PostDetailBean.LikeDetailsBean> likeDetailsBeans;
    private MainAdapter mAdapter;
    private Banner banner;
    private MainPresenter mainPresenter;
    private ArrayList<Bean.DataBean.PostDetailBean.ImagesBean> bannerBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initBanner();
        iniData();
    }

    private void initBanner() {
    }

    private void iniData() {
        mainPresenter.getData();
    }

    private void initView() {
        mainPresenter = new MainPresenter(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rec1 = (RecyclerView) findViewById(R.id.rec1);
        rec2 = (RecyclerView) findViewById(R.id.rec2);
        banner = (Banner) findViewById(R.id.banner);

        likeDetailsBeans = new ArrayList<>();
        bannerBeans = new ArrayList<>();

        rec1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rec2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        mAdapter = new MainAdapter(likeDetailsBeans, this);
        rec1.setAdapter(mAdapter);
        rec2.setAdapter(mAdapter);
    }

    @Override
    public void success(Bean bean) {
        bannerBeans.addAll(bean.getData().getPostDetail().getImages());
        banner.setImages(bannerBeans).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Bean.DataBean.PostDetailBean.ImagesBean imagesBean = (Bean.DataBean.PostDetailBean.ImagesBean) path;
                Glide.with(MainActivity.this).load(imagesBean.getFilePath()).into(imageView);
            }
        }).start();


        likeDetailsBeans.addAll(bean.getData().getPostDetail().getLikeDetails());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void fail(String msg) {
        Log.d(TAG, "fail: "+msg);
    }
}