package com.dmcc.image_preview;


import org.reactivestreams.Subscription;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<T> {
    public T mView;
    protected Subscription mSubscription;
    protected CompositeDisposable mCompositeSubscription;

    public void attachView(T view) {
        this.mView = view;
        if (mCompositeSubscription == null)
            mCompositeSubscription = new CompositeDisposable();
    }


    public void detachView() {
        mCompositeSubscription.dispose();
        mView = null;
    }

}
