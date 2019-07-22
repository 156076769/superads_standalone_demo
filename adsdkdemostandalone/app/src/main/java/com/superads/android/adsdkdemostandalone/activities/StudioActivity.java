package com.superads.android.adsdkdemostandalone.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

import com.superads.android.adsdkdemostandalone.R;

public class StudioActivity extends Activity {

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

        webview1.loadUrl("https://play.gamewheel.com/editor/superads/");
    }

    private int getScale(){
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        Double val = new Double(width)/new Double(360 );
        val = val * 100d;
        return val.intValue();
    }
}
