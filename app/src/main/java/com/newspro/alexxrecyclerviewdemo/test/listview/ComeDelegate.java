package com.newspro.alexxrecyclerviewdemo.test.listview;

import android.widget.ProgressBar;
import android.widget.TextView;

import com.newspro.alexxrecyclerviewdemo.R;
import com.newspro.alexxrecyclerviewdemo.bean.User;
import com.newspro.xbaseadapter.ordinarylistview.XLvViewHolder;
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
    public void convert(XLvViewHolder holder, User item, int position) {
        TextView textView = holder.getItemView(R.id.userNameTwo);
        textView.setText(item.getName());
        ProgressBar progressBar = holder.getItemView(R.id.userSize);
        progressBar.setProgress(item.getSize());
    }

    @Override
    public void convertByPosi(XLvViewHolder holder, User item, int position) {
        ProgressBar progressBar = holder.getItemView(R.id.userSize);
        progressBar.setProgress(item.getSize());
    }
}
