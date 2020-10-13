package com.anso.componen.ui.main.home.newslist;

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

public class NewsListModel extends BaseMvvmModel<NewsListBean, List<BaseCustomViewModel>> {
    private String mChannelId;
    private String mChannelName;
    private String mCachedPreferenceKey;

    public NewsListModel(String channelId, String channelName) {
        super(true, channelId + channelName + "_preference_key", 1);
        mChannelId = channelId;
        mChannelName = channelName;
        mCachedPreferenceKey = channelId + channelName + "_preference_key";
    }

    @Override
    public void load() {
        TecentNetworkApi.getService(NewsApiInterface.class)
                .getNewsList(mChannelId,
                        mChannelName, String.valueOf(mPage))
                .compose(TecentNetworkApi.getInstance().applySchedulers(new BaseObserver<NewsListBean>() {
                    @Override
                    public void onSuccess(NewsListBean newsListBean) {
                        List<BaseCustomViewModel> viewModels = new ArrayList<>();
                        for (NewsListBean.Contentlist contentlist : newsListBean.showapiResBody.pagebean.contentlist) {
                            if (contentlist.imageurls != null && contentlist.imageurls.size() > 0) {
                                PictureTitleViewModel pictureTitleViewModel = new PictureTitleViewModel();
                                pictureTitleViewModel.pictureUrl = contentlist.imageurls.get(0).url;
                                pictureTitleViewModel.jumpUri = contentlist.link;
                                pictureTitleViewModel.title = contentlist.title;
                                viewModels.add(pictureTitleViewModel);
                            } else {
                                TitleViewModel titleViewModel = new TitleViewModel();
                                titleViewModel.jumpUri = contentlist.link;
                                titleViewModel.title = contentlist.title;
                                viewModels.add(titleViewModel);
                            }
                        }
                        notifyResultToListener(newsListBean, viewModels);
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        loadFail(e.getMessage());
                    }
                }));
    }

    @Override
    public void loadLocal() {
        String dataStr = BasicDataPreferenceUtil.getInstance().getString(mCachedPreferenceKey, "");
        if (!TextUtils.isEmpty(dataStr)) {
            Gson gson = new Gson();
            BaseCachedData<NewsListBean> cacheData = gson.fromJson(dataStr, new TypeToken<BaseCachedData<NewsListBean>>(){}.getType());
            NewsListBean newsListBean = cacheData.data;
            List<BaseCustomViewModel> viewModels = new ArrayList<>();
            for (NewsListBean.Contentlist contentlist : newsListBean.showapiResBody.pagebean.contentlist) {
                if (contentlist.imageurls != null && contentlist.imageurls.size() > 0) {
                    PictureTitleViewModel pictureTitleViewModel = new PictureTitleViewModel();
                    pictureTitleViewModel.pictureUrl = contentlist.imageurls.get(0).url;
                    pictureTitleViewModel.jumpUri = contentlist.link;
                    pictureTitleViewModel.title = contentlist.title;
                    viewModels.add(pictureTitleViewModel);
                } else {
                    TitleViewModel titleViewModel = new TitleViewModel();
                    titleViewModel.jumpUri = contentlist.link;
                    titleViewModel.title = contentlist.title;
                    viewModels.add(titleViewModel);
                }
            }
            notifyLocalData(viewModels);
        }
    }

}
