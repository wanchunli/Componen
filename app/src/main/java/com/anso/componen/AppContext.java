package com.anso.componen;
import android.app.Application;

import com.anso.base.preference.PreferencesUtil;
import com.anso.componen.utils.SafeSpUtils;
import com.xiangxue.network.base.NetworkApi;

public class AppContext extends Application {

    private static AppContext sInstance;

    public static AppContext getInstance() {
        if (sInstance == null){
            sInstance = new AppContext();
        }
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SafeSpUtils.init(this);
        NetworkApi.init(new NetworkRequestInfo(this));
        PreferencesUtil.init(this);
    }

}
