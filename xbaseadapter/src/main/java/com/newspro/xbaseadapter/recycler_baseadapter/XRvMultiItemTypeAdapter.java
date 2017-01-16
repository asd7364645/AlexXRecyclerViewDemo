package com.newspro.xbaseadapter.recycler_baseadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.newspro.xbaseadapter.recycler_baseadapter.delegate.ItemViewDelegate;
import com.newspro.xbaseadapter.recycler_baseadapter.delegate.ItemViewDelegateManager;

import java.util.List;

/**
 * Created by Alex on 2017/1/16.
 * Alex
 */

public class XRvMultiItemTypeAdapter<T> extends RecyclerView.Adapter<XRvViewHolder> {

    private Context context;
    private List<T> mDatas;

    private ItemViewDelegateManager<T> itemViewDelegateManager;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public XRvMultiItemTypeAdapter(Context context, List<T> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        itemViewDelegateManager = new ItemViewDelegateManager<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (useItemViewDelegateManager())
            return itemViewDelegateManager.getItemViewType(mDatas.get(position), position);
        return super.getItemViewType(position);
    }

    @Override
    public XRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewDelegate<T> itemViewDelegate = itemViewDelegateManager.getItemViewDelegate(viewType);
        int layoutId = itemViewDelegate.getLayoutId();
        XRvViewHolder xRvViewHolder = XRvViewHolder.createXRvViewHolder(context, parent, layoutId);
        onViewHolderCreated(xRvViewHolder, xRvViewHolder.getmConvertView());
        setListener(xRvViewHolder);
        return xRvViewHolder;
    }

    protected void setListener(final XRvViewHolder xRvViewHolder) {
        View convertView = xRvViewHolder.getmConvertView();
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(v, xRvViewHolder, xRvViewHolder.getAdapterPosition());
                }
            }
        });
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return onItemLongClickListener != null && onItemLongClickListener.onLongClick(v, xRvViewHolder, xRvViewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public void onBindViewHolder(XRvViewHolder holder, int position) {
        convert(holder, mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    private boolean useItemViewDelegateManager() {
        return itemViewDelegateManager.getDelegateCount() > 0;
    }

    /**
     * 创建完ViewHolder的处理
     *
     * @param xRvViewHolder
     * @param view
     */
    private void onViewHolderCreated(XRvViewHolder xRvViewHolder, View view) {

    }

    private void convert(XRvViewHolder holder, T item) {
        itemViewDelegateManager.convert(holder, item, holder.getAdapterPosition());
    }

    public XRvMultiItemTypeAdapter<T> addDelegate(ItemViewDelegate<T> itemViewDelegate) {
        itemViewDelegateManager.addDelegate(itemViewDelegate);
        return this;
    }

    public XRvMultiItemTypeAdapter<T> addDelegate(int type, ItemViewDelegate<T> itemViewDelegate) {
        itemViewDelegateManager.addDelegate(type, itemViewDelegate);
        return this;
    }

    public List<T> getmDatas() {
        return mDatas;
    }

    public interface OnItemClickListener {
        void onClick(View view, XRvViewHolder holder, int position);
    }

    public interface OnItemLongClickListener {
        boolean onLongClick(View view, XRvViewHolder holder, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
}
