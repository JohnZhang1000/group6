package com.example.application.precick;

import com.example.application.Baner;
import com.example.application.LIstBean;
import com.example.application.callback.Callback;
import com.example.application.iview.IView;
import com.example.application.moudle.Moudle;

public class Precick {
    private IView iView;
    private final Moudle moudle;

    public Precick(IView iView) {
        this.iView = iView;
        moudle = new Moudle();
    }
    public void porban(){
        moudle.morbaner(new Callback() {
            @Override
            public void baner(Baner baner) {
                iView.baner(baner);
            }

            @Override
            public void list(LIstBean lIstBean) {
                iView.list(lIstBean);

            }

            @Override
            public void shi(String string) {
                iView.shi(string);

            }
        });
    }
    public void porlist(){
        moudle.morList(new Callback() {
            @Override
            public void baner(Baner baner) {
                iView.baner(baner);
            }

            @Override
            public void list(LIstBean lIstBean) {
                iView.list(lIstBean);

            }

            @Override
            public void shi(String string) {
                iView.shi(string);

            }
        });
    }
}
