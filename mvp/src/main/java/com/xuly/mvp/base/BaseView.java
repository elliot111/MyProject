package com.xuly.mvp.base;

/**
 * View接口类
 */

public interface BaseView<R> {
    //开启加载动画
    void showLoading();

    //隐藏加载动画
    void hideLoading(boolean b);

    //错误信息
    void onError(R result);
}
