package com.newspro.xbaseadapter.ordinarylistview.delegate;

import com.newspro.xbaseadapter.ordinarylistview.XViewHolder;

/**
 * Created by Alex on 2017/1/12.
 * Alex
 */

public interface ItemViewDelegate<T> {

    /**
     * 设置item的布局id
     * @return
     */
    int getLayoutId();

    /**
     * 用于设置或判断当前item的类别
     * 例如聊天，对方的为true，我的为false
     * 就返回这个变量，然后在所有的type判断，找到了就设置内容
     *
     * @param item
     * @param position
     * @return
     */
    boolean isForViewType(T item,int position);

    /**
     * 设置内容
     * @param holder
     * @param item
     * @param position
     */
    void convert(XViewHolder holder,T item,int position);

}
