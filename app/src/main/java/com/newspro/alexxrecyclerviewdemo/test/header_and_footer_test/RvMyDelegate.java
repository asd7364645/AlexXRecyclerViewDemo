package com.newspro.alexxrecyclerviewdemo.test.header_and_footer_test;

import android.widget.TextView;

import com.newspro.alexxrecyclerviewdemo.R;
import com.newspro.alexxrecyclerviewdemo.bean.User;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvViewHolder;
import com.newspro.xbaseadapter.recycler_baseadapter.delegate.RvItemViewDelegate;

/**
 * Created by Alex on 2017/1/17.
 * Alex
 */

public class RvMyDelegate implements RvItemViewDelegate<User> {
    @Override
    public int getLayoutId() {
        return R.layout.item_test_lv;
    }

    @Override
    public boolean isForViewType(User item, int position) {
        return !item.isCome();
    }

    @Override
    public void convert(XRvViewHolder holder, User item, int position) {
        TextView userName = holder.getItemView(R.id.userName);
        userName.setText(item.getName());
    }

    @Override
    public void convertByPosi(XRvViewHolder holder, User item, int position) {

    }
}
