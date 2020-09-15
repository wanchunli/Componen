package com.anso.componen.ui.main;

import android.app.Activity;
import android.util.Log;

import com.anso.base.basemvp.BasePresenter;
import com.anso.base.bean.ErrorBean;
import com.anso.base.net.BaseHttpResponse;
import com.anso.base.net.RxObserverListener;
import com.anso.componen.api.RetrofitManager;
import com.anso.componen.bean.WeatherEntity;

import io.reactivex.Observable;

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
        if (mainView != null) {
            rxManager.addObserver(
                    RetrofitManager.getInstance().doRequest(
                            RetrofitManager.getInstance().getRequestService().getWeather(city_code),
                            new RxObserverListener<String>(mainView) {
                                @Override
                                public void onSuccess(String result) {
                                    Log.i("result", result);
                                    WeatherEntity bean = new WeatherEntity();
                                    bean.ganmao = "容易感冒";
                                    bean.pm10= "10";
                                    bean.quality = "空气质量优";
                                    bean.wendu= "33℃";
                                    mainView.getWeather(bean);
                                    mainView.toastWeather(result);
                                }

                            }));
        }
    }

}
