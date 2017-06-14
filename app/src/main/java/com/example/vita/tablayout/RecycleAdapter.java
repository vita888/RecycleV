package com.example.vita.tablayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vita on 2017/6/13.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.FragmentViewHolder> {
    private List<Fragment> mFragments;
    FragmentManager mFragmentManager;
    private Context mContext;
    private LayoutInflater mLayoutflater;

    public RecycleAdapter(Context context, List data, FragmentManager fragmentManager) {
        this.mFragments = data;
        this.mFragmentManager = fragmentManager;
        this.mContext = context;
        this.mLayoutflater = LayoutInflater.from(mContext);
    }

    @Override
    public FragmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view =mLayoutflater.inflate(R.layout.fragment_pa1ge,parent,false);
        Fragment targest = mFragments.get(viewType);
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (!targest.isAdded()&&!targest.isDetached()){
            fragmentTransaction.add(targest, targest.getClass().getName());
            fragmentTransaction.commitNow();
            mFragmentManager.executePendingTransactions();
        }
        FragmentViewHolder holder = new FragmentViewHolder(targest);
        return holder;
    }

    @Override
    public void onBindViewHolder(FragmentViewHolder holder, int position) {
        Fragment fragment = holder.mFrag;
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (!fragment.isAdded()&&!fragment.isDetached()){
           fragmentTransaction.add(0,fragment,fragment.getClass().getName());
        }else if (fragment.isDetached()){
            fragmentTransaction.attach(fragment);
        }else {
            fragmentTransaction.show(fragment);
        }
        fragmentTransaction.commit();
        mFragmentManager.executePendingTransactions();

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mFragments==null?0:mFragments.size();
    }

    @Override
    public void onViewRecycled(FragmentViewHolder holder) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.detach(holder.mFrag);
        ft.commit();
        mFragmentManager.executePendingTransactions();
    }


    public class FragmentViewHolder extends RecyclerView.ViewHolder {
        Fragment mFrag;

        public FragmentViewHolder(View itemView) {
            super(itemView);
        }
          public FragmentViewHolder(Fragment fragment){
               this(fragment.getView());
               mFrag = fragment;
            }
        }
    }

