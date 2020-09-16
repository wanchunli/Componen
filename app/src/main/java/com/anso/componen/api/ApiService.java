package com.anso.componen.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.anso.base.net.BaseHttpResponse;
import com.anso.componen.bean.Token;
import com.anso.componen.bean.UserBean;
import com.anso.componen.bean.WeatherEntity;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * author : JOJO
 * e-mail : 18510829974@163.com
 * date   : 2018/11/21 2:35 PM
 * desc   : 网络请求接口的配置
 */
public interface ApiService {
    //获取北京的天气信息
//    "https://www.sojson.com/open/api/weather/json.shtml?city=" + "北京"
    @GET("weather/json.shtml")
    Observable<Object> getWeatherNormal(@Query("city") String city);

    //添加的city_code = 101030100
//    http://t.weather.sojson.com/api/weather/city/+city_code”
//    http://wthrcdn.etouch.cn/weather_mini?citykey=101180101
    @GET("weather_mini")
    Observable<BaseHttpResponse<String>> getWeather(@Query("citykey") String city_code);

    @POST("auth/jwt/token")
    Observable<BaseHttpResponse<Token>> login(@Body RequestBody body);

    @GET("auth/user/get")
    Observable<BaseHttpResponse<UserBean>> getUserInfo();
}