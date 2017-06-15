package com.example.vita.tablayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vita on 2017/6/15.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.viewHolder> {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List mData;


    public  GridAdapter (Context context, List data){
        this.mContext = context;
        this.mLayoutInflater =LayoutInflater.from(context);
        this.mData = data;
     }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public GridAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.gridrecycleview,null);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(GridAdapter.viewHolder holder, int position) {
        Drawable drawable = ((Classifydata)mData.get(position)).getaImg();
        drawable.setBounds(0, 0, 50, 50);//必须加
        holder.mTextView.setCompoundDrawables(null,drawable,null,null);
        holder.mTextView.setText(((Classifydata)mData.get(position)).getaName());
    }

    @Override
    public void onViewRecycled(GridAdapter.viewHolder holder) {
        super.onViewRecycled(holder);
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView mTextView;

        public viewHolder(View itemView) {
            super(itemView);
            mTextView =(TextView) itemView.findViewById(R.id.gr_text);
        }
    }
}
