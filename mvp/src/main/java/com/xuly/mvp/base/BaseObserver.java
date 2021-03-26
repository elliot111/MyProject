package com.xuly.mvp.base;

import android.util.Log;


import com.xuly.mvp.http.RxExceptionUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {
    private static final String TAG = "BaseObserver";
    @Override
    public void onSubscribe(Disposable d) {
        Log.e(TAG, "onSubscribe: " );
    }
    @Override
    public void onNext(BaseResponse<T> response) {
        //在这边对 基础数据 进行统一处理  举个例子：
        if(response.getErrorCode().equals("200")){
            onSuccess(response);
        }else{
            onFailure(null,response.getMsg());
        }


    }
    @Override
    public void onError(Throwable e) {
        onFailure(e, RxExceptionUtil.exceptionHandler(e));
    }

    @Override
    public void onComplete() {
        Log.e(TAG, "onComplete: " );
    }

    public abstract void onSuccess(BaseResponse<T> demo);

    public abstract void onFailure(Throwable e, String errorMsg);
}
