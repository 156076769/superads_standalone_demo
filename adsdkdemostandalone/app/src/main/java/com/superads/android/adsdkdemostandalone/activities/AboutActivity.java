package com.superads.android.adsdkdemostandalone.activities;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.superads.android.adsdkdemostandalone.R;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AboutActivity extends BaseActivity {

    @SuppressLint("SetJavaScriptEnabled")
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

        //FbPlayableAd.onCTAClick();
//        webview1.addJavascriptInterface(new JSInterface(), "superAdsSDK");//superAdsSD
//        webview1.loadUrl("http://192.168.0.123:5500/playable.html");

        //webview1.loadUrl("file:///android_asset/SuperADS Stacker.html");

        //webview1.addJavascriptInterface(new JSInterface(), "superAdsSDK");//superAdsSDK

//        webview1.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return false;
//            }
//        });

        webview1.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage cm) {
                Log.d("MyApplication", cm.message() + " -- From line "
                        + cm.lineNumber() + " of "
                        + cm.sourceId() );
                return true;
            }
        });

        String playAbleHtmlData = "";

        webview1.loadData(playAbleHtmlData, "text/html", null);
        webview1.addJavascriptInterface(new SuperAdsJsInject(), "superAdsSDK");//inject superAdsSDK object to javascript
        webview1.loadUrl("playableURL");
    }

    public class SuperAdsJsInject {
        @JavascriptInterface
        public void call(String message) {
            Toast.makeText(AboutActivity.this, "txt123", Toast.LENGTH_LONG).show();
            //Open browser, jump to click URL
        }
    }

//    void setCros(WebView webview1) {
//        try {
//            if (Build.VERSION.SDK_INT >= 16) {
//                Class<?> clazz = webview1.getSettings().getClass();
//                Method method = clazz.getMethod(
//                        "setAllowUniversalAccessFromFileURLs", boolean.class);//利用反射机制去修改设置对象
//                if (method != null) {
//                    method.invoke(webview1.getSettings(), true);//修改设置
//                }
//            }
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }
}
