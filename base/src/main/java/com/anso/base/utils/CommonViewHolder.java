package com.anso.base.utils;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Administrator on 2016/7/22.
 */
public class CommonViewHolder extends RecyclerView.ViewHolder {
    private View contentView;
    private SparseArray<View> mViews;
    public CommonViewHolder(View itemView) {
        super(itemView);
        this.contentView = itemView;
        this.mViews = new SparseArray<View>();
    }
    public CommonViewHolder setText(int viewId, String text){
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }
    public CommonViewHolder setImageResource(int viewId,int resId){
        ImageView img = getView(viewId);
        img.setImageResource(resId);
        return this;
    }
    public CommonViewHolder setTextColor(int viewId, int resId, Context context){
        TextView textView = getView(viewId);
        textView.setTextColor(context.getResources().getColor(resId));
        return this;
    }
    public CommonViewHolder setBackgroundColor(int viewId,int color){
        getView(viewId).setBackgroundColor(color);
        return this;
    }
    public CommonViewHolder setBackgroundResource(int viewId,int resid) {
        getView(viewId).setBackgroundResource(resid);
        return this;
    }

    public CommonViewHolder setChecked(int viewId,boolean ischeck){
        getView(viewId).setSelected(ischeck);
        return this;
    }

    public CommonViewHolder setOnClickListener(int viewId,
                                             View.OnClickListener listener)
    {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId)
    {
        View view = mViews.get(viewId);
        if (view == null)
        {
            view = contentView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

}
