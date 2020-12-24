package com.example.day09_01.mvp.mvp.presenter;

import com.example.day09_01.mvp.base.BasePresenter;
import com.example.day09_01.mvp.callback.RxObserverCallBack;
import com.example.day09_01.mvp.mvp.ui.fragment.HomeFragment;
import com.example.day09_01.mvp.mvp.ui.fragment.ThesofaFragment;

import java.io.IOException;

import okhttp3.ResponseBody;

public class ThesofaFrgPresenter extends BasePresenter {
    private ThesofaFragment mThesofaFragment;

    public ThesofaFrgPresenter(ThesofaFragment fragment) {
        this.mThesofaFragment = fragment;
    }


}