package com.anso.base.basemvp;

import com.anso.base.bean.ErrorBean;

/**
 * 基础的view接口
 * BaseView
 * author wanchun
 * email 1596900283@qq.com
 * create 2018/3/5 14:18
 */
public interface BaseView<T> {
    /**
     * show loading message
     *
     * @param msg
     */
    void showLoading(String msg);

    /**
     * hide loading
     */
    void hideLoading();

    /**
     * show business error :网络异常及数据错误等异常情况
     */
    void showBusinessError(ErrorBean error);

    void showException(ErrorBean error);
}
