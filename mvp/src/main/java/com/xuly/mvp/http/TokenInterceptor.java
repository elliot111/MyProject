package com.xuly.mvp.http;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();//获取原始请求
        Request.Builder requestBuilder = originalRequest.newBuilder() //建立新的请求
//                .addHeader("Accept", "application/json")
//                .addHeader("Content-Type", "application/json; charset=utf-8")
                .method(originalRequest.method(),originalRequest.body());
//                Log.e("----------------",originalRequest.body().toString());
        Request tokenRequest = null; //带有token的请求

//        tokenRequest = requestBuilder
//                .header("token",SharedPreferenceUtil.getInstance(BaseApplication.getInstance()).getString("token"))
//                .build();
        return chain.proceed(tokenRequest);
    }
}
