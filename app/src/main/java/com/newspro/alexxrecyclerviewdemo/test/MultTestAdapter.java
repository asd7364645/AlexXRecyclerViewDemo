package com.newspro.alexxrecyclerviewdemo.test;

import android.content.Context;

import com.newspro.alexxrecyclerviewdemo.bean.User;
import com.newspro.xbaseadapter.ordinarylistview.XMultiItemTypeAdapter;

import java.util.List;

/**
 * Created by Alex on 2017/1/13.
 * Alex
 */

public class MultTestAdapter extends XMultiItemTypeAdapter<User> {
    public MultTestAdapter(Context context, List<User> mDatas) {
        super(context, mDatas);

    }
}
