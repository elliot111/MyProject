package com.xuly.mvp.base;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.List;

public abstract class BaseActivity<V,P extends BasePresenter<V>> extends RxAppCompatActivity {
    public static Context mContext;
    private P basePresenter;
    private V view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);
        super.onCreate(savedInstanceState);
        setContentView(initLayoutInflater());

//        CacheActivity.addActivity(this);
        // 清除已存在的 Fragment 防止因没有复用导致叠加显示
        clearAllFragmentExistBeforeCreate();

        mContext = this;
        if (basePresenter == null) {
            basePresenter = createPresenter();
        }
        if (this.view == null) {
            this.view = createView();
        }
        if (basePresenter != null && view != null) {
            //调用封装的BasePresent方法
            basePresenter.onAttachView(this.view);
        }
        initView(savedInstanceState);
        initData();

    }

    protected abstract int initLayoutInflater(); //初始化布局

    protected abstract P createPresenter();

    protected abstract V createView();

    public abstract void initView(@Nullable Bundle savedInstanceState);

    public abstract void initData();

    public P getBasePresenter() {
        //返回基类的Present
        return basePresenter;
    }

    /**
     * 清除所有已存在的 Fragment 防止因重建 Activity 时，前 Fragment 没有销毁和重新复用导致界面重复显示
     * 如果有自己实现 Fragment 的复用，请复写此方法并不实现内容
     */
    public void clearAllFragmentExistBeforeCreate() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments.size() == 0)
            return;

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : fragments) {
            fragmentTransaction.remove(fragment);
        }
        fragmentTransaction.commitNow();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (basePresenter != null)
            //解绑
            basePresenter.onDetachView();

    }


    /**
     * 权限检查
     *
     * @param neededPermissions 需要的权限
     * @return 是否全部被允许
     */
    protected boolean checkPermissions(String[] neededPermissions) {
        if (neededPermissions == null || neededPermissions.length == 0) {
            return true;
        }
        boolean allGranted = true;
        for (String neededPermission : neededPermissions) {
            allGranted &= ContextCompat.checkSelfPermission(this, neededPermission) == PackageManager.PERMISSION_GRANTED;
        }
        return allGranted;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean isAllGranted = true;
        for (int grantResult : grantResults) {
            isAllGranted &= (grantResult == PackageManager.PERMISSION_GRANTED);
        }
        afterRequestPermission(requestCode, isAllGranted);
    }

    /**
     * 请求权限的回调
     *
     * @param requestCode  请求码
     * @param isAllGranted 是否全部被同意
     */
    protected abstract void afterRequestPermission(int requestCode, boolean isAllGranted);

    protected void showToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

}
