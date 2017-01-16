package com.newspro.alexxrecyclerviewdemo.test.listview;

import android.content.Context;

import com.newspro.alexxrecyclerviewdemo.bean.User;
import com.newspro.xbaseadapter.ordinarylistview.XBaseAdapter;
import com.newspro.xbaseadapter.ordinarylistview.XLvViewHolder;

import java.util.List;

/**
 * Created by Alex on 2017/1/12.
 * Alex
 */

public abstract class MyTestAdapter<T> extends XBaseAdapter<User> {


    public MyTestAdapter(Context context, int layoutId, List<User> mDatas) {
        super(context, layoutId, mDatas);
    }

    @Override
    protected void convertByPosition(XLvViewHolder holder, User item, int position) {
        super.convertByPosition(holder, item, position);
    }
}
