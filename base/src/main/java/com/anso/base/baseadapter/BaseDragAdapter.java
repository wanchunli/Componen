package com.anso.base.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.anso.base.utils.DragViewHolder;
import com.anso.base.utils.MyItemTouchCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 所有Adapter的基类
 * BaseAdapter
 * author wanchun
 * email 1596900283@qq.com
 * create 2018/3/5 14:27
 */
public class BaseDragAdapter<T> extends RecyclerView.Adapter<DragViewHolder> implements MyItemTouchCallback.ItemTouchAdapter {
    public final static int STATUS_LOADING_MORE = 0;//加载更多
    public final static int STATUS_EMPTY = 1;//数据为空
    public final static int STATUS_LOADING = 2;//正在加载
    public final static int STATUS_LOAD_ALL = 3;//加载完成

    public int loadingstatus = 0;//加载状态
    public final int ITEM_FOOTER = 2;
    public final int ITEM_CONTENT = 1;
    private List<T> list;
    protected Context context;
    private OnItemClickListener onItemClickListener;
    private OnSymbolItemClickListener onSymbolItemClickListener;
    private OnItemDeleteClickListener onItemDeleteClickListener;

    private OnItemRadioClickListener onItemRadioClickListener;

    public void setLoadingstatus(int loadingstatus) {
        this.loadingstatus = loadingstatus;
    }


    public String getLoadingStatus() {
        if (loadingstatus == 1) {
            return "数据为空";
        } else if (loadingstatus == 2) {
            return "正在加载...";
        } else if (loadingstatus == 3) {
            return "已加载全部";
        } else {
            return "加载更多";
        }
    }

    public void refreshFooterView(long totalCount) {
        if (totalCount == 0) {
            setLoadingstatus(BaseDragAdapter.STATUS_EMPTY);
        } else {
            if (getList().size() < totalCount) {
                setLoadingstatus(BaseDragAdapter.STATUS_LOADING_MORE);
            } else if (getList().size() == totalCount) {
                setLoadingstatus(BaseDragAdapter.STATUS_LOAD_ALL);
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClickListener(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    //删除
    public interface OnItemDeleteClickListener {
        void onItemDeleteClickListener(View view, int position);
    }

    public void setOnItemDeleteClickListener(OnItemDeleteClickListener onItemDeleteClickListener) {
        this.onItemDeleteClickListener = onItemDeleteClickListener;
    }


    //选中
    public interface OnItemRadioClickListener {
        void onItemRadioClickListener(View view, int position);
    }

    public void setOnItemRadioClickListener(OnItemRadioClickListener onItemRadioClickListener) {
        this.onItemRadioClickListener = onItemRadioClickListener;
    }

    public OnItemRadioClickListener getOnItemRadioClickListener() {
        return onItemRadioClickListener;
    }



    public OnItemDeleteClickListener getOnItemDeleteClickListener() {
        return onItemDeleteClickListener;
    }


    //checkBox
    public interface OnSymbolItemClickListener {
        void onSymbolItemClickListener(View view, int position, int symbolSign);
    }

    public void setOnSymbolItemClickListener(OnSymbolItemClickListener onSymbolItemClickListener) {
        this.onSymbolItemClickListener = onSymbolItemClickListener;
    }

    public OnSymbolItemClickListener getOnSymbolItemClickListener() {
        return onSymbolItemClickListener;
    }

    public BaseDragAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }


    public View getView(ViewGroup viewGroup, int resId) {
        return LayoutInflater.from(context).inflate(resId, viewGroup, false);
    }

    @Override
    public DragViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(DragViewHolder dragViewHolder, int position) {

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public void onMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(list, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(list, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onSwiped(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }
}
