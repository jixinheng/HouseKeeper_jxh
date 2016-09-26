package com.feicui.cn.jxh;

import android.app.Application;
import android.util.Log;

import java.io.IOException;

import util.copyAssetFileToInterSD;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class MyApplication extends Application{
    private static final String TAG = "MyApplication";
    public String telFile;
    @Override
    public void onCreate() {
        super.onCreate();
        try {
           telFile = copyAssetFileToInterSD.copyAssetFileToInterSD(this,"db/commonnum.db","commonnum.db");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "onCreate: failed copy");
        }
    }
}
