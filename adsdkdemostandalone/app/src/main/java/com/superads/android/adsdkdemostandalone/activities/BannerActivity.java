package com.superads.android.adsdkdemostandalone.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.superads.android.adsdk.ads.providers.SuperAds;
import com.superads.android.adsdk.ads.providers.models.AdRequest;
import com.superads.android.adsdk.ads.rendering.view.AdListener;
import com.superads.android.adsdk.ads.rendering.view.BannerAdView;
import com.superads.android.adsdkdemostandalone.R;

public class BannerActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_banner);
        initLoadAndShowBannerButton();
    }

    private void initLoadAndShowBannerButton() {
        Button btnBanner = findViewById(R.id.btn_load);
        btnBanner.setOnClickListener(view -> {
            final BannerAdView bannerAdView = findViewById(R.id.card_banner);
            AdRequest.Builder builder = new AdRequest.Builder(SuperAds.genRandomPlacementId());
            bannerAdView.loadAd(builder.build(), new AdListener() {
                @Override
                public void onAdLoaded() {
                    bannerAdView.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Log.e("NativeExamplesActivity", "error generating ad, error code=" + errorCode);
                }
            });
        });
    }

}
