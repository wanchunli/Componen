package com.anso.componen.utils;

import android.content.Context;
import android.content.SharedPreferences;

//*******************************************************
//* 项目名称：outwork-management
//* 创建者： Mr.Fang
//* 创建日期： 2018-09-14 9:46
//* Email：itfang@126.com
//* 描述：sp加密
//*******************************************************
public class SafeSpUtils {

    private static Context mContext;
    public static String PREFERENCE_NAME = "anso_pre";

    public static void init(Context context) {
        mContext = context;
    }
    private static void throwInit() {
        if (mContext == null) {
            throw new NullPointerException("在使用该方法前，需要init()方法，推荐init()放在application里");
        }
    }

    private static SharedPreferences.Editor getEditor() {

        return getSetting().edit();
    }

    private static SharedPreferences getSetting() {
        throwInit();
        return mContext.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);

    }


    //***************************PUT方法****************************
    public static void putString(String key, String value){
        getEditor().putString(key, value).commit();
    }
    public static void putInt(String key, int value){
        getEditor().putInt(key, value).commit();
    }

   /* public static void putInt(String key,String value){
        getEditor().putInt(key, value.length() > 0 ? Integer.parseInt(value.trim()) : 0).commit();

    }*/

    public static void putFloat(String key, float value){
        getEditor().putFloat(key, value).commit();



    }

    public static void putFloat(String key, String value){
        getEditor().putFloat(key, value.length() > 0 ? Float.parseFloat(value.trim()) : 0).commit();
    }

    public static void putLong(String key, long value){
        getEditor().putLong(key, value).commit();
    }



    public static void putBoolean(String key, boolean value){
        getEditor().putBoolean(key, value).commit();
    }

    //***************************GET方法****************************

    public static String getString(String key, String deff){
        return getSetting().getString(key, deff);
    }
    public static int getInt(String key, int def){
        return getSetting().getInt(key, def);
    }
    public static float getFloat(String key, float def){
        return getSetting().getFloat(key, def);
    }
    public static boolean getBoolean(String key, boolean def){
        return getSetting().getBoolean(key, def);
    }

    public static long getLong(String key, long def){
        return getSetting().getLong(key, def);
    }

    //***************************remove方法****************************
    public static void remove(String key){
        getEditor().remove(key).commit();
    }
    //***************************clear方法****************************
    public static void clearAll(){
        getEditor().clear().commit();
    }
    //***************************Contains方法****************************
    public static boolean isContains(String key){
        return getSetting().contains(key);
    }
}
