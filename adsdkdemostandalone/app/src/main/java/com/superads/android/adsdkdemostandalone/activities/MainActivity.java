package com.superads.android.adsdkdemostandalone.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.superads.android.adsdkdemostandalone.R;
import com.superads.android.adsdkdemostandalone.models.DataType;
import com.superads.android.adsdk.ads.providers.SuperAds;
import com.superads.android.adsdk.ads.providers.SuperAdsConfig;
import com.superads.android.adsdk.ads.providers.models.AdRequest;
import com.superads.android.adsdk.ads.rendering.view.AdListener;
import com.superads.android.adsdk.ads.rendering.view.AdView;
import com.superads.android.adsdk.ads.rendering.view.InterstitialAdLoader;
import com.superads.android.adsdk.ads.rendering.view.VideoAdLoader;

public class MainActivity extends Activity {

    private InterstitialAdLoader interstitialAd;
    private ViewGroup bannerContainer;
    private VideoAdLoader videoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //CrashReport.setUserId(DeviceAddressUtil.getMACAddress("wlan0"));

        setContentView(R.layout.activity_main);
        initActivityButtons();

        View btnVideo = findViewById(R.id.btn_video);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdRequest.Builder builder = new AdRequest.Builder(SuperAds.genRandomPlacementId());
                videoAd = new VideoAdLoader(MainActivity.this);
                videoAd.loadAd(builder.build(), new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        videoAd.show();
                    }

                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                    }
                });
            }
        });

        View forceCrashButton = findViewById(R.id.force_crash);
        forceCrashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Object a = null;
//                Log.d("MainActivity", a.toString());
            }
        });

        SuperAdsConfig.debug = true;
        SuperAds.init(this, "1069", "27");
    }

    private void createAndShowBanner() {
        final AdView adView = new AdView(this);
        AdRequest.Builder builder = new AdRequest.Builder(SuperAds.genRandomPlacementId());
        adView.loadAd(builder.build(), new AdListener() {
            @Override
            public void onAdLoaded() {
                bannerContainer.addView(adView);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.e("MainActivity", "error generating ad, error code=" + errorCode);
            }
        });
    }

    private void createAndShowInterstitial() {
        AdRequest.Builder builder = new AdRequest.Builder(SuperAds.genRandomPlacementId());
        this.interstitialAd = new InterstitialAdLoader(this);
        interstitialAd.loadAd(builder.build(), new AdListener() {
            @Override
            public void onAdLoaded() {
                interstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.e("MainActivity", "error generating ad, error code=" + errorCode);
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }
        });
    }

    private void createAndShowNativeBanner() {
        Intent intent = new Intent(this,NativeActivity.class);
        intent.putExtra("adType", DataType.NATIVE_BANNER);
        startActivity(intent);
    }

    private void createAndShowFeedNative() {
        Intent intent = new Intent(this,NativeActivity.class);
        intent.putExtra("adType", DataType.NATIVE_FEED);
        startActivity(intent);
    }

    private void initActivityButtons() {
        bannerContainer = findViewById(R.id.card_banner);
        initLoadAndShowInterstitialButton();
        initLoadAndShowBannerButton();
        initLoadAndShowNativeBannerButton();
        initLoadAndShowNativeFeedButton();
    }

    private void initLoadAndShowBannerButton() {
        View btnBanner = findViewById(R.id.btn_banner);
        btnBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAndShowBanner();
            }
        });
    }

    private void initLoadAndShowInterstitialButton() {
        View btnInterstitial = findViewById(R.id.btn_interstitial);
        btnInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAndShowInterstitial();
            }
        });
    }

    private void initLoadAndShowNativeBannerButton() {
        View btnBanner = findViewById(R.id.btn_native_banner);
        btnBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAndShowNativeBanner();
            }
        });
    }

    private void initLoadAndShowNativeFeedButton() {
        View btnBanner = findViewById(R.id.btn_native_feed);
        btnBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAndShowFeedNative();
            }
        });
    }
}
