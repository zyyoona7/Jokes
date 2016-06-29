package com.zyyoona7.jokes.module;

import android.view.View;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zyyoona7.jokes.R;
import com.zyyoona7.jokes.adapter.MainVpAdapter;
import com.zyyoona7.jokes.base.BaseActivity;
import com.zyyoona7.jokes.widget.ViewPagerCompat;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.stl_main)
    SmartTabLayout mStlMain;

    @BindView(R.id.vp_main)
    ViewPagerCompat mVpMain;

    @Override
    protected void initViewsAndEvents() {
        List<String> titles = new ArrayList<>();
        titles.add(getResources().getString(R.string.tab_title_text_joke));
        titles.add(getResources().getString(R.string.tab_title_image_joke));
        MainVpAdapter mainVpAdapter = new MainVpAdapter(getSupportFragmentManager(), titles);
        mVpMain.setAdapter(mainVpAdapter);
        mStlMain.setViewPager(mVpMain);
    }

    @Override
    protected int getContentViewID() {
        return R.layout.activity_main;
    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }
}
