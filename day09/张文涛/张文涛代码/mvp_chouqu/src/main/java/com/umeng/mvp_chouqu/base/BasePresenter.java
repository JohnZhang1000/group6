package com.umeng.mvp_chouqu.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 项目名:zhangwentao_tongpao
 * 包名:com.umeng.mvp_chouqu.base
 * 创建者: 张文涛
 * 创建时间: 2020/12/21
 */
//1.连接M层和V层     2.处理业务逻辑       3.添加和断开网络请求开关
public class BasePresenter<V extends IBaseView<T>, T> implements IPresenter<T> {

    private WeakReference<V> mView;
    private CompositeDisposable mComposite
            = new CompositeDisposable();


    //添加网络开关

    protected void addDisposable(Disposable disposable) {
        if (mComposite != null)
            mComposite.add(disposable);
    }

    //1.用弱引用 用修饰V层  方便GC  回收  2.P层关联V层

    protected void attachView(V view) {
        mView = new WeakReference<V>(view);
    }

    //2.释放V层资源的同时断开网络开关
    protected void detachView() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }
        deleteDisposable();
    }
    //断开网络开关
    private void deleteDisposable() {
        if (mComposite != null && mComposite.isDisposed()) {
            mComposite.dispose();
            mComposite.clear();
            mComposite = null;
        }
    }

    @Override
    public void start() {
        //处理业务逻辑
    }

    @Override
    public void start(T... t) {
      //  处理业务逻辑
    }
}
