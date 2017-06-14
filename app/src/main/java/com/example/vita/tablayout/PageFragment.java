package com.example.vita.tablayout;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by vita on 2017/6/9.
 */

public class PageFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnTouchListener {
    public static final String ARGS_PAGE = "args_page";

    private int mPage;


    private List<ImageView> mItems;
    private Context mContext = getContext();
    private ViewPager mViewPager;

    private FragmentManager fm;
    public LubutuAdapter mAdapter;

    private int currentViewPagerItem;


    private Runnable runnable;


    public static Fragment newInstance(int page) {

        Bundle args = new Bundle();
        args.putInt(ARGS_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARGS_PAGE);
        Log.i("******************", "############OnCreate############");
        Log.i("*********************", "" + mPage + "页OnCreate");


        runnable = new Runnable() {
            @Override
            public void run() {
                int index = mViewPager.getCurrentItem();
               int position = (index + 1) % mItems.size();
                mViewPager.setCurrentItem(position);
                mViewPager.postDelayed(runnable, 1000);
            }
        };
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        if (mPage == 1) {

            View view = inflater.inflate(R.layout.fragment_pa1ge, container, false);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleview);
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
            mViewPager = (ViewPager) view.findViewById(R.id.vp_lbt);
            mItems = new ArrayList<>();
            addImageView();
            mAdapter = new LubutuAdapter(mItems, mContext);
            mViewPager.setAdapter(mAdapter);

            mViewPager.setOnTouchListener(this);
            mViewPager.postDelayed(runnable, 1000);

            return view;





        } else {
            View view = inflater.inflate(R.layout.fragment_pa2ge, container, false);
            TextView mTextView = (TextView) view.findViewById(R.id.textview);
            mTextView.setText("第" + mPage + "页");
            Log.i("******************", "############OnCreateView############");
            Log.i("*********************", "" + mPage + "页OnCreateView");
            return view;
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("******************", "############OnStop############");
        Log.i("*********************", "" + mPage + "页OnStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("******************", "############OnDestroyed############");
        Log.i("*********************", "" + mPage + "页OnDestroed");

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
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mViewPager.removeCallbacks(runnable);
                break;
            case MotionEvent.ACTION_UP:
                mViewPager.postDelayed(runnable,1000);
                break;
        }
        return false;
    }

}
