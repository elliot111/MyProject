package com.xuly.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.List;

public abstract class BaseLazyFragment<V extends BaseView, P extends BasePresenter<V>> extends RxFragment {
    private static final String TAG = "BaseLazyFragment";
    //引用V层和P层
    private P basePresenter;
    private V view;
    public Context mContext;

    private View rootView;
    private boolean mIsFirstVisible = true;/*当前Fragment是否首次可见，默认是首次可见**/
    private boolean isViewCreated = false;/*当前Fragment的View是否已经创建**/
    private boolean mCurrentVisiableState = false;/*当前Fragment的可见状态，表示当前Fragment是否分发过  可见到不可见  不可见到可见才可以调用**/

    public P getBasePresenter() {
        return basePresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(initLayoutInflater(), container, false);


            mContext = getActivity();
            if (basePresenter == null) {
                basePresenter = createPresenter();
            }
            if (this.view == null) {
                this.view = createView();
            }
            if (basePresenter != null && view != null) {
                basePresenter.onAttachView(this.view);
            }

            initView(rootView);
        }
        //1：创建了Fragment  控制下面分发的前提，因为分发事件由setUserVisibleHint方法控制，而setUserVisibleHint最先执行
        isViewCreated=true;

        //2：对于默认Fragment的加载，可以在此分发一下，可见才分发
        if (getUserVisibleHint()&&!isHidden()){
            //可见
            disPatchVisibaleHint(true);
        }

        return rootView;
    }

    //由子类指定具体类型
    protected abstract int initLayoutInflater();

    protected abstract P createPresenter();

    protected abstract V createView();

    public abstract void initView(View rootView);


    //与生命周期无关的函数
    /**
     * onCreateView在此方法之后  第一次时 mIsViewCreated=false
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        //用户是否可见
        Log.e(TAG,"setUserVisibleHint----"+isVisibleToUser);
        super.setUserVisibleHint(isVisibleToUser);
        /**
         * 1：分发的前提是FragmentView已经创建，因为setUserVisibleHint在fragment 的声明周期之前执行，
         * 如果页面没创建就去分发容易造成空指针异常
         *
         * 2：因为此方法是由setUserVisibleHint方法调用，而setUserVisibleHint方法由系统的Viewpager调用多次，我们没办法控制它，
         *    但是我们可以控制disPatchVisibaleHint的分发
         */
        if (isViewCreated){
            //只有Fragment创建了后才进行分发
            if (isVisibleToUser&& !mCurrentVisiableState){//防止重复调用disPatchVisibaleHint !mCurrentVisiableState表示没有分发过时才分发
                //用户可见时进行分发事件
                disPatchVisibaleHint(true);
            }else if (mCurrentVisiableState&& !isVisibleToUser){
                //用户不可见时不分发事件
                disPatchVisibaleHint(false);
            }
        }
    }

    @Override
    //与生命周期无关的函数
    //在使用`FragmentTransaction`的`hidden` 和`show`方法管理fragment时，是不会走Fragment正常的生命周期，
    // 而是走`onHiddenChanged`方法，此方法可以监听Fragment 的显示与隐藏。
    public void onHiddenChanged(boolean hidden) {
        Log.e(TAG,"onHiddenChanged");
//        FragmentTransaction管理Fragment时
        super.onHiddenChanged(hidden);
        if (hidden){
            disPatchVisibaleHint(false);
        }else {
            disPatchVisibaleHint(true);
        }

    }

    /**
     * 分发可见
     * 调用的前提：可见--》不可见    或者不可见--》可见
     * @param isVisiable
     */
    private void disPatchVisibaleHint(boolean isVisiable) {
        Log.e(TAG,"disPatchVisibaleHint----"+isVisiable);

        if (mCurrentVisiableState==isVisiable){
            //防止调用两次更新，存在当 mCurrentVisiableState=isVisiable;执行前setUserVisibleHint可能被调用两次
            return;
        }
        mCurrentVisiableState=isVisiable;//进行赋值操作
        if (isVisiable){
            //可见
            if (mIsFirstVisible){
                mIsFirstVisible=false;
                onFragmentFirstVisiable();
            }
            onFragmentResume();
            //处理子ViewPager嵌套使用时，子fragment懒加载的实现
            dispatChChildVisiableState(true);
        }else {
            onFragmentPause();
            dispatChChildVisiableState(false);
        }

    }

    @Override
    public void onResume() {
        Log.e(TAG,"onResume");
        //只有当前可见的Fragment  才更新shuju  点击home键又返回
        if (!mCurrentVisiableState&&getUserVisibleHint()&&!isHidden() ){
            disPatchVisibaleHint(true);
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e(TAG,"onPause");
        if (mCurrentVisiableState&&getUserVisibleHint()){
            disPatchVisibaleHint(false );
        }
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //当 View 被销毁的时候我们需要重新设置 isViewCreated mIsFirstVisible 的状态
        isViewCreated = false;
        mIsFirstVisible = true;
        mCurrentVisiableState=false;
        if (basePresenter != null) {
            basePresenter.onDetachView();
        }
    }

    /**
     *  下面抽取三个方法定义成public方法是因为：
     *  父类不知道子类要不要处理可见和不可见，因为子类有可能不需要懒加载，此时子类什么也不需要做
     *  当需要懒加载时，才需要复写这三个方法。
     *  因此这3个方法是非必须实现的方法，不能定义成抽象方法
     */

    /**
     * 第一次可见时特殊处理
     */
    public void onFragmentFirstVisiable() {
        Log.e(TAG,"onFragmentFirstVisiable");

    }

    /**
     * 不可见时处理相关动作  停止数据的加载
     */
    public void onFragmentPause() {
        Log.e(TAG,"onFragmentPause");

    }

    /**
     * 表面可见时  加载数据
     */
    public void onFragmentResume() {
        Log.e(TAG,"onFragmentResume");

    }


    /**
     * ViewPage嵌套使用时处理子的Fragment懒加载逻辑
     *  通过getChildFragmentManager();获取子Fragment
     *  @param visiable
     */
    private void dispatChChildVisiableState(boolean visiable){
        FragmentManager childFragmentManager = getChildFragmentManager();
        List<Fragment> childFragmentManagerFragments = childFragmentManager.getFragments();
        if (childFragmentManagerFragments != null) {
            Log.e(TAG,"dispatChChildVisiableState ===== " + visiable);
            for (Fragment fragment : childFragmentManagerFragments) {
                //进行类型校验，只有继承了LazyFragment才进行懒加载的处理
                if (fragment instanceof BaseLazyFragment&&!fragment.isHidden()&&fragment.getUserVisibleHint()){
                    ((BaseLazyFragment) fragment).disPatchVisibaleHint(visiable);
                }
            }
        }
    }

}
