package com.xuly.mvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle2.components.RxFragment;

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends RxFragment {
    //表示层的引用
    private P basePresenter;
    private V view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(initLayoutInflater(), container, false);
        //将子类创建的presenter 赋值给基类表示层
        basePresenter = createPresenter();
        if (this.view == null) {
            this.view = createView();
        }
        if (basePresenter != null && view != null) {
            basePresenter.onAttachView(this.view);
        }
        initView(view);
        initData();

        return view;

    }

    protected abstract P createPresenter();

    protected abstract V createView();

    protected abstract int initLayoutInflater(); //初始化布局

    public abstract void initView(View view);

    public abstract void initData();

    public P getBasePresenter() {
        return basePresenter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (basePresenter != null)
            //解绑
            basePresenter.onDetachView();
    }
}
