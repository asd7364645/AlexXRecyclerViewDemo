package com.newspro.alexxrecyclerviewdemo.test.listview;

import android.widget.TextView;

import com.newspro.alexxrecyclerviewdemo.R;
import com.newspro.alexxrecyclerviewdemo.bean.User;
import com.newspro.xbaseadapter.ordinarylistview.XLvViewHolder;
import com.newspro.xbaseadapter.ordinarylistview.delegate.ItemViewDelegate;

/**
 * Created by Alex on 2017/1/16.
 * Alex
 */

public class MyDelegate implements ItemViewDelegate<User> {
    @Override
    public int getLayoutId() {
        return R.layout.item_test_lv;
    }

    @Override
    public boolean isForViewType(User item, int position) {
        return !item.isCome();
    }

    @Override
    public void convert(XLvViewHolder holder, User item, int position) {
        TextView userName = holder.getItemView(R.id.userName);
        userName.setText(item.getName());
    }

    @Override
    public void convertByPosi(XLvViewHolder holder, User item, int position) {

    }
}
