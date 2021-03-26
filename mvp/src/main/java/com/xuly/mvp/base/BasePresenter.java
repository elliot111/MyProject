package com.xuly.mvp.base;

import java.lang.ref.WeakReference;

public class BasePresenter<V> {
    protected WeakReference<V> mTWeakReference;

    //进行绑定
    public void onAttachView(V view) {
        mTWeakReference = new WeakReference<V>(view);
    }

    //进行解绑
    public void onDetachView() {
        if (mTWeakReference != null)
            mTWeakReference.clear();
    }

    protected V getView() {
        return mTWeakReference.get();
    }

    public boolean isViewAttached() {
        return mTWeakReference != null && mTWeakReference.get() != null;
    }
}
