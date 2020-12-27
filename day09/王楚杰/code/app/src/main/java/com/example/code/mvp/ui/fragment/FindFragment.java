package com.example.code.mvp.ui.fragment;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.code.R;
import com.example.mylibrary.base.BaseFragment;
import com.example.mylibrary.base.BasePresenter;
import com.example.code.bean.HotBean;
import com.example.code.bean.TabBean;
import com.example.code.engine.adapter.FindAdapter;
import com.example.code.mvp.presenter.FindPresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

public class FindFragment extends BaseFragment {
    @BindView(R.id.find_rec)
    RecyclerView mRec;
    @BindView(R.id.hot_vp)
    ViewPager mVp;
    @BindView(R.id.hot_tab)
    TabLayout mTb;
    @BindView(R.id.nest_scrollview)
    NestedScrollView mNest;

    private static final String TAG = "FindFragment";
    private ArrayList<HotBean.DataBean> hotBeans;
    private FindAdapter mAdapter;
    private ArrayList<TabBean.DataBean> tabBeans;
    private ArrayList<TVFragment> tvFragments;


    @Override
    protected BasePresenter createPresenter() {
        return new FindPresenter(this);
    }


    @Override
    protected void init() {
        mNest.setFillViewport(true);
        hotBeans = new ArrayList<>();
        tabBeans = new ArrayList<>();

        mRec.setLayoutManager(new LinearLayoutManager(getContext()));

        mAdapter = new FindAdapter(getContext(), hotBeans);
        mRec.setAdapter(mAdapter);
    }




    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
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

    @Override
    public void onSuccess(Object o) {
        super.onSuccess(o);

        HotBean hotBean = (HotBean) o;
        hotBeans.addAll(hotBean.getData());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {
        super.onFail(msg);
        Log.d(TAG, "onFail: "+msg);
    }
}
