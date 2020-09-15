package com.anso.base.utils;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class DragViewHolder extends RecyclerView.ViewHolder {

    private View contentView;
    private SparseArray<View> mViews;

    public DragViewHolder(View itemView, Context context , int column) {
        super(itemView);
        this.contentView = itemView;
        this.mViews = new SparseArray<View>();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        layoutParams.height = width / column;
        itemView.setLayoutParams(layoutParams);
    }

    public DragViewHolder setText(int viewId, String text){
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }
    public DragViewHolder setImageResource(int viewId,int resId){
        ImageView img = getView(viewId);
        img.setImageResource(resId);
        return this;
    }
    public DragViewHolder setTextColor(int viewId, int resId, Context context){
        TextView textView = getView(viewId);
        textView.setTextColor(context.getResources().getColor(resId));
        return this;
    }
    public DragViewHolder setBackgroundColor(int viewId,int color){
        getView(viewId).setBackgroundColor(color);
        return this;
    }
    public DragViewHolder setBackgroundResource(int viewId,int resid) {
        getView(viewId).setBackgroundResource(resid);
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
