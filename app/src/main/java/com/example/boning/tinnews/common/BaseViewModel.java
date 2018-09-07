/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.boning.tinnews.common;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseViewModel<V extends RecyclerView.ViewHolder> {

    private final int itemResourceId;


    public BaseViewModel(int itemResourceId) {
        this.itemResourceId = itemResourceId;
    }


    public V createViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemResourceId, parent, false);
        return createItemViewHolder(view);
    }


    public abstract V createItemViewHolder(View view);


    public abstract void bindViewHolder(V holder);


    public int getViewType() {
        return itemResourceId;
    }
}
