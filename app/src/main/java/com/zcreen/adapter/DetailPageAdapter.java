package com.zcreen.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zcreen.fragment.CommentsFragment;
import com.zcreen.fragment.SurveyFragment;

/**
 * Created by mertkanuzunparmak on 10/04/16.
 * mertkan@mobilike.com
 */
public class DetailPageAdapter extends FragmentStatePagerAdapter {

    private static final String[] TITLES = new String[]{"Yorumlar", "Anketler"};


    public DetailPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return CommentsFragment.newInstance();
        } else {
            return SurveyFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}
