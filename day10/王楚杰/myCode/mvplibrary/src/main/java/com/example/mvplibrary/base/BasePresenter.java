package com.example.mvplibrary.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

//1.链接M层和 V层     2.处理业务逻辑    3.断开网络请求
public class BasePresenter<V extends IBaseView<T>, T> implements IPresenter<T> {
    private WeakReference<V> mView;
    protected CompositeDisposable mComposite =
            new CompositeDisposable();

    //添加网络开关
    protected void addDisposable(Disposable disposable){
        if (mComposite != null){
            mComposite.add(disposable);
        }
    }


    // 1.用弱引用修饰V层 方便GC回收  2.P层关联V层
    protected void attachView(V view) {
        mView = new WeakReference<V>(view);
    }


    //2.释放资源  2.让P层断开网络请求
    protected void detachView() {
        //TODO 释放资源
        if (mView != null) {
            mView.clear();
            mView = null;
        }
        //TODO 断开网络请求
        deleteDisposable();
    }

    //断开网络开关
    private void deleteDisposable() {
        if (mComposite != null && !mComposite.isDisposed()) {
            mComposite.dispose();
            mComposite.clear();
            mComposite = null;
        }
    }



    @Override
    public void start() {
        //TODO 处理业务逻辑

    }

    @Override
    public void start(T... t) {
        //TODO 处理业务逻辑

    }

}