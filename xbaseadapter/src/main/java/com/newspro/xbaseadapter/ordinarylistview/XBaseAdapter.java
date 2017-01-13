package com.newspro.xbaseadapter.ordinarylistview;

import android.content.Context;

import com.newspro.xbaseadapter.ordinarylistview.delegate.ItemViewDelegate;

import java.util.List;

/**
 * Created by Alex on 2017/1/12.
 * Alex
 * 单类型的adapter
 */

public abstract class XBaseAdapter<T> extends XMultiItemTypeAdapter<T> {
    public XBaseAdapter(Context context, final int layoutId, List<T> mDatas) {
        super(context, mDatas);
        addDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position) {
                return true;
            }

            @Override
            public void convert(XViewHolder holder, T item, int position) {
                XBaseAdapter.this.convert(holder,item,position);
            }
        });
    }
    protected abstract void convert(XViewHolder viewHolder, T item, int position);
}
