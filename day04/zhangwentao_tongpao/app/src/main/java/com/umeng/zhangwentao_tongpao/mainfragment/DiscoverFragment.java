package com.umeng.zhangwentao_tongpao.mainfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.tabs.TabLayout;
import com.umeng.zhangwentao_tongpao.R;
import com.umeng.zhangwentao_tongpao.adapter.FaXianRcyAdapter;
import com.umeng.zhangwentao_tongpao.api.ApiSevercer;
import com.umeng.zhangwentao_tongpao.databean.HotDatabean;
import com.umeng.zhangwentao_tongpao.tiaozhuan.PaiHangActivity;
import com.umeng.zhangwentao_tongpao.tiaozhuan.PaoZIActivity;
import com.umeng.zhangwentao_tongpao.tiaozhuan.SheTuanActivity;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiscoverFragment extends Fragment {

    private LinearLayout ll;
    private ImageView ivPaozi;
    private ImageView ivShetuan;
    private ImageView ivPaihang;
    private LinearLayout lll;
    private TextView rmhd;
    private TextView gdhd;
    private RecyclerView faxianRcy;
    private TabLayout faxianTab;
    private ViewPager faxianVp;
    private ArrayList<HotDatabean.DataBean> hotlist;
    private FaXianRcyAdapter faXianRcyAdapter;
    private Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        initView(view);
        inintData();
        return view;
    }

    private void inintData() {
        new Retrofit.Builder()
                .baseUrl(ApiSevercer.BACE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiSevercer.class)
                .getHot()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotDatabean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotDatabean hotDatabean) {
                        hotlist.addAll(hotDatabean.getData());
                        faXianRcyAdapter.notifyDataSetChanged();

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

        rmhd = view.findViewById(R.id.rmhd);
        gdhd = view.findViewById(R.id.gdhd);

        faxianRcy = view.findViewById(R.id.faxian_rcy);
        hotlist = new ArrayList<>();
        faxianRcy.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        faXianRcyAdapter = new FaXianRcyAdapter(getContext(), hotlist);
        faxianRcy.setAdapter(faXianRcyAdapter);

        inintTab(view);
        inintclick(view);
    }

    private void inintclick(View view) {

        ivPaozi = view.findViewById(R.id.iv_paozi);
        ivShetuan = view.findViewById(R.id.iv_shetuan);
        ivPaihang = view.findViewById(R.id.iv_paihang);

        Glide.with(getActivity()).load(R.drawable.a).apply(new RequestOptions().circleCrop()).into(ivPaozi);
        Glide.with(getActivity()).load(R.drawable.b).apply(new RequestOptions().circleCrop()).into(ivShetuan);
        Glide.with(getActivity()).load(R.drawable.d).apply(new RequestOptions().circleCrop()).into(ivPaihang);

        ivPaozi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), PaoZIActivity.class);
                startActivity(intent);
            }
        });
        ivShetuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), SheTuanActivity.class);
                startActivity(intent);
            }
        });
        ivPaihang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), PaiHangActivity.class);
                startActivity(intent);
            }
        });

    }

    private void inintTab(View view) {
        faxianTab = view.findViewById(R.id.faxian_tab);
        faxianVp = view.findViewById(R.id.faxian_vp);
    }

    public static
    class ViewHolder {
        public View rootView;
        public ImageView iv_paozi;
        public ImageView iv_shetuan;
        public ImageView iv_paihang;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_paozi = (ImageView) rootView.findViewById(R.id.iv_paozi);
            this.iv_shetuan = (ImageView) rootView.findViewById(R.id.iv_shetuan);
            this.iv_paihang = (ImageView) rootView.findViewById(R.id.iv_paihang);
        }

    }
}