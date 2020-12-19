package com.example.wangchujie.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.wangchujie.R;
import com.example.wangchujie.adapter.FindAdapter;
import com.example.wangchujie.api.ApiService;
import com.example.wangchujie.bean.HotBean;
import com.example.wangchujie.bean.TabBean;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FindFragment extends Fragment {

    private static final String TAG = "FindFragment";
    private RecyclerView mRec;
    private ArrayList<HotBean.DataBean> hotBeans;
    private FindAdapter mAdapter;
    private ArrayList<TabBean.DataBean> tabBeans;
    private ViewPager mVp;
    private TabLayout mTb;
    private ArrayList<TVFragment> tvFragments;
    private NestedScrollView mNest;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, null);
        initView(view);
        initHot();
        initNav();
        return view;
    }


    private void initNav() {
        new Retrofit.Builder()
                .baseUrl(ApiService.sUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getNav()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<TabBean>() {
                    @Override
                    public void onNext(TabBean navBean) {
                        tabBeans.addAll(navBean.getData());
                        initVpFragment();
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d(TAG, "onError: "+t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initVpFragment() {
        tvFragments = new ArrayList<>();
        for (int i = 0; i < tabBeans.size(); i++) {
            tvFragments.add(new TVFragment(tabBeans.get(i).getType()));
        }

        mTb.setupWithViewPager(mVp);
        mVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return tvFragments.get(position);
            }

            @Override
            public int getCount() {
                return tvFragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tabBeans.get(position).getName();
            }
        });
    }

    private void initHot() {
        new Retrofit.Builder()
                .baseUrl(ApiService.sUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getHot()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<HotBean>() {
                    @Override
                    public void onNext(HotBean hotBean) {
                        hotBeans.addAll(hotBean.getData());
                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d(TAG, "onError: "+t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        mRec = view.findViewById(R.id.find_rec);
        mVp = view.findViewById(R.id.hot_vp);
        mTb = view.findViewById(R.id.hot_tab);
        mNest = view.findViewById(R.id.nest_scrollview);

        mNest.setFillViewport(true);

        hotBeans = new ArrayList<>();
        tabBeans = new ArrayList<>();

        mRec.setLayoutManager(new LinearLayoutManager(getContext()));


        mAdapter = new FindAdapter(getContext(),hotBeans);
        mRec.setAdapter(mAdapter);

    }
}
