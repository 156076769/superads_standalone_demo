package com.superads.android.adsdkdemostandalone.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.superads.android.adsdkdemostandalone.R;

import cn.superads.sdk.providers.models.AdRequest;
import cn.superads.sdk.providers.models.VideoSize;
import cn.superads.sdk.rendering.view.AdListener;
import cn.superads.sdk.rendering.view.RewardedVideoAd;

public class RewardedVideoActivity extends BaseActivity {

    private RewardedVideoAd videoAdLoader;

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
            AdRequest.Builder builder = new AdRequest.Builder("YOUR_PLACEMENT_ID_HERE");
            builder.adSize(VideoSize.VIDEO_1280x720);
            this.videoAdLoader = new RewardedVideoAd(this);
            videoAdLoader.loadAd(builder.build(), new AdListener() {
                @Override
                public void onAdLoaded() {
                    Toast.makeText(RewardedVideoActivity.this, "video Ad load successfully", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Log.e("VideoActivity", "error generating ad, error code=" + errorCode);
                }

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                }

                @Override
                public void onVideoCompleted() {
                }

                @Override
                public void onVideoRewarded() {
                    Log.i("VideoActivity", "**video rewarded!");
                }
            });
        });

        View btnShow = findViewById(R.id.btn_show);
        btnShow.setOnClickListener(view -> {
            if (videoAdLoader != null)
                videoAdLoader.show();
        });
    }

}
