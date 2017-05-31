package com.example.lwl.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.lwl.ui.Fragment1;
import com.example.lwl.ui.Fragment2;
import com.example.lwl.ui.Fragment3;
import com.example.lwl.ui.Fragment4;

import java.util.List;

/**
 * Created by lwl on 2017/5/24.
 */
public class HomeFragmentAdapter extends FragmentStatePagerAdapter {

    private List<String> mTitles;

    public HomeFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public HomeFragmentAdapter(FragmentManager fm, List<String> mTitles) {
        super(fm);
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        String str = mTitles.get(position);
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = Fragment1.newInstance(str);
                break;
            case 1:
                fragment = Fragment2.newInstance(str);
                break;
            case 2:
                fragment = Fragment3.newInstance(str);
                break;
            case 3:
                fragment = Fragment4.newInstance(str);
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles ==null ? 0:mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
