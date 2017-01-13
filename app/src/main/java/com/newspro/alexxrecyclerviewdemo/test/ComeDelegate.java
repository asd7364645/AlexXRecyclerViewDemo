package com.newspro.alexxrecyclerviewdemo.test;

import android.widget.TextView;

import com.newspro.alexxrecyclerviewdemo.R;
import com.newspro.alexxrecyclerviewdemo.bean.User;
import com.newspro.xbaseadapter.ordinarylistview.XViewHolder;
import com.newspro.xbaseadapter.ordinarylistview.delegate.ItemViewDelegate;

/**
 * Created by Alex on 2017/1/13.
 * Alex
 */

public class ComeDelegate implements ItemViewDelegate<User> {
    @Override
    public int getLayoutId() {
        return R.layout.item_testtwo_lv;
    }

    @Override
    public boolean isForViewType(User item, int position) {
        return item.isCome();
    }

    @Override
    public void convert(XViewHolder holder, User item, int position) {
        TextView textView = holder.getItemView(R.id.userNameTwo);
        textView.setText(item.getName());
    }
}
