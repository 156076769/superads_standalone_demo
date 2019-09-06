package com.superads.android.adsdkdemostandalone.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.superads.android.adsdkdemostandalone.R;

import cn.superads.sdk.providers.models.AdRequest;
import cn.superads.sdk.providers.models.BannerSize;
import cn.superads.sdk.rendering.view.AdListener;
import cn.superads.sdk.rendering.view.AdView;

public class BannerActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_banner);
        initLoadAndShowBannerButton();
    }

    private void initLoadAndShowBannerButton() {
        Button btnBanner = findViewById(R.id.btn_load);
        final ViewGroup bannerContainer = findViewById(R.id.card_banner);
        btnBanner.setOnClickListener(view -> {
            final AdView adView = new AdView(this);
            AdRequest.Builder builder = new AdRequest.Builder("YOUR_PLACEMENT_ID_HERE");
            builder.adSize(BannerSize.MOBILE_BANNER_728x90);
            adView.loadAd(builder.build(), new AdListener() {
                @Override
                public void onAdLoaded() {
                    bannerContainer.addView(adView);
                    bannerContainer.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Log.e("NativeExamplesActivity", "error generating ad, error code=" + errorCode);
                }
            });
        });
    }

}
