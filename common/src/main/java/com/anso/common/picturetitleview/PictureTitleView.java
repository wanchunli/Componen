package com.anso.common.picturetitleview;

import android.content.Context;
import android.view.View;

import com.anso.base.autoservice.BaseServiceLoader;
import com.anso.base.customview.BaseCustomView;
import com.anso.common.R;
import com.anso.common.autoservice.IWebViewService;
import com.anso.common.databinding.PictureTitleViewBinding;

public class PictureTitleView extends BaseCustomView<PictureTitleViewBinding, PictureTitleViewModel> {
    public PictureTitleView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.picture_title_view;
    }

    @Override
    public void onRootClicked(View view) {
//        WebviewActivity.startCommonWeb(getContext(), "News", data.jumpUri);
        IWebViewService iWebViewService = BaseServiceLoader.load(IWebViewService.class);
        if (iWebViewService != null) {
            iWebViewService.startWebViewActivity(getContext(), data.jumpUri, "News", false);
        }
    }

    @Override
    protected void setDataToView(PictureTitleViewModel pictureTitleViewModel) {
        binding.setViewModel(pictureTitleViewModel);
    }
}
