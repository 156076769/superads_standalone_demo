package com.superads.android.adsdkdemostandalone.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.superads.android.adsdkdemostandalone.R;

public class NativeExamplesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_native_examples);
        initActivityButtons();

    }
    private void createAndShowNativeBanner() {
        Intent intent = new Intent(this,NativeActivity2.class);
        intent.putExtra("nativeAdType", 1); //1表示原生Banner广告
        startActivity(intent);
    }

    private void createAndShowFeedNative() {
        Intent intent = new Intent(this,NativeActivity2.class);
        intent.putExtra("nativeAdType", 2); //2表示原生Feed广告
        startActivity(intent);
    }

    private void initActivityButtons() {
        initLoadAndShowNativeBannerButton();
        initLoadAndShowNativeFeedButton();
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
