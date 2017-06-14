package com.example.vita.tablayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vita on 2017/6/13.
 */

public class RecycleAdapter extends RecyclerView.Adapter {
    private  ArrayList mList;
    private Context mContext;
    private  LayoutInflater mLayoutflater;

    public  RecycleAdapter(Context context, ArrayList data){
        this.mList = data;
        this.mContext = context;
        this.mLayoutflater = LayoutInflater.from(mContext);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
