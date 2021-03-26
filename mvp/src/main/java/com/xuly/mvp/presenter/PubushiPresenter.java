package com.xuly.mvp.presenter;

import android.content.Context;

import com.xuly.mvp.base.BaseResponse;
import com.xuly.mvp.base.MyObserver;
import com.xuly.mvp.bean.ShishiOrderListBean;
import com.xuly.mvp.contract.PubushiContract;
import com.xuly.mvp.http.RetrofitUtils;
import com.xuly.mvp.http.RxHelper;

import java.util.HashMap;

public class PubushiPresenter extends PubushiContract.Presenter {
    @Override
    public void getOrderList(Context context, HashMap<String, Object> map) {
        if (isViewAttached()) {
            RetrofitUtils.getApiUrl()
                    .getDingdanList(map).compose(RxHelper.observableIO2Main(context))
                    .subscribe(new MyObserver<ShishiOrderListBean>(context) {
                        @Override
                        public void onSuccess(BaseResponse<ShishiOrderListBean> result) {
//                tv_retrofit.setText(result.toString());
                            getView().getOrderList(result);
                        }

                        @Override
                        public void onFailure(Throwable e, String errorMsg) {
//                tv_retrofit.setText(errorMsg);
//                        Log.e("mainerror",e.getMessage());
                            getView().onError(errorMsg);
                        }
                    });
        }
    }
}
