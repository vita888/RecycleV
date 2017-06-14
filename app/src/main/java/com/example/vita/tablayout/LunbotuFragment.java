package com.example.vita.tablayout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vita on 2017/6/12.
 */

public class LunbotuFragment extends Fragment implements View.OnTouchListener {
    private List<ImageView> mItems;
    public LubutuAdapter mAdapter;
    private ViewPager mViewPager;
    private Context mContext = getContext();

    private Runnable mRunnable;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRunnable = new Runnable() {
            @Override
            public void run() {
                int index = mViewPager.getCurrentItem();
                int position = (index + 1) % mItems.size();
                mViewPager.setCurrentItem(position);
                mViewPager.postDelayed(mRunnable, 1000);
            }
        };
    }

    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lunbotu, container, false);
        mItems = new ArrayList<>();
        addImageView();


        mAdapter = new LubutuAdapter(mItems, mContext);

        mViewPager = (ViewPager) view.findViewById(R.id.vp_lbtt);
        mViewPager.setAdapter(mAdapter);

        mViewPager.setOnTouchListener(this);
        mViewPager.postDelayed(mRunnable, 1000);

        return view;


    }

    private void addImageView() {
        ImageView view0 = new ImageView(this.getContext());
        view0.setImageResource(R.mipmap.lbt1);
        ImageView view1 = new ImageView(this.getContext());
        view1.setImageResource(R.mipmap.lbt2);
        ImageView view2 = new ImageView(this.getContext());
        view2.setImageResource(R.mipmap.lbt3);

        view0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view2.setScaleType(ImageView.ScaleType.CENTER_CROP);

        mItems.add(view0);
        mItems.add(view1);
        mItems.add(view2);
//        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mViewPager.removeCallbacks(mRunnable);
                break;
            case MotionEvent.ACTION_UP:
                mViewPager.postDelayed(mRunnable, 1000);
                break;
        }
        return false;
    }
}
