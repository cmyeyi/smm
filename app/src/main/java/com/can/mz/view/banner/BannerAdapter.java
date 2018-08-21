package com.can.mz.view.banner;

import android.widget.ImageView;

import java.util.List;

public abstract class BannerAdapter<T> {
    private List<T> mDataList;

    List<T> getDataList() {
        return mDataList;
    }

    protected BannerAdapter(List<T> dataList) {
        mDataList = dataList;
    }

    void setImageViewSource(ImageView imageView, int position) {
        bindImage(imageView, mDataList.get(position));
    }

    public abstract void bindImage(ImageView imageView, T t);


}
