package com.can.mz.view;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.support.v4.widget.CircularProgressDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.can.mz.R;

public class CircleProgressBar extends ViewGroup {
    ProgressCircleImageView mCircleView;
    CircularProgressDrawable mProgress;
    // Default background for the progress spinner
    private static final int CIRCLE_BG_LIGHT = 0xFFFAFAFA;
    private static final int SCALE_DOWN_DURATION = 150;
    private Animation mScaleDownAnimation;
    private int mCircleDiameter;
    @VisibleForTesting
    static final int CIRCLE_DIAMETER = 40;

    public CircleProgressBar(Context context) {
        this(context, null);
    }

    public CircleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        final DisplayMetrics metrics = getResources().getDisplayMetrics();
        mCircleDiameter = (int) (CIRCLE_DIAMETER * metrics.density);
        createProgressView();
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mCircleView.measure(MeasureSpec.makeMeasureSpec(mCircleDiameter, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(mCircleDiameter, MeasureSpec.EXACTLY));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        final int width = getMeasuredWidth();
        final int height = getMeasuredHeight();

        int circleWidth = mCircleView.getMeasuredWidth();
        int circleHeight = mCircleView.getMeasuredHeight();
        mCircleView.layout((width / 2 - circleWidth / 2), (height / 2 - circleHeight / 2), (width / 2 + circleWidth / 2), (height / 2 + circleHeight / 2));
    }

    private void createProgressView() {
        mCircleView = new ProgressCircleImageView(getContext(), CIRCLE_BG_LIGHT);
        mProgress = new CircularProgressDrawable(getContext());
        mProgress.setStyle(CircularProgressDrawable.DEFAULT);
        mProgress.setColorSchemeColors(getResources().getColor(R.color.theme_color));
        mProgress.setAlpha(255);
        mCircleView.setImageDrawable(mProgress);
        addView(mCircleView);
    }

    public void showProgressBar() {
        mProgress.setProgressRotation(10);
        mProgress.start();
    }

    public void hideProgressBar() {
        startScaleDownAnimation();
    }

    public void startScaleDownAnimation() {
        mProgress.stop();
        mScaleDownAnimation = new Animation() {
            @Override
            public void applyTransformation(float interpolatedTime, Transformation t) {
                setAnimationProgress(1 - interpolatedTime);
            }
        };
        mScaleDownAnimation.setDuration(SCALE_DOWN_DURATION);
        mCircleView.clearAnimation();
        mCircleView.startAnimation(mScaleDownAnimation);
    }

    void setAnimationProgress(float progress) {
        mCircleView.setScaleX(progress);
        mCircleView.setScaleY(progress);
    }

}
