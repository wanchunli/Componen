package com.anso.base.baseadapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager适配器
 * CustomViewPagerAdapter
 * author wanchun
 * email 1596900283@qq.com
 * create 2018/3/5 14:28
 */
public class CustomViewPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragments = new ArrayList<>();

    public static final int TAB_ONE = 0;
    public static final int TAB_TWO = 1;
    public static final int TAB_THREE = 2;
    public static final int TAB_FOUR = 3;
    public static final int TAB_FIVE= 4;

    public CustomViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment) {
        mFragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        if(mFragments.size()==0){
            return null;
        }
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public List<Fragment> getmFragments() {

        return mFragments;
    }

    public void cleanFragments() {
        mFragments.clear();
    }

    private int mChildCount = 0;

    @Override
    public void notifyDataSetChanged() {
        mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

}
