package com.newspro.xbaseadapter.ordinarylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.newspro.xbaseadapter.ordinarylistview.delegate.ItemViewDelegate;
import com.newspro.xbaseadapter.ordinarylistview.delegate.ItemViewDelegateManager;

import java.util.List;

/**
 * Created by Alex on 2017/1/12.
 * Alex
 * 多个ItemType的通用Adapter
 */

public class XMultiItemTypeAdapter<T> extends BaseAdapter {

    private Context context;
    private List<T> mDatas;

    private ItemViewDelegateManager<T> itemViewDelegateManager;

    public XMultiItemTypeAdapter(Context context, List<T> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        itemViewDelegateManager = new ItemViewDelegateManager<>();
    }

    public XMultiItemTypeAdapter<T> addDelegate(ItemViewDelegate<T> itemViewDelegate){
        itemViewDelegateManager.addDelegate(itemViewDelegate);
        return this;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (useItemViewDelegateManager()){
            return itemViewDelegateManager.getItemViewType(mDatas.get(position),position);
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        if (useItemViewDelegateManager()){
            return itemViewDelegateManager.getDelegateCount();
        }
        return super.getViewTypeCount();
    }

    private boolean useItemViewDelegateManager() {
        return itemViewDelegateManager.getDelegateCount()>0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewDelegate itemViewDelegate = itemViewDelegateManager.getItemViewDelegate(mDatas.get(position), position);
        int layoutId = itemViewDelegate.getLayoutId();
        XViewHolder viewHolder;
        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(layoutId, parent,
                    false);
            viewHolder = new XViewHolder(context, convertView, position);
            viewHolder.setLayoutId(layoutId);
            onViewHolderCreated(viewHolder,viewHolder.getmConvertView());
        } else
        {
            viewHolder = (XViewHolder) convertView.getTag();
            viewHolder.setPosition(position);
        }


        convert(viewHolder, getItem(position), position);
        return convertView;
    }

    protected void convert(XViewHolder viewHolder, T item, int position) {
        itemViewDelegateManager.convert(viewHolder, item, position);
    }

    public void onViewHolderCreated(XViewHolder viewHolder, View view) {
    }


}
