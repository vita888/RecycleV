package com.example.vita.tablayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by vita on 2017/6/9.
 */

 class MyFragmentAdapter extends FragmentPagerAdapter{
    private  Context mContext;
    public  final  int Count =4;
    private String[] title ={"Ramadha","Fashion","TV&Rumah","JD Luxe"};

    public MyFragmentAdapter(FragmentManager fm,Context context){
        super(fm);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return Count;
    }

    @Override
    public Fragment getItem(int position) {
        return    PageFragment.newInstance(position+1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];

    }
}
