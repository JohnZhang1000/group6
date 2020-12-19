package com.example.tongpaoapplication.FRANGMENT;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tongpaoapplication.Aserver;
import com.example.tongpaoapplication.FRANGMENT.dapter.Madapter;
import com.example.tongpaoapplication.R;
import com.example.tongpaoapplication.bean.Fenlei;
import com.example.tongpaoapplication.bean.QianBean;
import com.example.tongpaoapplication.bean.Remenbean;
import com.example.tongpaoapplication.iview.IView;
import com.example.tongpaoapplication.precick.Precick;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class fFaxianBlankFragment extends Fragment implements IView {


    private RecyclerView rv;
    private ArrayList<Remenbean.DataBean> dataBeans;
    private Madapter madapter;
    private TabLayout tab;
    private ViewPager pager;
    private ArrayList<QianBean.DataBean> dataBeans1;

    public fFaxianBlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_f_faxian_blank, container, false);
        rv = view.findViewById(R.id.rv);
        tab = view.findViewById(R.id.tab);
        dataBeans1 = new ArrayList<>();
        pager = view.findViewById(R.id.pager);
        initData();
        initView();
        initTab();
        return view;
}

    private void initTab() {
        new Retrofit.Builder()
                .baseUrl(Aserver.qian)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Aserver.class)
                .getqian()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<QianBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(QianBean value) {
                        List<QianBean.DataBean> data = value.getData();
                        dataBeans1.addAll(data);
                        final ArrayList<Fragment> fragments = new ArrayList<>();
                        for (int i = 0; i <dataBeans1.size() ; i++) {
                            int type = dataBeans1.get(i).getType();
                            fragments.add(new QiantaoBlankFragment(type));
                        }
                        pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
                            @Override
                            public Fragment getItem(int position) {
                                return fragments.get(position);
                            }

                            @Override
                            public int getCount() {
                                return fragments.size();
                            }
                        });
                        tab.setupWithViewPager(pager);
                        for (int i = 0; i < dataBeans1.size(); i++) {
                            tab.getTabAt(i).setText(dataBeans1.get(i).getName());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void initView() {
        Precick precick = new Precick(this);
        precick.poremen();
    }

    private void initData() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        dataBeans = new ArrayList<>();
        madapter = new Madapter(getActivity(),dataBeans);
        rv.setAdapter(madapter);
        
    }

    @Override
    public void renmen(Remenbean remenbean) {
        dataBeans.addAll(remenbean.getData());
        madapter.item(dataBeans);
        madapter.notifyDataSetChanged();
    }

    @Override
    public void fenlei(Fenlei fenlei) {

    }

    @Override
    public void shi(String string) {

    }
}
