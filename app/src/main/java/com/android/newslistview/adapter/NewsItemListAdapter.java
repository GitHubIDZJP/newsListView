package com.android.newslistview.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.newslistview.R;
import com.android.newslistview.vo.response.news.ListNewsVO;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhengliang on 2017/11/20 0020.
 */

/**
 * Created by zhengliang on 2017/11/20 0020.
 */

public class NewsItemListAdapter extends RecyclerView.Adapter<NewsItemListAdapter.MyViewHolder> {
    private Context context;
    private List<ListNewsVO.ResultEntity.DataEntity> newsList = new ArrayList<>();
    private OnItemClickListener listener;



    public NewsItemListAdapter(Context context, ListNewsVO response) {
        this.context = context;

        if (response != null && response.getResult() != null) {
            this.newsList = response.getResult().getData();
        }
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.itme_news, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ListNewsVO.ResultEntity.DataEntity news = newsList.get(position);
        holder.tvTitle.setText(news.getTitle());
        holder.tvDate.setText(news.getDate());

        //加载图片
        Glide.with(context)
                .load(news.getThumbnail_pic_s())
                .diskCacheStrategy(DiskCacheStrategy.ALL)//开启缓存
                .into(holder.ivImg);
        //设置Item的点击事件
        if (this.listener != null) {
            holder.LLItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(view,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.newsList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.ll_item)
        LinearLayout LLItem;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 自定义Item的点击事件接口
     */
    public interface OnItemClickListener{
        void onClick(View view,int position);
    }
}



