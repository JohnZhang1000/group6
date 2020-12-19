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
import com.example.day1217_proj1.Adapter.MyTextAdapter;
import com.example.day1217_proj1.ApiService;
import com.example.day1217_proj1.R;
import com.example.day1217_proj1.bean.TextBean;
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

public class TextFragment extends Fragment {

    private FragmentActivity activity;
    private RecyclerView rcy_text;
    private ArrayList<TextBean.DataBeanX.DataBean> list;
    private MyTextAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text, container, false);
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
        apiService.getDataText(10,"text",1578920275)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TextBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TextBean textBean) {
                        Log.e("TAG","文字解析成功");
                        List<TextBean.DataBeanX.DataBean> data = textBean.getData().getData();
                        list.addAll(data);
                        adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG","文字解析失败"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG","文字解析完成");
                    }
                });
    }

    private void initView(View view) {
        rcy_text = view.findViewById(R.id.rcy_text);
        rcy_text.setLayoutManager(new LinearLayoutManager(activity));
        rcy_text.addItemDecoration(new DividerItemDecoration(activity,DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        adapter = new MyTextAdapter(activity, list);
        rcy_text.setAdapter(adapter);

    }
}