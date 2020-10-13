package com.anso.componen.ui.login;

import android.app.Activity;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.anso.base.basemvp.BasePresenter;
import com.anso.componen.utils.MD5Util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import okhttp3.MediaType;
import okhttp3.RequestBody;

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

    public void chain() {
        final String deviceId = Settings.System.getString(
                context.getContentResolver(), Settings.Secure.ANDROID_ID);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("loginName", "106126");
        jsonObject.put("loginPassword", MD5Util.getMD5("ax123456"));
        jsonObject.put("deviceImei", deviceId);
        jsonObject.put("deviceToken", "");//UserConfig.getuMengToken()  TODO
        jsonObject.put("deviceType", "MIX");//手机名称
        jsonObject.put("deviceName", "MIX");//手机厂商

        Log.i("json", jsonObject.toJSONString());
        MediaType type = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(type, jsonObject.toJSONString());
        loginView = getView();
    }

}
