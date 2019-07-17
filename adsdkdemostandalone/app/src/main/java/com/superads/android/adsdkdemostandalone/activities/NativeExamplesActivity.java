package com.superads.android.adsdkdemostandalone.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.superads.android.adsdkdemostandalone.R;
import com.superads.android.adsdkdemostandalone.models.DataType;

public class NativeExamplesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.native_examples);
        initActivityButtons();

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
