package com.example.wanzhijingapplication.precick;

import com.example.wanzhijingapplication.bean.Shipin;
import com.example.wanzhijingapplication.bean.Tu;
import com.example.wanzhijingapplication.bean.WenBen;
import com.example.wanzhijingapplication.bean.WodeBean;
import com.example.wanzhijingapplication.callback.Callback;
import com.example.wanzhijingapplication.iview.IView;
import com.example.wanzhijingapplication.moudle.Moudle;

public class Precick {
    private IView iView;
    private final Moudle moudle;

    public Precick(IView iView) {
        this.iView = iView;
        moudle = new Moudle();
    }
    public void portu(){
        moudle.mortu(new Callback() {
            @Override
            public void tupian(Tu tu) {
                iView.tupian(tu);
            }

            @Override
            public void shipin(Shipin shipin) {

            }

            @Override
            public void wenben(WenBen wenBen) {

            }

            @Override
            public void wode(WodeBean wenBen) {

            }

            @Override
            public void shi(String string) {
                iView.shi(string);

            }
        });
    }
    public void porshipin(){
        moudle.morshipin(new Callback() {
            @Override
            public void tupian(Tu tu) {

            }

            @Override
            public void shipin(Shipin shipin) {
                iView.shipin(shipin);

            }

            @Override
            public void wenben(WenBen wenBen) {

            }

            @Override
            public void wode(WodeBean wenBen) {

            }

            @Override
            public void shi(String string) {
                iView.shi(string);

            }
        });
    }
    public void porwenben(){
        moudle.morwenzi(new Callback() {
            @Override
            public void tupian(Tu tu) {

            }

            @Override
            public void shipin(Shipin shipin) {

            }

            @Override
            public void wenben(WenBen wenBen) {
                iView.wenben(wenBen);

            }

            @Override
            public void wode(WodeBean wenBen) {

            }

            @Override
            public void shi(String string) {
                iView.shi(string);

            }
        });
    }
    public void por(){
        moudle.mor(new Callback() {
            @Override
            public void tupian(Tu tu) {

            }

            @Override
            public void shipin(Shipin shipin) {

            }

            @Override
            public void wenben(WenBen wenBen) {

            }

            @Override
            public void wode(WodeBean wenBen) {
                iView.wode(wenBen);

            }

            @Override
            public void shi(String string) {
                iView.shi(string);

            }
        });
    }
}
