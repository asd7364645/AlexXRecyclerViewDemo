package com.newspro.alexxrecyclerviewdemo.test.header_and_footer_test;

import android.content.Context;

import com.newspro.alexxrecyclerviewdemo.bean.User;
import com.newspro.xbaseadapter.recycler_baseadapter.has_head_foot_adapter.XHFRvMultiItemTypeAdapter;

import java.util.List;

/**
 * Created by Alex on 2017/1/17.
 * Alex
 */

public class RvMultTestAdapter extends XHFRvMultiItemTypeAdapter<User> {
    public RvMultTestAdapter(Context context, List<User> mDatas) {
        super(context, mDatas);
        addDelegate(new RvComeDelegate()).addDelegate(new RvMyDelegate());
    }
}
