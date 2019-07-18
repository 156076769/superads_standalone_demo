package com.superads.android.adsdkdemostandalone.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;

import com.superads.android.adsdk.ads.providers.SuperAds;
import com.superads.android.adsdk.ads.providers.models.AdRequest;
import com.superads.android.adsdk.ads.rendering.view.AdListener;
import com.superads.android.adsdk.ads.rendering.view.AdView;
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
            final AdView adView = new AdView(BannerActivity.this);
            AdRequest.Builder builder = new AdRequest.Builder(SuperAds.genRandomPlacementId());
            adView.loadAd(builder.build(), new AdListener() {
                @Override
                public void onAdLoaded() {
                    ViewGroup bannerContainer = BannerActivity.this.findViewById(R.id.card_banner);
                    bannerContainer.addView(adView);
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Log.e("NativeExamplesActivity", "error generating ad, error code=" + errorCode);
                }
            });
        });
    }

}
