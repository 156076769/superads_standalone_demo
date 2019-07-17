package com.superads.android.adsdkdemostandalone;

import android.app.Application;

import com.superads.android.adsdk.ads.providers.SuperAds;
import com.superads.android.adsdk.ads.providers.SuperAdsConfig;

public class App extends Application {

    public static final String publisherId = "1069";
    public static final String appId = "27";

    @Override
    public void onCreate()
    {
        super.onCreate();
        SuperAdsConfig.debug = true;
        SuperAds.init(this, publisherId, appId);
    }
}
