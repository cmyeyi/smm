package com.can.mz.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.can.mz.R;

public class ImageLoadUtils {
    public static void bindImage(Context context, ImageView imageView, String url) {
        Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.image_default).crossFade().into(imageView);
    }
}
