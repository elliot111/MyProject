package com.xuly.mvp.contract;

import android.content.Context;

import com.xuly.mvp.base.BasePresenter;
import com.xuly.mvp.base.BaseResponse;
import com.xuly.mvp.base.BaseView;
import com.xuly.mvp.bean.ShishiOrderListBean;

import java.util.HashMap;

public interface PubushiContract {
    interface View extends BaseView {

        void getOrderList(BaseResponse<ShishiOrderListBean> data);


    }

    abstract class Presenter extends BasePresenter<View> {

        public abstract void getOrderList(Context context, HashMap<String, Object> map);
    }
}
