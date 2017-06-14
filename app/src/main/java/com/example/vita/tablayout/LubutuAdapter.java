package com.example.vita.tablayout;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by vita on 2017/6/12.
 */

public class LubutuAdapter extends PagerAdapter {
    public  static  final int MAX =10000;
    private List<ImageView> mItems;
    private Context mContext;
    private LayoutInflater mInflater;

public  LubutuAdapter(List list,Context context){
    this.mItems = list;
    this.mContext = context;

}

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView view = mItems.get(position);
        ViewParent viewParent = view.getParent();
        if(viewParent!=null){
            ViewGroup parent = (ViewGroup) viewParent;
            parent.removeView(view);
        }
        container.addView(view);//创建并添加view到父容器，返回这个新增的view
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mItems.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
