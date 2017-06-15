package com.example.vita.tablayout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vita on 2017/6/15.
 */

public class GridRecycleViewFragment extends Fragment{
    public List mData;
    private RecyclerView mGridrecycleview;
    private  Context mContext;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext =getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.grecyclecontainer,container,false);

        mData = new ArrayList();
        mData.add(new Classifydata("Smartphone",mContext.getResources().getDrawable(R.mipmap.mobilephone)));
        mData.add(new Classifydata("Rumah",mContext.getResources().getDrawable(R.mipmap.rumah)));
        mData.add(new Classifydata("PersonalCare",mContext.getResources().getDrawable(R.mipmap.personal)));
        mData.add(new Classifydata("Ilu&Baby",mContext.getResources().getDrawable(R.mipmap.baby)));
        mData.add(new Classifydata("Produk IT",mContext.getResources().getDrawable(R.mipmap.pc)));
        mData.add(new Classifydata("Voicher",mContext.getResources().getDrawable(R.mipmap.voucher)));
        mData.add(new Classifydata("Movie Teckit",mContext.getResources().getDrawable(R.mipmap.movie)));
        mData.add(new Classifydata("Food",mContext.getResources().getDrawable(R.mipmap.food)));

        GridAdapter gridAdapter = new GridAdapter(getContext(),mData);
        mGridrecycleview= (RecyclerView) view.findViewById(R.id.gridviewcontainer);
        mGridrecycleview.setLayoutManager(new GridLayoutManager(this.getContext(),4));
        GridAdapter mgridAdapter = new GridAdapter(mContext,mData);

        mGridrecycleview.setAdapter(mgridAdapter);
        return view;
    }

    @Override
    public Context getContext() {
        return super.getContext();
    }
}
