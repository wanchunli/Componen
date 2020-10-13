package com.anso.componen.ui.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.anso.base.mvvm.model.BaseMvvmModel;
import com.anso.base.mvvm.model.IBaseModelListener;
import com.anso.base.mvvm.model.PagingResult;
import com.anso.common.utils.NetUtils;
import com.anso.componen.R;
import com.anso.componen.bean.NewsChannelsBean;
import com.anso.componen.databinding.FragmentHomeBinding;
import com.anso.componen.ui.main.home.news.HeadlineNewsFragmentAdapter;
import com.anso.componen.ui.main.home.news.NewsChannelModel;
import com.anso.componen.ui.main.order.OrderFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class HomeFragment extends Fragment implements IBaseModelListener<List<NewsChannelsBean.ChannelList>> {

    public HeadlineNewsFragmentAdapter adapter;
    FragmentHomeBinding viewDataBinding;
    private NewsChannelModel mNewsChannelModel;

    public static HomeFragment newInstance(int tabposition) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("TABPOSITION", tabposition);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        adapter = new HeadlineNewsFragmentAdapter(getChildFragmentManager());
        viewDataBinding.tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewDataBinding.viewpager.setAdapter(adapter);
        viewDataBinding.tablayout.setupWithViewPager(viewDataBinding.viewpager);
        viewDataBinding.viewpager.setOffscreenPageLimit(1);
        mNewsChannelModel = new NewsChannelModel();
        mNewsChannelModel.register(this);
        if (NetUtils.isNetworkConnected(getActivity())) {
            mNewsChannelModel.refresh();
        } else {
            mNewsChannelModel.loadLocal();
        }
        return viewDataBinding.getRoot();
    }

    @Override
    public void onLoadSuccess(BaseMvvmModel model, List<NewsChannelsBean.ChannelList> channelLists, PagingResult... results) {
        if (adapter != null) {
            adapter.setChannels(channelLists);
        }
    }

    @Override
    public void onLoadFail(BaseMvvmModel model, String message, PagingResult... results) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
