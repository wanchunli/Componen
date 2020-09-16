package com.anso.componen.ui.login;
import com.anso.base.basemvp.BaseView;
import com.anso.componen.bean.UserBean;
import com.anso.componen.bean.WeatherEntity;

/**
 * Created by 开发部 on 2018/1/4.
 */

public interface LoginView extends BaseView<LoginPresenter> {
    void loginResult(UserBean bean);
}
