package com.xuly.mvp.http;



import com.xuly.mvp.base.BaseResponse;
import com.xuly.mvp.bean.ShishiOrderListBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiUrl {

    @POST(Constans.getSsDingdanList)
    Observable<BaseResponse<ShishiOrderListBean>> getSsDingdanList(@Body Map<String, Object> json);//查询实时订单列表

    @POST(Constans.getDingdanList)
    Observable<BaseResponse<ShishiOrderListBean>> getDingdanList(@Body Map<String, Object> json);//查询订单列表
}
