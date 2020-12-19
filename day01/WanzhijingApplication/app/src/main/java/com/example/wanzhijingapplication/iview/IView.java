package com.example.wanzhijingapplication.iview;

import com.example.wanzhijingapplication.bean.Shipin;
import com.example.wanzhijingapplication.bean.Tu;
import com.example.wanzhijingapplication.bean.WenBen;
import com.example.wanzhijingapplication.bean.WodeBean;

public interface IView {
    void tupian(Tu tu);
    void shipin(Shipin shipin);
    void wenben(WenBen wenBen);
    void wode(WodeBean wenBen);
    void shi(String string);
}
