package com.example.day1218_04tongpao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.day1218_04tongpao.R;
import com.example.day1218_04tongpao.adapter.MyFragAdapter;
import com.example.day1218_04tongpao.adapter.MyRcyHorAdapter;
import com.example.day1218_04tongpao.bean.ActivityBean;
import com.example.day1218_04tongpao.fragment.fragcenter.HotFragment;
import com.example.day1218_04tongpao.fragment.fragcenter.MakeFragment;
import com.example.day1218_04tongpao.fragment.fragcenter.PicFragment;
import com.example.day1218_04tongpao.fragment.fragcenter.WikiFragment;
import com.example.day1218_04tongpao.presenter.MyPresenter;
import com.example.day1218_04tongpao.threeactivity.ClothActivity;
import com.example.day1218_04tongpao.threeactivity.CommunityActivity;
import com.example.day1218_04tongpao.threeactivity.RankingActivity;
import com.example.day1218_04tongpao.view.IView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FindFragment extends Fragment implements View.OnClickListener, IView {


    private TextView tv_cloth;
    private TextView tv_community;
    private TextView tv_ranking;
    private RecyclerView rcy_hor;
    private TabLayout tab_center;
    private ViewPager vp_center;
    private FragmentActivity activity;
    private ArrayList<ActivityBean.DataBean> list;
    private MyRcyHorAdapter adapter;
    private MyPresenter myPresenter;
    private ImageView iv_head1;
    private ImageView iv_head2;
    private ImageView iv_head3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        myPresenter = new MyPresenter(this);
        myPresenter.getData();

    }

    private void initView(View view) {
        iv_head1 = view.findViewById(R.id.iv_head1);
        iv_head1.setOnClickListener(this);
        iv_head2 = view.findViewById(R.id.iv_head2);
        iv_head2.setOnClickListener(this);
        iv_head3 = view.findViewById(R.id.iv_head3);
        iv_head3.setOnClickListener(this);
        Glide.with(activity).load(R.drawable.a1)
                .apply(new RequestOptions().circleCrop())
                .into(iv_head1);
        Glide.with(activity).load(R.drawable.a2)
                .apply(new RequestOptions().transform(new RoundedCorners(100)))
                .into(iv_head2);
        Glide.with(activity).load(R.drawable.a3)
                .apply(new RequestOptions().circleCrop())
                .into(iv_head3);

        tv_cloth = view.findViewById(R.id.tv_cloth);
        tv_cloth.setOnClickListener(this);
        tv_community = view.findViewById(R.id.tv_community);
        tv_community.setOnClickListener(this);
        tv_ranking = view.findViewById(R.id.tv_ranking);
        tv_ranking.setOnClickListener(this);
        //-------------------------------------------------
        rcy_hor = view.findViewById(R.id.rcy_hor);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rcy_hor.setLayoutManager(manager);
        list = new ArrayList<>();
        adapter = new MyRcyHorAdapter(activity, list);
        rcy_hor.setAdapter(adapter);
        //---------------------------------------------------
        tab_center = view.findViewById(R.id.tab_center);
        vp_center = view.findViewById(R.id.vp_center);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HotFragment());
        fragments.add(new MakeFragment());
        fragments.add(new PicFragment());
        fragments.add(new WikiFragment());
        MyFragAdapter fragAdapter = new MyFragAdapter(getChildFragmentManager(), fragments);
        vp_center.setAdapter(fragAdapter);
        tab_center.setupWithViewPager(vp_center);
        tab_center.getTabAt(0).setText("热点");
        tab_center.getTabAt(1).setText("妆造");
        tab_center.getTabAt(2).setText("图赏");
        tab_center.getTabAt(3).setText("百科");


    }

    @Override
    public void getSuccessUi(Object obj) {
        if (obj instanceof ActivityBean) {
            ActivityBean bean = (ActivityBean) obj;
            List<ActivityBean.DataBean> data = bean.getData();
            list.addAll(data);
            adapter.notifyDataSetChanged();
            Log.e("TAG", "传输成功");
        }

    }

    @Override
    public void getFailUi(String msg) {
        Log.e("TAG", "传输失败" + msg);

    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cloth:
                startActivity(new Intent(activity, ClothActivity.class));
                break;
            case R.id.tv_community:
                startActivity(new Intent(activity, CommunityActivity.class));
                break;
            case R.id.tv_ranking:
                startActivity(new Intent(activity, RankingActivity.class));
                break;
            case R.id.iv_head1:
                startActivity(new Intent(activity, ClothActivity.class));
                break;
            case R.id.iv_head2:
                startActivity(new Intent(activity, CommunityActivity.class));
                break;
            case R.id.iv_head3:
                startActivity(new Intent(activity, RankingActivity.class));
                break;

        }

    }


}