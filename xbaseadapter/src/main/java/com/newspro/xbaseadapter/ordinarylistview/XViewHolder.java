package com.newspro.xbaseadapter.ordinarylistview;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Alex on 2017/1/12.
 * Alex
 * <p>
 * 通用listView,GridView的ViewHolder
 */
public class XViewHolder {

    /**
     * 存储每个Item中View的集合，方便查找控件
     */
    private SparseArray<View> mViews;
    private Context context;
    /**
     * itemView复用的convertView
     */
    private View mConvertView;
    /**
     * 布局Id
     */
    private int layoutId;

    private int position;

    public XViewHolder(Context context, View itemView, int layoutId, int position) {
        mViews = new SparseArray<>();
        this.context = context;
        this.mConvertView = itemView;
        this.layoutId = layoutId;
        this.position = position;
        mConvertView.setTag(this);
    }

    public XViewHolder(Context context, View itemView, int position) {
        mViews = new SparseArray<>();
        this.context = context;
        this.mConvertView = itemView;
        this.position = position;
        mConvertView.setTag(this);
    }

    /**
     * 得到当前Item布局的viewHolder
     * 封装adapter中getView方法中的过程
     *
     * @param convertView
     * @param layoutId
     * @return
     */
    public static XViewHolder getHolder(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            //实例化布局view
            convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
            //创建ViewHolder
            XViewHolder xViewHolder = new XViewHolder(context, convertView, layoutId, position);
            //设置布局ID
            xViewHolder.layoutId = layoutId;
            xViewHolder.viewHolderCreated(xViewHolder, convertView);
            return xViewHolder;
        } else {
            //从adapter中的convertView得到tag，
            // 因为convertView==null 创建ViewHolder的时候给convertView设置了tag了，所以这里直接拿tag
            XViewHolder xViewHolder = (XViewHolder) convertView.getTag();
            //由于getTag拿到的是之前的ViewHolder,所以position可能不会更新，在这里更新
            xViewHolder.position = position;
            return xViewHolder;
        }
    }

    public void viewHolderCreated(XViewHolder holder, View convertView) {
    }

    public <V extends View> V getItemView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (V) view;
    }

    public Context getContext() {
        return context;
    }

    public View getmConvertView() {
        return mConvertView;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public void updatePosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
