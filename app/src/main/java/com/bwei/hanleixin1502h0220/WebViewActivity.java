package com.bwei.hanleixin1502h0220;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Author ${韩磊鑫} on 2017/2/20 20:04
 * 邮箱：leixinhan@foxmail.com
 * 项目名称：
 * 类描述：
 * 修改人：${Oliver}
 * 修改备注：
 * 修改时间：
 */

public class WebViewActivity extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //引入相关布局文件
        setContentView(R.layout.activity_webview);

        //查找相关控件
        webview= (WebView) findViewById(R.id.wv);

        //传值
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);

        WebViewClient client = new WebViewClient();

        webview.setWebViewClient(client);
        webview.loadUrl(url);
    }
}
