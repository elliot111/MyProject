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

public class PubushiAllActivity extends BaseActivity implements View.OnClickListener {

    private TextView btn_StaggeredGridLayoutManager;
    private TextView btn_GridLayoutManager;
    private TextView btn_FlexboxLayoutManager;

    @Override
    protected int initLayoutInflater() {
        return R.layout.activity_pubushi_all;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected Object createView() {
        return null;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        btn_StaggeredGridLayoutManager= findViewById(R.id.btn_StaggeredGridLayoutManager);
        btn_StaggeredGridLayoutManager.setOnClickListener(this);
        btn_GridLayoutManager= findViewById(R.id.btn_GridLayoutManager);
        btn_GridLayoutManager.setOnClickListener(this);
        btn_FlexboxLayoutManager= findViewById(R.id.btn_FlexboxLayoutManager);
        btn_FlexboxLayoutManager.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    protected void afterRequestPermission(int requestCode, boolean isAllGranted) {

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_StaggeredGridLayoutManager){
            Intent intent = new Intent();
            intent.setClass(PubushiAllActivity.this, StaggeredGridLayoutManagerActivity.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.btn_GridLayoutManager){
            Intent intent = new Intent();
            intent.setClass(PubushiAllActivity.this, GridViewManagerActivity.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.btn_FlexboxLayoutManager){
            Intent intent = new Intent();
            intent.setClass(PubushiAllActivity.this, FlexboxLayoutManagerActivity.class);
            startActivity(intent);
        }
    }
}