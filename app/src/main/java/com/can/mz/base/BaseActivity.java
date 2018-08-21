package com.can.mz.base;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import com.can.mz.R;
import com.can.mz.view.CircleProgressBar;

public class BaseActivity extends AppCompatActivity {
    public static final int STATUS_SUCCESS = 1;
    public CircleProgressBar mCircleProgressBar;

//    @VisibleForTesting
//    public ProgressDialog mProgressDialog;
//
//    public void showProgressDialog() {
//        if (mProgressDialog == null) {
//            mProgressDialog = new ProgressDialog(this);
//            mProgressDialog.setMessage(getString(R.string.loading));
//            mProgressDialog.setIndeterminate(true);
//        }
//
//        mProgressDialog.show();
//    }
//
//    public void hideProgressDialog() {
//        if (mProgressDialog != null && mProgressDialog.isShowing()) {
//            mProgressDialog.dismiss();
//        }
//    }

    public void showProgressDialog() {
        if (mCircleProgressBar != null) {
            mCircleProgressBar.setVisibility(View.VISIBLE);
            mCircleProgressBar.showProgressBar();
        }
    }

    public void hideProgressDialog() {
        if (mCircleProgressBar != null) {
            mCircleProgressBar.hideProgressBar();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }

    public void setupBackAsUp(String title, boolean isHasBackIcon) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //为标题栏设置标题，即给ActionBar设置标题。
            actionBar.setTitle(title);
            actionBar.setHomeAsUpIndicator(R.drawable.arrow_back_white);
            //ActionBar加一个返回图标
            actionBar.setDisplayHomeAsUpEnabled(isHasBackIcon);
            //不显示当前程序的图标。
            actionBar.setDisplayShowHomeEnabled(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            //点击HOME ICON finish当前Activity
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void toGooglePlay(String url) {
        if(!TextUtils.isEmpty(url)) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            } catch (android.content.ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        }
    }

}
