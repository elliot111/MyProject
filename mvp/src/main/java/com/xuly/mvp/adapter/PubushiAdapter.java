package com.xuly.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xuly.mvp.R;
import com.xuly.mvp.bean.ShishiOrderListBean;

import java.util.List;

public class PubushiAdapter extends RecyclerView.Adapter<PubushiAdapter.MyHolder> {
    private List<ShishiOrderListBean.ListBean> mList;//数据源
    private Context mContext;

    public static final int VIEW_TYPE_ITEM = 1;
    public static final int VIEW_TYPE_EMPTY = 0;
    private final double STANDARD_SCALE = 1.1; //当图片宽高比例大于STANDARD_SCALE时，采用3:4比例，小于时，则采用1:1比例
    private final float SCALE = 4 * 1.0f / 3;

    private PubushiAdapter.OnItemClickListener onCancelItemClickListener;

    public PubushiAdapter(Context context, List<ShishiOrderListBean.ListBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public PubushiAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //将我们自定义的item布局R.layout.item_one转换为View
        if (viewType == VIEW_TYPE_EMPTY) {
            View emptyView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            PubushiAdapter.MyHolder holder = new PubushiAdapter.MyHolder(emptyView);
            return holder;

        } else {
            View view = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_order_list, parent, false);
            //将view传递给我们自定义的ViewHolder
            PubushiAdapter.MyHolder holder = new PubushiAdapter.MyHolder(view);
            //返回这个MyHolder实体
            return holder;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull PubushiAdapter.MyHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (VIEW_TYPE_EMPTY != itemViewType) {

            holder.tv_content.setText(mList.get(position).getDlName());

//            holder.tv_content.setEms(mList.get(position).getDlName().length());
//            //计算图片宽高
//            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.itemView.getLayoutParams();
//            //2列的瀑布流，屏幕宽度减去两列间的间距space所的值再除以2，计算出单列的imageview的宽度，space的值在RecyclerView初始化时传入
//            float itemWidth = (ScreenUtils.getScreenWidth(mContext) - mContext.getResources().getDimensionPixelOffset(R.dimen.mtrl_slider_thumb_radius)) / 2;
//            layoutParams.width = (int) itemWidth;
//
//            float width = card.getWidth();
//            float height = card.getHeight();
//            float scale = height / width;
//            if (scale > STANDARD_SCALE) {
//                //采用3:4显示
//                layoutParams.height = (int) (itemWidth * SCALE);
//            } else {
//                //采用1:1显示
//                layoutParams.height = (int) itemWidth;
//            }
//            holder.image.setLayoutParams(layoutParams);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onCancelItemClickListener != null) {
                        onCancelItemClickListener.onItemClick(view, holder.getAdapterPosition(),mList.get(position).getId(),mList.get(position).getDlName());
                    }
                }
            });


        }

    }

    @Override
    public int getItemCount() {
        if (mList.size() == 0) {
            return 1;
        } else {
            return mList.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        //在这里进行判断，如果我们的集合的长度为0时，我们就使用emptyView的布局
        if (mList.size() == 0) {
            return VIEW_TYPE_EMPTY;
        }
        //如果有数据，则使用ITEM的布局
        return VIEW_TYPE_ITEM;
    }

    /**
     * 自定义的ViewHolder
     */
    class MyHolder extends RecyclerView.ViewHolder {

        TextView tv_content;
        public MyHolder(View itemView) {
            super(itemView);
            tv_content = itemView.findViewById(R.id.tv_content);
        }
    }

    /**
     * 供外部调用设置监听
     *
     * @param onItemClickListener
     */
    public void setCancelOnItemClickListener(PubushiAdapter.OnItemClickListener onItemClickListener) {
        this.onCancelItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position,String id,String name);
    }
}
