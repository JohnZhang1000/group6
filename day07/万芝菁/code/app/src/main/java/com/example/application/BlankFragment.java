package com.example.application;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class BlankFragment extends Fragment {



    private ViewPager pager;
    private TabLayout tab;
    private ArrayList<Grlis.DataBean> dataBeans1;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        pager = view.findViewById(R.id.pager);
        tab = view.findViewById(R.id.tab);
        dataBeans1 = new ArrayList<>();
        initData();
        return view;
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(Aserver.tab)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Aserver.class)
                .getTabean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Grlis>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Grlis value) {
                        List<Grlis.DataBean> data = value.getData();
                        dataBeans1.addAll(data);
                        final ArrayList<Fragment> fragments = new ArrayList<>();

                        for (int i = 0; i <dataBeans1.size() ; i++) {
                            int id = dataBeans1.get(i).getId();
                            fragments.add(new BlankFragment3(id));
                        }
                        pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
                            @NonNull
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
                        for (int i = 0; i <dataBeans1.size() ; i++) {
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


}
