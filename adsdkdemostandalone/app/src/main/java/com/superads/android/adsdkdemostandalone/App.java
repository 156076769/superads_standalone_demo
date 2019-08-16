package com.superads.android.adsdkdemostandalone;

import android.app.Application;

import com.aitype.android.adsdk.ads.providers.SuperAds;

public class App extends Application {

//    public static final String publisherId = "1111";
//    public static final String appId = "29";
    public static final String publisherId = "1140";
    public static final String appId = "31";

    @Override
    public void onCreate()
    {
        super.onCreate();

        SuperAds.init(this, publisherId);
    }
}
