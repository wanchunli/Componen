package com.anso.componen.ui.main.home.newslist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.anso.base.customview.BaseCustomViewModel;
import com.anso.base.mvvm.model.BaseMvvmModel;
import com.anso.base.mvvm.model.IBaseModelListener;
import com.anso.base.mvvm.model.PagingResult;
import com.anso.common.utils.NetUtils;
import com.anso.componen.R;
import com.anso.componen.databinding.FragmentNewsBinding;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public class NewsListFragment extends Fragment implements IBaseModelListener<List<BaseCustomViewModel>> {

    private NewsListRecyclerViewAdapter mAdapter;
    private FragmentNewsBinding viewDataBinding;
    private NewsListModel mNewsListModel;
    private List<BaseCustomViewModel> viewModels = new ArrayList<>();

    protected final static String BUNDLE_KEY_PARAM_CHANNEL_ID = "bundle_key_param_channel_id";
    protected final static String BUNDLE_KEY_PARAM_CHANNEL_NAME = "bundle_key_param_channel_name";

    public static NewsListFragment newInstance(String channelId, String channelName) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY_PARAM_CHANNEL_ID, channelId);
        bundle.putString(BUNDLE_KEY_PARAM_CHANNEL_NAME, channelName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false);
        mAdapter = new NewsListRecyclerViewAdapter();
        viewDataBinding.listview.setHasFixedSize(true);
        viewDataBinding.listview.setLayoutManager(new LinearLayoutManager(getContext()));
        viewDataBinding.listview.setAdapter(mAdapter);
        mNewsListModel = new NewsListModel(getArguments().getString(BUNDLE_KEY_PARAM_CHANNEL_ID), getArguments().getString(BUNDLE_KEY_PARAM_CHANNEL_NAME));
        mNewsListModel.register(this);
        if (NetUtils.isNetworkConnected(getActivity())) {
            mNewsListModel.refresh();
        } else {
            mNewsListModel.loadLocal();
        }
        viewDataBinding.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (NetUtils.isNetworkConnected(getActivity())) {
                    mNewsListModel.refresh();
                } else {
                    Toast.makeText(getActivity(), "请检查网络~", Toast.LENGTH_SHORT).show();
                    viewDataBinding.refreshLayout.finishRefresh(1000,false);
                }
            }
        });
        viewDataBinding.refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (NetUtils.isNetworkConnected(getActivity())) {
                    mNewsListModel.loadNextPage();
                } else {
                    Toast.makeText(getActivity(), "请检查网络~", Toast.LENGTH_SHORT).show();
                    viewDataBinding.refreshLayout.finishLoadMore(1000,false,false);
                }
            }
        });
        return viewDataBinding.getRoot();
    }


    @Override
    public void onLoadSuccess(BaseMvvmModel model, List<BaseCustomViewModel> baseCustomViewModels, PagingResult... results) {
        if (results != null && results.length > 0 && results[0].isFirstPage) {
            viewModels.clear();
        }
        viewModels.addAll(baseCustomViewModels);
        mAdapter.setData(viewModels);
        viewDataBinding.refreshLayout.finishRefresh();
        viewDataBinding.refreshLayout.finishLoadMore();
    }

    @Override
    public void onLoadFail(BaseMvvmModel model, String message, PagingResult... results) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
