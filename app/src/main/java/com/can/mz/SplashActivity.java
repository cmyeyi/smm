package com.can.mz;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashActivity extends Activity {

    private LinearLayout mSplashView;
    private TextView mAppName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        mSplashView = (LinearLayout) findViewById(R.id.splash_root_rl);
        mSplashView.setVisibility(View.VISIBLE);
        showSplashView();
    }

    private void showSplashView() {
        if (null != mSplashView) {
            mSplashView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    hideSplashView();
                    launchHomepage();
                }
            }, 500);

        }
    }

    private void hideSplashView() {
        if (null != mSplashView) {
            mSplashView.setVisibility(View.GONE);
        }
    }

    private void launchHomepage() {
        MainActivity.launch(SplashActivity.this);
        finish();
    }

    /**
     * 返回当前程序版本名
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }

}
