package com.can.mz.utils;

import android.text.TextUtils;
import android.util.Log;

import com.can.mz.BuildConfig;

public class LogUtils {

    private static final String TAG = "LogUtils";

    public static void log(String format, Object... args) {
        if (TextUtils.isEmpty(format)) {
            return;
        }
        if(BuildConfig.DEBUG){
            try{
                Log.i(TAG, String.format(format, args));
            }catch ( Exception e){}
        }
    }

    public static void log(String tag, String format, Object... args) {
        if (TextUtils.isEmpty(format)) {
            return;
        }

        if (BuildConfig.DEBUG) {
            try{
                String message = String.format(format, args);
                Log.i(TAG, String.format("[%s] %s", tag, message));
            }catch (Exception e){}
        }

    }

    public static void log(String tag, String format) {
        if (TextUtils.isEmpty(format)) {
            return;
        }

        if (BuildConfig.DEBUG) {
            Log.i(tag, format);
        }

    }

}
