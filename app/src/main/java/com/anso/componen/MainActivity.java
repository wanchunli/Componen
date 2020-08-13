package com.anso.componen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.anso.base.autoservice.BaseServiceLoader;
import com.anso.common.autoservice.IWebViewService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IWebViewService iWebViewService = BaseServiceLoader.load(IWebViewService.class);
                if(iWebViewService!=null){
                    iWebViewService.startWebViewActivity(MainActivity.this,"https:www.baidu.com","百度",false);
                }
            }
        });
    }
}
