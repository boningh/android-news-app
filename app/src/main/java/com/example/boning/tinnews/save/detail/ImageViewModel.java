/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.boning.tinnews.save.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.boning.tinnews.R;
import com.example.boning.tinnews.common.BaseViewModel;
import com.squareup.picasso.Picasso;

public class ImageViewModel extends BaseViewModel<ImageViewModel.ImageViewModelViewHolder> {

    private final String uri;
    public ImageViewModel(String uri) {
        super(R.layout.image_layout);
        this.uri = uri;
    }

    @Override
    public ImageViewModelViewHolder createItemViewHolder(View view) {
        return new ImageViewModelViewHolder(view);
    }

    @Override
    public void bindViewHolder(ImageViewModelViewHolder holder) {
        Picasso.get().load(uri).into(holder.image);
    }

    static class ImageViewModelViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        ImageViewModelViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}
