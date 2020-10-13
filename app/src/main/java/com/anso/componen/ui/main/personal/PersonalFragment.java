package com.anso.componen.ui.main.personal;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.anso.base.basemvp.MVPBaseFragment;
import com.anso.base.bean.ErrorBean;
import com.anso.componen.R;

/**
 * Created by 开发部 on 2018/2/7.
 */

public class PersonalFragment extends MVPBaseFragment<PersonalView, PersonalPresenter> implements PersonalView {

    public static final String TAG = "PlatformFragment";


    public static PersonalFragment newInstance(int tabposition) {
        PersonalFragment fragment = new PersonalFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("TABPOSITION", tabposition);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected PersonalPresenter createPresenter() {
        return new PersonalPresenter(getActivity());
    }

    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_personal;
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
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    /**
     * 关闭服务
     * 先关闭守护进程，再关闭定位服务
     */
    private void stopLocationService() {
        Log.i("closeactivity", "closeactivity");
        getActivity().sendBroadcast(new Intent("com.anso.closeactivity"));
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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