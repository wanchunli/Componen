package com.anso.common.titleview;

import android.content.Context;
import android.view.View;

import com.anso.base.autoservice.BaseServiceLoader;
import com.anso.base.customview.BaseCustomView;
import com.anso.common.R;
import com.anso.common.autoservice.IWebViewService;
import com.anso.common.databinding.TitleViewBinding;
import com.anso.webview.WebViewActivity;

public class TitleView extends BaseCustomView<TitleViewBinding, TitleViewModel> {
    public TitleView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.title_view;
    }

    @Override
    public void onRootClicked(View view) {
        WebViewActivity.startCommonWeb(getContext(), "News", data.jumpUri);
//        IWebViewService iWebViewService = BaseServiceLoader.load(IWebViewService.class);
//        if (iWebViewService != null) {
//            iWebViewService.startWebViewActivity(getContext(), data.jumpUri, "News", false);
//        }
    }

    @Override
    protected void setDataToView(TitleViewModel titleViewModel) {
        binding.setViewModel(titleViewModel);
    }
}
