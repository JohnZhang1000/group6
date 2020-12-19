package com.example.wangchujie.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wangchujie.R;
import com.example.wangchujie.adapter.TVAdapter;
import com.example.wangchujie.api.ApiService;
import com.example.wangchujie.bean.TabBean;
import com.example.wangchujie.bean.TvBean;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TVFragment extends Fragment {

    private static final String TAG = "TVFragment";
    private final int type;
    private RecyclerView mRec;
    private ArrayList<TvBean.DataBean.ListBean> tvBeans;
    private TVAdapter mAdapter;

    public TVFragment(int type) {
        this.type = type;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv, null);
        initView(view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            initData();
        }
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiService.sUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getData(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<TvBean>() {
                    @Override
                    public void onNext(TvBean tvBean) {
                        tvBeans.addAll(tvBean.getData().getList());
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
        mRec = view.findViewById(R.id.tv_rec);

        tvBeans = new ArrayList<>();

        mRec.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        mRec.setLayoutManager(new LinearLayoutManager(getContext()));

        mAdapter = new TVAdapter(tvBeans,getContext());
        mRec.setAdapter(mAdapter);


    }
}
