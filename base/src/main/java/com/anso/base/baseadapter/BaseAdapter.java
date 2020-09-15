package com.anso.base.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.anso.base.utils.CommonViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有Adapter的基类
 * BaseAdapter
 * author wanchun
 * email 1596900283@qq.com
 * create 2018/3/5 14:27
 */
public class BaseAdapter<T> extends RecyclerView.Adapter<CommonViewHolder> {
    public final static int STATUS_LOADING_MORE = 0;//加载更多
    public final static int NOT_EMPTY_VIEW = -1;//数据不为空
    public final static int STATUS_EMPTY = 1;//数据为空
    public final static int STATUS_LOADING = 2;//正在加载
    public final static int STATUS_LOAD_ALL = 3;//加载完成

    public int loadingstatus = 0;//加载状态
    public final int ITEM_FOOTER = 2;
    public final int ITEM_CONTENT = 1;
    private List<T> list;
    protected Context context;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;
    private OnCellItemClickListener onCellItemClickListener;
    private OnItemDeleteClickListener onItemDeleteClickListener;

    private OnItemRadioClickListener onItemRadioClickListener;
    private OnTextClickListener onTextClickListener;

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
            setLoadingstatus(BaseAdapter.STATUS_EMPTY);
        } else {
            if (getList().size() < totalCount) {
                setLoadingstatus(BaseAdapter.STATUS_LOADING_MORE);
            } else if (getList().size() == totalCount) {
                setLoadingstatus(BaseAdapter.STATUS_LOAD_ALL);
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

    public interface OnItemLongClickListener {
        void onItemLongClickListener(View view, int position);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public OnItemLongClickListener getOnItemLongClickListener() {
        return onItemLongClickListener;
    }

    public interface OnTextClickListener {
        void onTextClickListener(View view, int position);
    }

    public void setOnTextClickListener(OnTextClickListener onTextClickListener) {
        this.onTextClickListener = onTextClickListener;
    }

    public OnTextClickListener getOnTextClickListener() {
        return onTextClickListener;
    }

    //删除
    public interface OnItemDeleteClickListener {
        void onItemDeleteClickListener(View view, int position);

        void onItemDeleteClickListener(View view, int parentPosition, int childPosition);
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


    //两层
    public interface OnCellItemClickListener {
        void onCellItemClickListener(View view, int parentPosition, int childPosition);
    }

    public void setOnCellItemClickListener(OnCellItemClickListener onCellItemClickListener) {
        this.onCellItemClickListener = onCellItemClickListener;
    }

    public OnCellItemClickListener getOnCellItemClickListener() {
        return onCellItemClickListener;
    }

    public BaseAdapter(Context context, List<T> list) {
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
    public CommonViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
       /* if (viewType == STATUS_EMPTY)
            return new CommonViewHolder(getView(viewGroup, R.layout.state_no_data_layout));*/
        return null;
    }

    @Override
    public void onBindViewHolder(CommonViewHolder commonViewHolder, int position) {

    }


    @Override
    public int getItemViewType(int position) {
        //根据传入adapter来判断是否有数据
        if (list != null && list.size() > 0)
            return NOT_EMPTY_VIEW;
        return STATUS_EMPTY;
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

}
