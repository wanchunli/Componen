package com.anso.componen.bean;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anso.componen.constants.SPConstans;
import com.anso.componen.utils.SafeSpUtils;
import com.google.gson.Gson;
import java.util.Map;


public class UserConfig {
    /**
     * 登录后,这些数据必须拥有
     */

    //用户token
    private static String mUserToken;
    private static String mLoginType;
    private static int mUserId;

    //设置用户别名
    private static String uTag;
    //用户信息
    private static UserBean mUserBean;
    //权限信息
    private static Map<String, Boolean> userPermissionConfig;

    public static int getUserId() {
        mUserId = SafeSpUtils.getInt(SPConstans.USER_ID, -1);
        return mUserId;
    }

    public static void setUserId(int uId) {
        SafeSpUtils.putInt(SPConstans.USER_ID, uId);
        UserConfig.mUserId = uId;
    }

    public static void setuTag(String uTag) {
        SafeSpUtils.putString(SPConstans.UMENG_TOKEN, uTag);
        UserConfig.uTag = uTag;
    }

    public static String getUserToken() {
        if (!TextUtils.isEmpty(mUserToken)) {
            mUserToken = SafeSpUtils.getString(SPConstans.USER_TOKEN, "");
        }
        return mUserToken;
    }

    public static void setUserToken(String mUserToken) {
        SafeSpUtils.putString(SPConstans.USER_TOKEN, mUserToken);

        UserConfig.mUserToken = mUserToken;
    }

    public static String getLoginType() {
        if (!TextUtils.isEmpty(mLoginType)) {
            mLoginType = SafeSpUtils.getString(SPConstans.LOGIN_TYPE, "");
        }
        return mLoginType;
    }

    public static void setLoginType(String mLoginType) {
        SafeSpUtils.putString(SPConstans.LOGIN_TYPE, mLoginType);
        UserConfig.mLoginType = mLoginType;
    }

    public static UserBean getUserBean() {
        try {
            if (mUserBean == null) {
                mUserBean = new Gson().fromJson(SafeSpUtils.getString(SPConstans.USER_BEAN, null), UserBean.class);
//                initUserPermissionConfig();
            }
            return mUserBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void setUserBean(UserBean mUserBean) {
        SafeSpUtils.putString(SPConstans.USER_BEAN, new Gson().toJson(mUserBean));
        UserConfig.mUserBean = mUserBean;
//        initUserPermissionConfig();
    }

//    private static void initUserPermissionConfig() {
//        userPermissionConfig = new HashMap<>();
//        if (mUserBean != null && TextUtil.isValidate(mUserBean.getMenus())) {
//            for (UserBean.MenusBean menusBean : mUserBean.getMenus()) {
//                userPermissionConfig.put(menusBean.getUrl(), true);
//            }
//        }
//    }

    public static boolean hasPermission(String tag) {
        if (userPermissionConfig != null) {
            return userPermissionConfig.containsKey(tag);
        }
        return false;
    }


}
