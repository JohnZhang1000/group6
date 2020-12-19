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
import com.example.wangchujie.adapter.ImgFragmentAdapter;
import com.example.wangchujie.adapter.VideoFragmentAdapter;
import com.example.wangchujie.bean.ImgBean;
import com.example.wangchujie.bean.TextBean;
import com.example.wangchujie.bean.VideoBean;
import com.example.wangchujie.presenter.SofaPresenter;
import com.example.wangchujie.view.SofaView;

import java.util.ArrayList;

public class VideoFragment extends Fragment implements SofaView {

    private static final String TAG = "VideoFragment";
    private RecyclerView mRec;
    private SofaPresenter sofaPresenter;
    private ArrayList<VideoBean.DataBeanX.DataBean> videoBeans;
    private VideoFragmentAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_img, null);
        initView(view);
        initData();
        return view;
    }


    private void initData() {
        sofaPresenter.getVideo();
    }

    private void initView(View view) {
        sofaPresenter = new SofaPresenter(this);
        mRec = view.findViewById(R.id.img_rec);

        videoBeans = new ArrayList<>();

        mRec.setLayoutManager(new LinearLayoutManager(getContext()));

        mAdapter = new VideoFragmentAdapter(videoBeans,getContext());
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
        videoBeans.addAll(videoBean.getData().getData());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void getText(TextBean textBean) {

    }
}
