package com.anso.componen.ui.main;
import android.Manifest;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.anso.base.basemvp.MVPBaseActivity;
import com.anso.base.bean.ErrorBean;
import com.anso.componen.R;
import com.anso.componen.bean.WeatherEntity;
import com.anso.componen.databinding.ActivityMainBinding;
import com.anso.componen.utils.PermissionPageUtils;
import com.tbruyelle.rxpermissions.RxPermissions;

import rx.functions.Action1;


public class MainActivity extends MVPBaseActivity<MainView, MainPresenter> implements MainView {

    public ActivityMainBinding binding;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(MainActivity.this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, provideContentViewId());
        super.onCreate(savedInstanceState);
        binding.setLifecycleOwner(this);
        binding.setActivity(this);
    }

    @Override
    public void initViews() {
        super.initViews();
        RxPermissions.getInstance(MainActivity.this)
                .request(Manifest.permission.INTERNET)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {//true表示获取权限成功（注意这里在android6.0以下默认为true）
                            mPresenter.getWeather("101030100");
                        } else {
                            PermissionPageUtils permissionPageUtils = new PermissionPageUtils(MainActivity.this, "com.anso.xinyu_outworkplatform");
                            permissionPageUtils.jumpPermissionPage();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {

    }

    public void getData(){
        mPresenter.getWeather("101030100");
    }

    @Override
    public void getWeather(WeatherEntity bean) {
        binding.setWeather(bean);
    }

    @Override
    public void toastWeather(String msg) {
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
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
        Toast.makeText(MainActivity.this,error.getMsg(),Toast.LENGTH_LONG).show();
    }
}
