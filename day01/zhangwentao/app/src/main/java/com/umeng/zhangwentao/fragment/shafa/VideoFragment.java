package com.umeng.zhangwentao.fragment.shafa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.umeng.zhangwentao.R;
import com.umeng.zhangwentao.adapter.VideoRcyAdapter;
import com.umeng.zhangwentao.api.ApiService;
import com.umeng.zhangwentao.fragment.shafa.databean.ShaFaVideoDataBean;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideoFragment extends Fragment {


    private RecyclerView videoRcy;
    private VideoRcyAdapter videoRcyAdapter;
    private ArrayList<ShaFaVideoDataBean.DataBeanX.DataBean> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        initView(view);
        inintData();
        return view;
    }

    private void inintData() {
        new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getShaFaVideo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShaFaVideoDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShaFaVideoDataBean shaFaVideoDataBean) {
                        list.addAll(shaFaVideoDataBean.getData().getData());
                        videoRcyAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View itemview) {
        videoRcy = itemview.findViewById(R.id.video_rcy);
        videoRcy.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        videoRcyAdapter = new VideoRcyAdapter(getContext(),list);
        videoRcy.setAdapter(videoRcyAdapter);

    }
}