package com.zyyoona7.jokes.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zyyoona7.jokes.module.textJoke.ChildTextJokeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2016/6/29.
 */

public class TextJokeVpAdapter extends FragmentPagerAdapter {

    private List<String> titles;

    public TextJokeVpAdapter(FragmentManager fm,List<String> list) {
        super(fm);
        if(list!=null){
            this.titles=list;
        }else {
            this.titles=new ArrayList<>();
        }
    }

    @Override
    public Fragment getItem(int position) {
        return ChildTextJokeFragment.newInstance(position + 1);
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
