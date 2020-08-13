package com.anso.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.anso.webview.databinding.ActivityWebViewBinding;
import com.anso.webview.utils.Constants;

public class WebViewActivity extends AppCompatActivity {

    private ActivityWebViewBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = DataBindingUtil.setContentView(WebViewActivity.this,R.layout.activity_web_view);
        viewBinding.webview.getSettings().setJavaScriptEnabled(true);
        viewBinding.webview.loadUrl("https://www.baidu.com");
        viewBinding.title.setText(getIntent().getStringExtra(Constants.TITLE));
        viewBinding.webview.getSettings().setJavaScriptEnabled(true);
        viewBinding.webview.loadUrl(getIntent().getStringExtra(Constants.URL));
        viewBinding.actionBar.setVisibility(getIntent().getBooleanExtra(Constants.IS_SHOW_ACTION_BAR, true)? View.VISIBLE:View.GONE);
        viewBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewActivity.this.finish();
            }
        });
    }
}
