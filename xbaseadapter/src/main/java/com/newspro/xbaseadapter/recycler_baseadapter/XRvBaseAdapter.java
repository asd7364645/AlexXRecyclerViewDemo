package com.newspro.xbaseadapter.recycler_baseadapter;

import android.content.Context;

import com.newspro.xbaseadapter.ordinarylistview.XLvViewHolder;
import com.newspro.xbaseadapter.recycler_baseadapter.delegate.ItemViewDelegate;

import java.util.List;

/**
 * Created by Alex on 2017/1/16.
 * Alex
 */

public abstract class XRvBaseAdapter<T> extends XRvMultiItemTypeAdapter<T> {
    public XRvBaseAdapter(Context context, final int layoutId, List<T> mDatas) {
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
            public void convert(XRvViewHolder holder, T item, int position) {

            }

            @Override
            public void convertByPosi(XRvViewHolder holder, T item, int position) {

            }
        });
    }

    protected abstract void convert(XLvViewHolder viewHolder, T item, int position);

}
