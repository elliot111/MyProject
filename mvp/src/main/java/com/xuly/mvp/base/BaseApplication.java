package com.xuly.mvp.base;

import android.app.Application;

public class BaseApplication extends Application {
    private static BaseApplication myApplication = null;


    public static BaseApplication getInstance(){
        return myApplication;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;



    }



}
