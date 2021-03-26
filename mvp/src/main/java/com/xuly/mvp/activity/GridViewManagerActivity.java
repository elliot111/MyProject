package com.xuly.mvp.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Paint;
import android.os.Bundle;

import com.xuly.mvp.R;
import com.xuly.mvp.adapter.PubushiAdapter;
import com.xuly.mvp.base.BaseActivity;
import com.xuly.mvp.base.BasePresenter;
import com.xuly.mvp.bean.ShishiOrderListBean;

import java.util.ArrayList;
import java.util.List;

public class GridViewManagerActivity extends BaseActivity {

    private RecyclerView rv_list;
    private Paint mSearchHistoryPaint;
    private List<ShishiOrderListBean.ListBean> list=new ArrayList<>();
    private PubushiAdapter adapter;

    @Override
    protected int initLayoutInflater() {
        return R.layout.activity_grid_view_manager;
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
        rv_list= findViewById(R.id.rv_list);

        initShuju();

        mSearchHistoryPaint = new Paint();//画笔用来计算文字的宽度
        //设置文字的大小，注意布局文件里写的是sp，这里需要进行转换成对应的px，我这里就不写了
//        mSearchHistoryPaint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14f, getResources().getDisplayMetrics()));
        mSearchHistoryPaint.setTextSize(getResources().getDimensionPixelOffset(R.dimen.mtrl_tooltip_arrowSize));

        final int width = getWindowManager().getDefaultDisplay().getWidth();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(GridViewManagerActivity.this, width);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                float itemMarginAndPadding =getResources().getDimensionPixelOffset(R.dimen.dimen_dp_12);
//                float itemMarginAndPadding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15f, getResources().getDisplayMetrics());
                //就是这里 需要测量文字的宽度，加上左右内边距
                int textWidth = (int)((itemMarginAndPadding*2)+mSearchHistoryPaint.measureText(list.get(position).getDlName())) ;
                //如果文字的宽度超过屏幕的宽度，那么我们就设置为屏幕宽度
                return textWidth > width ? width : textWidth;
            }

        });

        rv_list.setLayoutManager(gridLayoutManager);
        adapter = new PubushiAdapter(GridViewManagerActivity.this,list);
        rv_list.setAdapter(adapter);
    }

    @Override
    public void initData() {

    }

    private void initShuju(){


        ShishiOrderListBean.ListBean listBean1=new ShishiOrderListBean.ListBean();
        listBean1.setDlName("12");
        listBean1.setId("1");
        list.add(listBean1);
        ShishiOrderListBean.ListBean listBean2=new ShishiOrderListBean.ListBean();
        listBean2.setDlName("1232");
        listBean2.setId("2");
        list.add(listBean2);
        ShishiOrderListBean.ListBean listBean3=new ShishiOrderListBean.ListBean();
        listBean3.setDlName("1234");
        listBean3.setId("3");
        list.add(listBean3);
        ShishiOrderListBean.ListBean listBean4=new ShishiOrderListBean.ListBean();
        listBean4.setDlName("1234564");
        listBean4.setId("4");
        list.add(listBean4);
        ShishiOrderListBean.ListBean listBean5=new ShishiOrderListBean.ListBean();
        listBean5.setDlName("1234565");
        listBean5.setId("5");
        list.add(listBean5);
        ShishiOrderListBean.ListBean listBean6=new ShishiOrderListBean.ListBean();
        listBean6.setDlName("1234566");
        listBean6.setId("6");
        list.add(listBean6);
        ShishiOrderListBean.ListBean listBean7=new ShishiOrderListBean.ListBean();
        listBean7.setDlName("1234567");
        listBean7.setId("7");
        list.add(listBean7);
        ShishiOrderListBean.ListBean listBean8=new ShishiOrderListBean.ListBean();
        listBean8.setDlName("1234568");
        listBean8.setId("8");
        list.add(listBean8);
        ShishiOrderListBean.ListBean listBean9=new ShishiOrderListBean.ListBean();
        listBean9.setDlName("1234569");
        listBean9.setId("9");
        list.add(listBean9);
        ShishiOrderListBean.ListBean listBean10=new ShishiOrderListBean.ListBean();
        listBean10.setDlName("1");
        listBean10.setId("10");
        list.add(listBean10);
        ShishiOrderListBean.ListBean listBean11=new ShishiOrderListBean.ListBean();
        listBean11.setDlName("12345611");
        listBean11.setId("11");
        list.add(listBean11);
        ShishiOrderListBean.ListBean listBean12=new ShishiOrderListBean.ListBean();
        listBean12.setDlName("12345612");
        listBean12.setId("12");
        list.add(listBean12);


        ShishiOrderListBean.ListBean listBean13=new ShishiOrderListBean.ListBean();
        listBean13.setDlName("12345613");
        listBean13.setId("13");
        list.add(listBean13);
        ShishiOrderListBean.ListBean listBean14=new ShishiOrderListBean.ListBean();
        listBean14.setDlName("12345614");
        listBean14.setId("14");
        list.add(listBean14);
        ShishiOrderListBean.ListBean listBean15=new ShishiOrderListBean.ListBean();
        listBean15.setDlName("12345615");
        listBean15.setId("15");
        list.add(listBean15);
        ShishiOrderListBean.ListBean listBean16=new ShishiOrderListBean.ListBean();
        listBean16.setDlName("12345616");
        listBean16.setId("16");
        list.add(listBean16);
        ShishiOrderListBean.ListBean listBean17=new ShishiOrderListBean.ListBean();
        listBean17.setDlName("12345617");
        listBean17.setId("17");
        list.add(listBean17);
        ShishiOrderListBean.ListBean listBean18=new ShishiOrderListBean.ListBean();
        listBean18.setDlName("12345618");
        listBean18.setId("18");
        list.add(listBean18);
        ShishiOrderListBean.ListBean listBean19=new ShishiOrderListBean.ListBean();
        listBean19.setDlName("12345619");
        listBean19.setId("19");
        list.add(listBean19);
        ShishiOrderListBean.ListBean listBean20=new ShishiOrderListBean.ListBean();
        listBean20.setDlName("12345620");
        listBean20.setId("20");
        list.add(listBean20);
        ShishiOrderListBean.ListBean listBean21=new ShishiOrderListBean.ListBean();
        listBean21.setDlName("12345621");
        listBean21.setId("21");
        list.add(listBean21);
        ShishiOrderListBean.ListBean listBean22=new ShishiOrderListBean.ListBean();
        listBean22.setDlName("12345622");
        listBean22.setId("22");
        list.add(listBean22);
        ShishiOrderListBean.ListBean listBean23=new ShishiOrderListBean.ListBean();
        listBean23.setDlName("12345623");
        listBean23.setId("23");
        list.add(listBean23);
        ShishiOrderListBean.ListBean listBean24=new ShishiOrderListBean.ListBean();
        listBean24.setDlName("12345624");
        listBean24.setId("24");
        list.add(listBean24);

    }

    @Override
    protected void afterRequestPermission(int requestCode, boolean isAllGranted) {

    }
}