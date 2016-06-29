package com.zyyoona7.jokes.module.textJoke;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zyyoona7.jokes.R;
import com.zyyoona7.jokes.adapter.TextJokeVpAdapter;
import com.zyyoona7.jokes.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by zyyoona7 on 2016/6/29.
 */

public class TextJokeFragment extends BaseFragment {

    @BindView(R.id.stl_text_joke)
    SmartTabLayout mStlTextJoke;

    @BindView(R.id.vp_text_joke)
    ViewPager mVpTextJoke;

    public static TextJokeFragment newInstance() {
        TextJokeFragment fragment = new TextJokeFragment();
        return fragment;
    }

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_text_joke;
    }

    @Override
    protected void initViewAndEvents(View view) {
        List<String> titles = new ArrayList<>();
        titles.add(_mActivity.getResources().getString(R.string.tab_title_newest));
        titles.add(_mActivity.getResources().getString(R.string.tab_title_day));
        titles.add(_mActivity.getResources().getString(R.string.tab_title_week));
        titles.add(_mActivity.getResources().getString(R.string.tab_title_month));
        TextJokeVpAdapter adapter = new TextJokeVpAdapter(getChildFragmentManager(), titles);
        mVpTextJoke.setAdapter(adapter);
        mStlTextJoke.setViewPager(mVpTextJoke);
    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }
}
