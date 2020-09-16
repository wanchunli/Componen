package com.anso.componen.ui.login;

import android.app.Activity;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.anso.base.basemvp.BasePresenter;
import com.anso.base.net.BaseHttpResponse;
import com.anso.base.net.RxObserverListener;
import com.anso.componen.api.API;
import com.anso.componen.api.ApiService;
import com.anso.componen.api.RetrofitManager;
import com.anso.componen.bean.Token;
import com.anso.componen.bean.UserBean;
import com.anso.componen.bean.UserConfig;
import com.anso.componen.bean.WeatherEntity;
import com.anso.componen.constants.SPConstans;
import com.anso.componen.utils.MD5Util;
import com.anso.componen.utils.SafeSpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.HeaderMap;

/**
 * Created by 开发部 on 2018/1/4.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    private Activity context;
    private LoginView loginView;

    public LoginPresenter(Activity context) {
        this.context = context;
    }

    public void demo() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        Observable
                .create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                        for (int i = 0; i < 10; i++) {
                            emitter.onNext(i);
                        }
                        emitter.onComplete();
                    }
                })
                .concatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Integer integer) throws Exception {
                        List<String> list = new ArrayList<>();
                        list.add(String.valueOf(0));
                        list.add(String.valueOf(1));
                        return Observable.fromIterable(list).delay(100, TimeUnit.MILLISECONDS);
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("concatMap", s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void login() {
        final String deviceId = Settings.System.getString(
                context.getContentResolver(), Settings.Secure.ANDROID_ID);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("loginName", "cxl");
        jsonObject.put("password", MD5Util.getMD5("qy123456"));
        jsonObject.put("deviceImei", deviceId);
        jsonObject.put("deviceToken", "");//UserConfig.getuMengToken()  TODO
        jsonObject.put("deviceType", "MIX");//手机名称
        jsonObject.put("deviceName", "MIX");//手机厂商
        jsonObject.put("deviceVer", "小米");//手机厂商
        jsonObject.put("loginType", "PWD");//登陆类型 FACE(人脸),FINGER(指纹),PWD(密码)
        jsonObject.put("loginAddress", "");//登陆地点
        jsonObject.put("latitude", 0);//纬度
        jsonObject.put("longitude", 0);//经度
        Log.i("json", jsonObject.toJSONString());
        MediaType type = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(type, jsonObject.toJSONString());
        loginView = getView();
        if (loginView != null) {
            rxManager.addObserver(
                    RetrofitManager.getInstance().doRequest(
                            RetrofitManager.getInstance().getRequestService().login(body),
                            new RxObserverListener<Token>(loginView) {
                                @Override
                                public void onSuccess(Token token) {
                                    Log.i("token==", token.toString());
                                }
                            }));
        }
    }

    public void chain() {
        final String deviceId = Settings.System.getString(
                context.getContentResolver(), Settings.Secure.ANDROID_ID);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("loginName", "cxl");
        jsonObject.put("password", MD5Util.getMD5("qy123456"));
        jsonObject.put("deviceImei", deviceId);
        jsonObject.put("deviceToken", "");//UserConfig.getuMengToken()  TODO
        jsonObject.put("deviceType", "MIX");//手机名称
        jsonObject.put("deviceName", "MIX");//手机厂商
        jsonObject.put("deviceVer", "小米");//手机厂商
        jsonObject.put("loginType", "PWD");//登陆类型 FACE(人脸),FINGER(指纹),PWD(密码)
        jsonObject.put("loginAddress", "");//登陆地点
        jsonObject.put("latitude", 0);//纬度
        jsonObject.put("longitude", 0);//经度
        Log.i("json", jsonObject.toJSONString());
        MediaType type = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(type, jsonObject.toJSONString());
        loginView = getView();
        if (loginView != null) {
            ApiService requestService = RetrofitManager.getInstance().loginRequestService();
            requestService
                    .login(body)
                    .subscribeOn(Schedulers.io())
                    .doOnNext(new Consumer<BaseHttpResponse<Token>>() {
                        @Override
                        public void accept(BaseHttpResponse<Token> tokenBaseHttpResponse) throws Exception {
                            Token data = tokenBaseHttpResponse.data;
                            SafeSpUtils.putString(SPConstans.USER_NAME, "cxl");
                            SafeSpUtils.putString(SPConstans.USER_PASS, "qy123456");
                            UserConfig.setUserToken(data.getToken());
                        }
                    })
                    .doOnError(new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) {
                            Log.i("throwable", throwable.getMessage());
                        }
                    })
                    .concatMap(new Function<BaseHttpResponse<Token>, Observable<BaseHttpResponse<UserBean>>>() {
                        @Override
                        public Observable<BaseHttpResponse<UserBean>> apply(BaseHttpResponse<Token> tokenBaseHttpResponse) throws Exception {
                            ApiService userService = RetrofitManager.getInstance().getRequestService();
                            return userService.getUserInfo();
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<BaseHttpResponse<UserBean>>() {

                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(BaseHttpResponse<UserBean> userBeanBaseHttpResponse) {
                            UserBean data = userBeanBaseHttpResponse.data;
                            loginView.loginResult(data);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }

}
