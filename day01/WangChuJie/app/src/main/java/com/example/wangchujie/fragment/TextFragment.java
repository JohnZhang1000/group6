package com.example.wangchujie.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wangchujie.R;

import com.example.wangchujie.adapter.TextFragmentAdapter;
import com.example.wangchujie.bean.ImgBean;
import com.example.wangchujie.bean.TextBean;
import com.example.wangchujie.bean.VideoBean;
import com.example.wangchujie.presenter.SofaPresenter;
import com.example.wangchujie.view.SofaView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;

public class TextFragment extends Fragment implements SofaView {

    private static final String TAG = "TextFragment";
    private RecyclerView mRec;
    private SofaPresenter sofaPresenter;
    private ArrayList<TextBean.DataBeanX.DataBean> authorBeans;
    private TextFragmentAdapter mAdapter;
    private SmartRefreshLayout mSmart;
    private int pageCount = 10;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_img, null);
        initView(view);
        initData();
        initSmart();
        return view;
    }

    private void initSmart() {
        mSmart.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                pageCount++;
                initData();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageCount = 10;
                authorBeans.clear();
                initData();
            }
        });
    }

    private void initData() {
        sofaPresenter.getText(pageCount);
    }

    private void initView(View view) {
        sofaPresenter = new SofaPresenter(this);
        mRec = view.findViewById(R.id.img_rec);
        mSmart = view.findViewById(R.id.smart);

        authorBeans = new ArrayList<>();

        mRec.setLayoutManager(new LinearLayoutManager(getContext()));

        mAdapter = new TextFragmentAdapter(authorBeans,getContext());
        mRec.setAdapter(mAdapter);

    }

    @Override
    public void success(ImgBean imgBean) {

    }

    @Override
    public void fail(String msg) {
        Log.d(TAG, "fail: "+msg);
    }

    @Override
    public void getVideo(VideoBean videoBean) {

    }

    @Override
    public void getText(TextBean textBean) {
        authorBeans.addAll(textBean.getData().getData());
        mAdapter.notifyDataSetChanged();
        mSmart.finishLoadmore();
        mSmart.finishRefresh();
    }
}
