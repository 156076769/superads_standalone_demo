package com.superads.android.adsdkdemostandalone.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.superads.android.adsdk.ads.providers.SuperAds;
import com.superads.android.adsdk.ads.providers.models.NativeAd;
import com.superads.android.adsdk.ads.providers.models.NativeAdRequest;
import com.superads.android.adsdk.ads.rendering.view.AdListener;
import com.superads.android.adsdk.ads.rendering.view.NativeAdLoader;
import com.superads.android.adsdkdemostandalone.R;
import com.superads.android.adsdkdemostandalone.adapters.NativeAdapter;
import com.superads.android.adsdkdemostandalone.models.DataType;
import com.superads.android.adsdkdemostandalone.models.ItemData;

import java.util.ArrayList;
import java.util.List;

public class NativeActivity extends BaseActivity {

    private RecyclerView reycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native);
        init();
    }

    private void init() {
        reycler = findViewById(R.id.recycler);
        reycler.setHasFixedSize(true);
        reycler.setLayoutManager(new LinearLayoutManager(this));

        loadNativeAds();
    }

    private void loadNativeAds() {
        NativeAdRequest.Builder builder = new NativeAdRequest.Builder(SuperAds.genRandomPlacementId(), new NativeAdRequest.OnNativeAdLoadedListener() {
            @Override
            public void onNativeAdLoaded(NativeAd nativeAd) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshRecycleView(nativeAd);
                    }
                }, 3000);

            }
        });

        final NativeAdLoader nativeAd = new NativeAdLoader(NativeActivity.this);
        nativeAd.loadAd(builder.build(), new AdListener() {
            @Override
            public void onAdLoaded() {
                Log.i("NativeAdapter", "native ad loaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.e("NativeAdapter", "error generating ad, error code=" + errorCode);
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
                Log.i("NativeAdapter", "onAdClicked");
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
                Log.i("NativeAdapter", "onAdImpression");
            }
        });
    }

    private void refreshRecycleView(NativeAd nativeAd) {
        DataType dataType = DataType.NATIVE_BANNER;
        if (getIntent().hasExtra("adType")) {
            dataType = (DataType) getIntent().getSerializableExtra("adType");
        }

        List<ItemData> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemData data = new ItemData();
            data.type = 1;
            data.data = "txt";
            items.add(data);
        }
        ItemData adItem = new ItemData();
        adItem.type = 100;
        adItem.data = nativeAd;
        items.add(3, adItem);

        switch (dataType) {
            case NATIVE_BANNER:
                reycler.setAdapter(new NativeAdapter(items));
                break;
            case NATIVE_FEED:
            default:
                reycler.setAdapter(new NativeAdapter(items));
                break;
        }
    }

}
