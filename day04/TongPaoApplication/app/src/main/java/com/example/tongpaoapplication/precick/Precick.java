package com.example.tongpaoapplication.precick;

import com.example.tongpaoapplication.bean.Fenlei;
import com.example.tongpaoapplication.bean.Remenbean;
import com.example.tongpaoapplication.callback.Callback;
import com.example.tongpaoapplication.iview.IView;
import com.example.tongpaoapplication.moudel.Moudle;

public class Precick {
    private IView iView;
    private final Moudle moudle;

    public Precick(IView iView) {
        this.iView = iView;
        moudle = new Moudle();
    }
    public void poremen(){
        moudle.morremrn(new Callback() {
            @Override
            public void renmen(Remenbean remenbean) {
                iView.renmen(remenbean);
            }

            @Override
            public void fenlei(Fenlei fenlei) {

            }

            @Override
            public void shi(String string) {
                iView.shi(string);

            }
        });
    }
    public void porfenlei(int path){
        moudle.porfen(path,new Callback() {
            @Override
            public void renmen(Remenbean remenbean) {
                iView.renmen(remenbean);
            }

            @Override
            public void fenlei(Fenlei fenlei) {
                iView.fenlei(fenlei);

            }

            @Override
            public void shi(String string) {
                iView.shi(string);

            }
        });
    }
}
