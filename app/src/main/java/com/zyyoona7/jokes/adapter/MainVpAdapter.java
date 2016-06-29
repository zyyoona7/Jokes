package com.zyyoona7.jokes.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zyyoona7.jokes.module.imageJoke.ImageJokeFragment;
import com.zyyoona7.jokes.module.textJoke.TextJokeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2016/6/29.
 */

public class MainVpAdapter extends FragmentPagerAdapter {
    private List<String> titles;
    public MainVpAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        if(titles!=null){
            this.titles=titles;
        }else {
            this.titles=new ArrayList<>();
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0) {
            return TextJokeFragment.newInstance();
        }else if(position==1){
            return ImageJokeFragment.newInstance();
        }else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
