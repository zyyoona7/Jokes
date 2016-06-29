package com.zyyoona7.jokes.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zyyoona7.jokes.R;
import com.zyyoona7.jokes.model.bean.TextJoke;

/**
 * Created by zyyoona7 on 2016/6/29.
 */

public class TextJokeRvAdapter extends BaseQuickAdapter<TextJoke> {


    public TextJokeRvAdapter() {
        super(R.layout.item_text_joke, null);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, TextJoke textJoke) {
        baseViewHolder.setText(R.id.tv_text_joke, textJoke.getContent());
    }
}
