package com.anso.componen.ui.main.order;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anso.base.basemvp.MVPBaseFragment;
import com.anso.base.bean.ErrorBean;
import com.anso.componen.R;

/**
 * Created by 开发部 on 2018/2/7.
 */

public class OrderFragment extends MVPBaseFragment<OrderView, OrderPresenter> implements OrderView {

    public static OrderFragment newInstance(int tabposition) {
        OrderFragment fragment = new OrderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("TABPOSITION", tabposition);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected OrderPresenter createPresenter() {
        return new OrderPresenter(getActivity());
    }

    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }


    @Override
    protected void initView(View rootView) {

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
        }
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showBusinessError(ErrorBean error) {

    }

    @Override
    public void showException(ErrorBean error) {

    }
}