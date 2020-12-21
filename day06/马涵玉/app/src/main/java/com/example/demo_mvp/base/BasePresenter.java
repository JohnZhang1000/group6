package com.example.demo_mvp.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IBaseView<T>,T>implements IPresenter<T> {
   private WeakReference<V> mView;
    protected CompositeDisposable mCompositeDisposable=new CompositeDisposable();
    // 1.用弱引用修饰V层 方便GC回收  2.P层关联V层
   protected void attachView(V view){
      mView= new WeakReference<V>(view);
   }
protected  void addDisposable(Disposable disposable){
       if(mCompositeDisposable!=null){
          mCompositeDisposable.add(disposable);
       }
}
     protected  void detachView(){
       if(mView!=null){
           mView.clear();
           mView=null;
       }
         disposable();
     }

    private void disposable() {
       if(mCompositeDisposable!=null&&!mCompositeDisposable.isDisposed()){
      mCompositeDisposable.isDisposed();
      mCompositeDisposable.clear();
      mCompositeDisposable=null;
       }
    }

    @Override
    public void start() {
//处理业务逻辑
    }

    @Override
    public void start(T... t) {
//处理业务逻辑
    }
}
