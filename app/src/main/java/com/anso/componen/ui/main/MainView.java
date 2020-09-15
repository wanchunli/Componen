package com.anso.componen.ui.main;
import com.anso.base.basemvp.BaseView;
import com.anso.componen.bean.WeatherEntity;

/**
 * Created by 开发部 on 2018/1/4.
 */

public interface MainView extends BaseView<MainPresenter> {
    void getWeather(WeatherEntity bean);
    void toastWeather(String msg);
}
