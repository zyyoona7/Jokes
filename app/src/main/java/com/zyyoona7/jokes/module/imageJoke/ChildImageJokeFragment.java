package com.zyyoona7.jokes.module.imageJoke;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zyyoona7.jokes.R;
import com.zyyoona7.jokes.base.BaseLazyFragment;

/**
 * Created by User on 2016/6/29.
 */

public class ChildImageJokeFragment extends BaseLazyFragment {

    private static final int NEWST = 1;
    private static final int DAY = 2;
    private static final int WEEK = 3;
    private static final int MONTH = 4;

    private int mType = 1;

    public static ChildImageJokeFragment newInstance(int type) {
        ChildImageJokeFragment fragment = new ChildImageJokeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = getArguments().getInt("type");
        }
    }

    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void initViewsAndEvents(View view) {

    }

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_child_image_joke;
    }
}
