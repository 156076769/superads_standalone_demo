package com.superads.android.adsdkdemostandalone.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.superads.android.adsdk.ads.providers.SuperAds;
import com.superads.android.adsdk.ads.providers.models.AdRequest;
import com.superads.android.adsdk.ads.rendering.view.AdListener;
import com.superads.android.adsdk.ads.rendering.view.InterstitialAdLoader;
import com.superads.android.adsdk.ads.rendering.view.VideoAdLoader;
import com.superads.android.adsdkdemostandalone.R;

public class VideoActivity extends BaseActivity {

    private VideoAdLoader videoAdLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_interstitial);
        initLoadAndShowButton();
    }

    private void initLoadAndShowButton() {
        Button btnLoad = findViewById(R.id.btn_load);
        btnLoad.setText("Load Video");
        btnLoad.setOnClickListener(view -> {
            AdRequest.Builder builder = new AdRequest.Builder(SuperAds.genRandomPlacementId());
            this.videoAdLoader = new VideoAdLoader(this);
            videoAdLoader.loadAd(builder.build(), new AdListener() {
                @Override
                public void onAdLoaded() {
                    Toast.makeText(VideoActivity.this, "video Ad load successfully", Toast.LENGTH_SHORT).show();
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
            if (videoAdLoader != null && videoAdLoader.isloaded())
                videoAdLoader.show();
        });
    }

}
