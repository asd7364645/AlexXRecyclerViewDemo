package com.newspro.alexxrecyclerviewdemo.test.recyclerview;

import android.widget.ProgressBar;
import android.widget.TextView;

import com.newspro.alexxrecyclerviewdemo.R;
import com.newspro.alexxrecyclerviewdemo.bean.User;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvViewHolder;
import com.newspro.xbaseadapter.recycler_baseadapter.delegate.RvItemViewDelegate;

/**
 * Created by Alex on 2017/1/17.
 * Alex
 */

public class RvComeDelegate implements RvItemViewDelegate<User> {
    @Override
    public int getLayoutId() {
        return R.layout.item_testtwo_lv;
    }

    @Override
    public boolean isForViewType(User item, int position) {
        return item.isCome();
    }

    @Override
    public void convert(XRvViewHolder holder, User item, int position) {
        TextView userName = holder.getItemView(R.id.userNameTwo);
        userName.setText(item.getName());
        ProgressBar progressBar = holder.getItemView(R.id.userSize);
        progressBar.setProgress(item.getSize());
    }

    @Override
    public void convertByPosi(XRvViewHolder holder, User item, int position) {
        ProgressBar progressBar = holder.getItemView(R.id.userSize);
        progressBar.setProgress(item.getSize());
    }

}
