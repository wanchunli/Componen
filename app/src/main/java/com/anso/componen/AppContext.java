package com.anso.componen;
import android.app.Application;

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
    }

}
