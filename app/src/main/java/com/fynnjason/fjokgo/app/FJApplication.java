package com.fynnjason.fjokgo.app;

import android.app.Application;

import com.lzy.okgo.OkGo;

public class FJApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        OkGo.getInstance().init(this);
    }
}
