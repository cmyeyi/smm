package com.can.mz.base;

import android.os.Handler;


public class TaskTimer {

    public static final int INFINITE = Integer.MAX_VALUE;
    private Handler mHandler;
    private int mCount;
    private int mCurrentCount;
    private Runnable mTask;
    private long mDelayMillis;
    private Runnable mTaskWrapper;

    public TaskTimer() {
        this(INFINITE, new Handler());
    }

    public TaskTimer(int count) {
        this(count, new Handler());
    }

    public TaskTimer(Handler handler) {
        this(INFINITE, handler);
    }

    public TaskTimer(int count, Handler handler) {
        mCount = Math.max(1, count);
        mHandler = handler;
    }

    public boolean isRunning() {
        return mTask != null;
    }

    public int getCount() {
        return mCount;
    }

    public int getCurrentCount() {
        return mCurrentCount;
    }

    public void setDelayMillis(long delayMillis) {
        mDelayMillis = delayMillis;
    }

    public void schedule(Runnable task, long delayMillis) {
        if (task == null) {
            throw new RuntimeException("invalid parameters");
        }

        cancel();

        mTask = task;
        mCurrentCount = 0;
        setDelayMillis(delayMillis);

        if (mTaskWrapper == null) {
            mTaskWrapper = new Runnable() {
                @Override
                public void run() {

                    if (mTask != null) {
                        mTask.run();
                        ++mCurrentCount;
                        if (mCurrentCount < mCount) {
                            mHandler.postDelayed(mTaskWrapper, mDelayMillis);
                        } else {
                            mTask = null;
                        }
                    }
                }
            };
        }
        mHandler.postDelayed(mTaskWrapper, mDelayMillis);
    }

    public void cancel() {
        if (isRunning()) {
            mTask = null;
            mHandler.removeCallbacks(mTaskWrapper);
        }
    }

}
