package com.superads.android.adsdkdemostandalone.activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

import com.superads.android.adsdkdemostandalone.R;

public class PlayableActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_playable);

        WebView webview1 = (WebView) findViewById(R.id.webview1);
        webview1.getSettings().setJavaScriptEnabled(true);
        //webview1.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webview1.getSettings().setLoadWithOverviewMode(true);
        webview1.getSettings().setUseWideViewPort(true);
//        webview1.setWebViewClient(new WebViewClient());
//        webview1.setWebChromeClient(new WebChromeClient());
        //webview1.setPadding(0, 0, 0, 0);
        //webview1.setInitialScale(100);

        //webview1.loadUrl("http://192.168.0.105:8080/x/");
        //webview1.loadUrl("http://demo.gamewheel.com/collector/airplane/index.html");

        String game = getIntent().getStringExtra("game");
        webview1.loadUrl("file:///android_asset/" + game + ".html");
    }

    boolean needLandscape;

    @Override
    protected void onResume() {
        super.onResume();
    }

}
