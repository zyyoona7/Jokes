package com.zyyoona7.jokes.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zyyoona7.jokes.R;
import com.zyyoona7.jokes.model.bean.ImageJoke;

/**
 * Created by zyyoona7 on 2016/6/30.
 */

public class ImageJokeRvAdapter extends BaseQuickAdapter<ImageJoke> {

    public ImageJokeRvAdapter() {
        super(R.layout.item_image_joke, null);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ImageJoke imageJoke) {
        ImageView imageView = baseViewHolder.getView(R.id.iv_image_joke);
        Glide.with(imageView.getContext())
                .load(imageJoke.getUrl())
                .into(imageView);
        baseViewHolder.setText(R.id.tv_image_joke, imageJoke.getContent());
    }
}
