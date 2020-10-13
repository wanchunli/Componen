package com.anso.componen.ui.main.home.news;

import android.text.TextUtils;

import com.anso.base.customview.BaseCustomViewModel;
import com.anso.base.mvvm.model.BaseCachedData;
import com.anso.base.mvvm.model.BaseMvvmModel;
import com.anso.base.preference.BasicDataPreferenceUtil;
import com.anso.common.picturetitleview.PictureTitleViewModel;
import com.anso.common.titleview.TitleViewModel;
import com.anso.componen.api.NewsApiInterface;
import com.anso.componen.bean.NewsChannelsBean;
import com.anso.componen.bean.NewsListBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiangxue.network.TecentNetworkApi;
import com.xiangxue.network.observer.BaseObserver;

import java.util.ArrayList;
import java.util.List;

public class NewsChannelModel extends BaseMvvmModel<NewsChannelsBean, List<NewsChannelsBean.ChannelList>> {

    public NewsChannelModel() {
        super(false, "NEWS_CHANNEL_PREF_KEY");
    }

    @Override
    public void load() {
        TecentNetworkApi.getService(NewsApiInterface.class)
                .getNewsChannels()
                .compose(TecentNetworkApi.getInstance().applySchedulers(new BaseObserver<NewsChannelsBean>() {
                    @Override
                    public void onSuccess(NewsChannelsBean newsChannelsBean) {
                        notifyResultToListener(newsChannelsBean, newsChannelsBean.showapiResBody.channelList);
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        loadFail(e.getMessage());
                    }
                }));
    }

    @Override
    public void loadLocal() {
        String dataStr = BasicDataPreferenceUtil.getInstance().getString("NEWS_CHANNEL_PREF_KEY", "");
        if (!TextUtils.isEmpty(dataStr)) {
            Gson gson = new Gson();
            BaseCachedData<NewsChannelsBean> cacheData = gson.fromJson(dataStr,new TypeToken<BaseCachedData<NewsChannelsBean>>(){}.getType());
            NewsChannelsBean newsChannelsBean = cacheData.data;
            notifyLocalData(newsChannelsBean.showapiResBody.channelList);
        }
    }

}
