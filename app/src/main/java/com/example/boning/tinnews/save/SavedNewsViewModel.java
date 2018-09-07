/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.boning.tinnews.save;

import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.boning.tinnews.R;
import com.example.boning.tinnews.common.BaseViewModel;
import com.example.boning.tinnews.common.TinFragmentManager;
import com.example.boning.tinnews.common.Util;
import com.example.boning.tinnews.retrofit.response.News;
import com.example.boning.tinnews.save.detail.SavedNewsDetailedFragment;

public class SavedNewsViewModel extends BaseViewModel<SavedNewsViewModel.SavedNewsViewHolder>  {

    private News news;
    private TinFragmentManager tinFragmentManager;
    private static int[] ICON_ARRAY = new int[]{R.drawable.a_news_icon, R.drawable.g_news_icon,
            R.drawable.c_news_icon, R.drawable.y_news_icon, R.drawable.m_news_icon};

    public SavedNewsViewModel(News news, TinFragmentManager tinFragmentManager) {
        super(R.layout.saved_news_item);
        this.news = news;
        this.tinFragmentManager = tinFragmentManager;
    }

    @Override
    public SavedNewsViewHolder createItemViewHolder(View view) {
        return new SavedNewsViewHolder(view);
    }

    @Override
    public void bindViewHolder(SavedNewsViewHolder holder) {
        if (!Util.isStringEmpty(news.author)) {
            holder.author.setText(news.author);
        }
        holder.description.setText(news.getDescription());
        holder.icon.setImageResource(getDrawable());
        holder.itemView.setOnClickListener(v -> {
            tinFragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance(news));
        });
    }

    private @DrawableRes
    int getDrawable() {
        return ICON_ARRAY[(int)(Math.random() * 5)];
    }


    public static class SavedNewsViewHolder extends RecyclerView.ViewHolder {

        TextView author;
        TextView description;
        ImageView icon;

        public SavedNewsViewHolder(View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            description = itemView.findViewById(R.id.description);
            icon = itemView.findViewById(R.id.image);
        }
    }

}
