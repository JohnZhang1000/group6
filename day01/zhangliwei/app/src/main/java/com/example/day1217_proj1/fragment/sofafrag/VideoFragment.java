package com.example.day1217_proj1.fragment.sofafrag;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day1217_proj1.Adapter.MyRcyPicAdapter;
import com.example.day1217_proj1.Adapter.MyVideoAdapter;
import com.example.day1217_proj1.ApiService;
import com.example.day1217_proj1.R;
import com.example.day1217_proj1.bean.PicBean;
import com.example.day1217_proj1.bean.VideoBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideoFragment extends Fragment {


    private FragmentActivity activity;
    private RecyclerView rcy_video;
    private ArrayList<VideoBean.DataBeanX.DataBean> list;
    private MyVideoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        ApiService apiService = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);

        //视频解析
        apiService.getDataVideo(12,"video")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideoBean videoBean) {
                        Log.e("TAG","视频解析成功");
                        List<VideoBean.DataBeanX.DataBean> data = videoBean.getData().getData();
                        list.addAll(data);
                        adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG","视频解析失败"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG","视频解析完成");
                    }
                });
    }

    private void initView(View view) {
        rcy_video = view.findViewById(R.id.rcy_video);
        rcy_video.setLayoutManager(new LinearLayoutManager(activity));
        rcy_video.addItemDecoration(new DividerItemDecoration(activity,DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        adapter = new MyVideoAdapter(activity, list);
        rcy_video.setAdapter(adapter);
    }
}