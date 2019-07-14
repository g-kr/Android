package com.lco.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class SecondAction extends AppCompatActivity {
    WebView wb;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_action);

        wb=findViewById(R.id.webV);
        progress=findViewById(R.id.progressbar);
        String str=getIntent().getStringExtra("url");
        wb.loadUrl(str);
        wb.setWebViewClient(new WebViewClient());
        WebSettings wbsettings=wb.getSettings();
        wbsettings.setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progress.setVisibility(View.VISIBLE);
                setTitle("loading");
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progress.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(wb.canGoBack()){
            wb.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
