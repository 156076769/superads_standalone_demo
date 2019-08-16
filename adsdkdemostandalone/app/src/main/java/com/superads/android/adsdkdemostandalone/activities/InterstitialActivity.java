package com.superads.android.adsdkdemostandalone.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aitype.android.adsdk.ads.providers.models.AdRequest;
import com.aitype.android.adsdk.ads.rendering.view.AdListener;
import com.aitype.android.adsdk.ads.rendering.view.InterstitialAd;
import com.superads.android.adsdkdemostandalone.R;

public class InterstitialActivity extends BaseActivity {

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_interstitial);
        initLoadAndShowButton();
    }

    private void initLoadAndShowButton() {
        Button btnLoad = findViewById(R.id.btn_load);
        btnLoad.setText("Load Interstitial");
        btnLoad.setOnClickListener(view -> {
            AdRequest.Builder builder = new AdRequest.Builder("xxx");
            this.interstitialAd = new InterstitialAd(this);
            interstitialAd.loadAd(builder.build(), new AdListener() {
                @Override
                public void onAdLoaded() {
                    Toast.makeText(InterstitialActivity.this, "interstitial Ad load successfully", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Log.e("NativeExamplesActivity", "error generating ad, error code=" + errorCode);
                }

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                }
            });
        });

        View btnShow = findViewById(R.id.btn_show);
        btnShow.setOnClickListener(view -> {
            if (interstitialAd != null)
                interstitialAd.show();
        });
    }

}
