package com.zyyoona7.jokes.module.imageJoke;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zyyoona7.jokes.R;
import com.zyyoona7.jokes.adapter.ImageJokeVpAdapter;
import com.zyyoona7.jokes.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by User on 2016/6/29.
 */

public class ImageJokeFragment extends BaseFragment {

    @BindView(R.id.stl_image_joke)
    SmartTabLayout mStlTextJoke;

    @BindView(R.id.vp_image_joke)
    ViewPager mVpTextJoke;

    public static ImageJokeFragment newInstance() {
        ImageJokeFragment fragment = new ImageJokeFragment();
        return fragment;
    }

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_image_joke;
    }

    @Override
    protected void initViewAndEvents(View view) {
        List<String> titles = new ArrayList<>();
        titles.add(_mActivity.getResources().getString(R.string.tab_title_newest));
        titles.add(_mActivity.getResources().getString(R.string.tab_title_day));
        titles.add(_mActivity.getResources().getString(R.string.tab_title_week));
        titles.add(_mActivity.getResources().getString(R.string.tab_title_month));
        ImageJokeVpAdapter adapter = new ImageJokeVpAdapter(getChildFragmentManager(), titles);
        mVpTextJoke.setAdapter(adapter);
        mStlTextJoke.setViewPager(mVpTextJoke);
    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }
}
