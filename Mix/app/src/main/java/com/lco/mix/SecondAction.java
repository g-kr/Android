package com.lco.mix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SecondAction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_action);
        String name =getIntent().getStringExtra("name");
        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
        WebView webView=findViewById(R.id.webview);
        webView.loadUrl("http://www.google.com");
        webView.setWebViewClient(new WebViewClient());

    }
}
