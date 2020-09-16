package com.anso.componen;
import android.app.Application;

import com.anso.componen.utils.SafeSpUtils;

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
    }

}
