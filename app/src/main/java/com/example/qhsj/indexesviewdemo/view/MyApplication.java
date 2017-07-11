package com.example.qhsj.indexesviewdemo.view;

import android.app.Application;
import android.content.Context;

/**
 * Created by Chris on 2017/7/11.
 */
public class MyApplication extends Application{

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
