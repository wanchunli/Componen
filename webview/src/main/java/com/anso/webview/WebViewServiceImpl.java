//package com.anso.webview;
//
//import android.content.Context;
//import android.content.Intent;
//
//import com.anso.common.autoservice.IWebViewService;
//import com.anso.webview.utils.Constants;
//import com.google.auto.service.AutoService;
//
//@AutoService({IWebViewService.class})
//public class WebViewServiceImpl implements IWebViewService {
//    @Override
//    public void startWebViewActivity(Context context, String url, String title, boolean isShowActionBar) {
//        if (context != null) {
//            Intent intent = new Intent(context, WebViewActivity.class);
//            intent.putExtra(Constants.TITLE, title);
//            intent.putExtra(Constants.URL, url);
//            intent.putExtra(Constants.IS_SHOW_ACTION_BAR, isShowActionBar);
//            context.startActivity(intent);
//        }
//    }
//}
