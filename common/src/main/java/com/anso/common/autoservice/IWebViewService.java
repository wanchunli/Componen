package com.anso.common.autoservice;

import android.content.Context;

public interface IWebViewService {
    void startWebViewActivity(Context context, String url, String title, boolean isShowActionBar);
}
