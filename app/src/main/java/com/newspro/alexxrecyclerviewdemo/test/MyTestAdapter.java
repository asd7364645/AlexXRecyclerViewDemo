package com.newspro.alexxrecyclerviewdemo.test;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.newspro.xbaseadapter.ordinarylistview.XViewHolder;

import java.util.List;

/**
 * Created by Alex on 2017/1/12.
 * Alex
 */

public abstract class MyTestAdapter<T> extends BaseAdapter {

    private List<T> list;
    private Context context;
    private int layoutId;

    public MyTestAdapter(List<T> list, Context context,int layoutId) {
        this.list = list;
        this.context = context;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        XViewHolder holder = getViewHolder(position,convertView,parent);

        setConvert(holder, list.get(position));

        return holder.getmConvertView();
    }

    public abstract void setConvert(XViewHolder holder, T item);

    private XViewHolder getViewHolder(int position, View convertView,
                                      ViewGroup parent) {
        return XViewHolder.getHolder(context, convertView, parent, layoutId, position);
    }

}
