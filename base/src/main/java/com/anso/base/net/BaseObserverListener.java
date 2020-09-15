package com.anso.base.net;
import com.anso.base.bean.ErrorBean;

/**
 * Created by JoJo on 2018/10/1.
 * email：18510829974@163.com
 * description：自定义接口，处理联网请求结果的回调
 */
public interface BaseObserverListener<T> {
    void onSuccess(T result);
    void onComplete();
    void onError(Throwable e);
    void onBusinessError(ErrorBean errorBean);
}
