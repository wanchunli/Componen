package com.anso.componen.ui.main;

import android.app.Activity;
import android.util.Log;

import com.anso.base.basemvp.BasePresenter;

/**
 * Created by 开发部 on 2018/1/4.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private Activity context;
    private MainView mainView;

    public MainPresenter(Activity context) {
        this.context = context;
    }

    public void getWeather(String city_code) {
        mainView = getView();
    }

}
