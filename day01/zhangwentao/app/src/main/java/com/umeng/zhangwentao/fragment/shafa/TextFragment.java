package com.umeng.zhangwentao.fragment.shafa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.umeng.zhangwentao.R;
import com.umeng.zhangwentao.adapter.TextRcyAdapter;
import com.umeng.zhangwentao.api.ApiService;
import com.umeng.zhangwentao.fragment.shafa.databean.ShaFaTextDataBean;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TextFragment extends Fragment {


    private RecyclerView txtRcy;
    private ArrayList<ShaFaTextDataBean.DataBeanX.DataBean> dataBeans;
    private TextRcyAdapter textRcyAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
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
                .getShaFaText()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShaFaTextDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShaFaTextDataBean shaFaTextDataBean) {
                        dataBeans.addAll(shaFaTextDataBean.getData().getData());
                        textRcyAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        txtRcy = view.findViewById(R.id.txt_rcy);
        txtRcy.setLayoutManager(new LinearLayoutManager(getContext()));
        dataBeans = new ArrayList<>();
        textRcyAdapter = new TextRcyAdapter(getContext(),dataBeans);
        txtRcy.setAdapter(textRcyAdapter);
    }
}