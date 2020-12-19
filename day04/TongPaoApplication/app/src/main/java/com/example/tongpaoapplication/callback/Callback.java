package com.example.tongpaoapplication.callback;

import com.example.tongpaoapplication.bean.Fenlei;
import com.example.tongpaoapplication.bean.Remenbean;

public interface Callback {
    void renmen(Remenbean remenbean);
    void fenlei(Fenlei fenlei);
    void shi(String string);
}
