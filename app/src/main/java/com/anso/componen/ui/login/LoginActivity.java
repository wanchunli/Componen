package com.anso.componen.ui.login;
import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.anso.base.basemvp.MVPBaseActivity;
import com.anso.base.bean.ErrorBean;
import com.anso.componen.R;
import com.anso.componen.bean.UserBean;
import com.anso.componen.bean.WeatherEntity;
import com.anso.componen.databinding.ActivityLoginBinding;
import com.anso.componen.databinding.ActivityMainBinding;
import com.anso.componen.utils.PermissionPageUtils;
import com.tbruyelle.rxpermissions.RxPermissions;

import rx.functions.Action1;


public class LoginActivity extends MVPBaseActivity<LoginView, LoginPresenter> implements LoginView {

    public ActivityLoginBinding binding;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(LoginActivity.this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_login;
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

    }

    @Override
    public void onClick(View v) {

    }

    public void login(){
        RxPermissions.getInstance(LoginActivity.this)
                .request(Manifest.permission.INTERNET)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {//true表示获取权限成功（注意这里在android6.0以下默认为true）
//                            mPresenter.login();
//                            mPresenter.chain();
                            mPresenter.demo();
                        } else {
                            PermissionPageUtils permissionPageUtils = new PermissionPageUtils(LoginActivity.this, "com.anso.xinyu_outworkplatform");
                            permissionPageUtils.jumpPermissionPage();
                        }
                    }
                });
    }

    @Override
    public void loginResult(UserBean bean) {
        Toast.makeText(LoginActivity.this,"登陆成功！！",Toast.LENGTH_LONG).show();
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
        Toast.makeText(LoginActivity.this,error.getMsg(),Toast.LENGTH_LONG).show();
    }
}
