package com.xuly.mvp.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xuly.mvp.R;
import com.xuly.mvp.base.BaseActivity;
import com.xuly.mvp.base.BasePresenter;
import com.xuly.mvp.base.BaseResponse;
import com.xuly.mvp.bean.ShishiOrderListBean;
import com.xuly.mvp.contract.PubushiContract;
import com.xuly.mvp.presenter.PubushiPresenter;

import java.util.HashMap;

public class MainActivity extends BaseActivity<PubushiContract.View, PubushiPresenter> implements PubushiContract.View, View.OnClickListener {

    private TextView btn_pubushi;

    @Override
    protected int initLayoutInflater() {
        return R.layout.activity_main;
    }

    @Override
    protected PubushiPresenter createPresenter() {
        return new PubushiPresenter();
    }

    @Override
    protected PubushiContract.View createView() {
        return this;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        btn_pubushi= findViewById(R.id.btn_pubushi);
        btn_pubushi.setOnClickListener(this);

    }

    @Override
    public void initData() {
//        HashMap<String, Object> map_news = new HashMap<>();
//        map_news.put("token", "1615770722349");
//        map_news.put("userId","8be8b65e-efaa-4803-bbba-7bfa1625b581");
//        map_news.put("ddType","1");
//        map_news.put("dbth","0");
//        map_news.put("ddStatus","0");
//        getBasePresenter().getOrderList(MainActivity.this,map_news);
    }

    @Override
    protected void afterRequestPermission(int requestCode, boolean isAllGranted) {

    }

    @Override
    public void getOrderList(BaseResponse<ShishiOrderListBean> data) {
        if(data.getBody()!=null){

        }

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean b) {

    }

    @Override
    public void onError(Object result) {

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_pubushi){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, PubushiAllActivity.class);
            startActivity(intent);
        }
    }
}