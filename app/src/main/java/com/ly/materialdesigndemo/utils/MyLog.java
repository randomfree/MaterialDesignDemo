package com.ly.materialdesigndemo.utils;

import android.util.Log;

import com.ly.materialdesigndemo.BuildConfig;

/**
 * Created by LY on 2017/6/29.
 */

public class MyLog {




    public static void e(String TAG,String message){
        if (BuildConfig.LOG_DEBUG){
            Log.e(TAG,message);
        }
    }

}
