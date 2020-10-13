package com.anso.base.recyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anso.base.customview.BaseCustomViewModel;
import com.anso.base.customview.IBaseCustomView;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    public IBaseCustomView itemView;

    public BaseViewHolder(@NonNull IBaseCustomView itemView) {
        super((View) itemView);
        this.itemView = itemView;
    }

    public void bind(BaseCustomViewModel viewModel){
        this.itemView.setData(viewModel);
    }
}
