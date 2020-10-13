package com.anso.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.anso.webview.databinding.ActivityWebViewBinding;
import com.anso.webview.utils.Constants;

public class WebViewActivity extends AppCompatActivity {

    private String title;
    private String url;
    private ActivityWebViewBinding viewBinding;

    public static void startCommonWeb(Context context, String title, String url) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(Constants.TITLE, title);
        intent.putExtra(Constants.URL, url);
        if (context instanceof Service) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getIntent().getStringExtra(Constants.TITLE);
        url = getIntent().getStringExtra(Constants.URL);
        viewBinding = DataBindingUtil.setContentView(WebViewActivity.this, R.layout.activity_web_view);
        viewBinding.webview.getSettings().setJavaScriptEnabled(true);
        viewBinding.webview.loadUrl(url);
        viewBinding.title.setText(title);
//        viewBinding.webview.getSettings().setJavaScriptEnabled(true);
//        viewBinding.webview.loadUrl(getIntent().getStringExtra(Constants.URL));
        viewBinding.actionBar.setVisibility(getIntent().getBooleanExtra(Constants.IS_SHOW_ACTION_BAR, true) ? View.VISIBLE : View.GONE);
        viewBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewActivity.this.finish();
            }
        });

        viewBinding.webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }
}
