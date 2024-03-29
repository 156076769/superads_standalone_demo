package com.superads.android.adsdkdemostandalone.activities;

import android.os.Bundle;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.superads.android.adsdkdemostandalone.R;

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
        reycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        loadNativeAds();
    }

    private void loadNativeAds() {
//        NativeAdRequest.Builder builder = new NativeAdRequest.Builder("YOUR_PLACEMENT_ID_HERE", new NativeAdRequest.OnNativeAdLoadedListener() {
//            @Override
//            public void onNativeAdLoaded(NativeAd nativeAd) {
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        refreshRecycleView(nativeAd);
//                    }
//                }, 3000);
//
//            }
//        });
//
//        final NativeAdLoader nativeAd = new NativeAdLoader(NativeActivity.this);
//        nativeAd.loadAd(builder.build(), new AdListener() {
//            @Override
//            public void onAdLoaded() {
//                Log.i("NativeAdapter", "native ad loaded");
//            }
//
//            @Override
//            public void onAdFailedToLoad(int errorCode) {
//                Log.e("NativeAdapter", "error generating ad, error code=" + errorCode);
//            }
//
//            @Override
//            public void onAdClicked() {
//                super.onAdClicked();
//                Log.i("NativeAdapter", "onAdClicked");
//            }
//
//            @Override
//            public void onAdImpression() {
//                super.onAdImpression();
//                Log.i("NativeAdapter", "onAdImpression");
//            }
//        });
    }

//    private void refreshRecycleView(NativeAd nativeAd) {
//        List<ItemData> items = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            ItemData data = new ItemData();
//            data.type = ItemData.Type.NORMAL;
//            data.data = "txt";
//            items.add(data);
//        }
//
//        int dataType = getIntent().getIntExtra("nativeAdType", 1);
//        switch (dataType) {
//            case 1: {
//                ItemData adItem = new ItemData();
//                adItem.type = ItemData.Type.NATIVE_AD_BANNER;
//                adItem.data = nativeAd;
//                items.add(1, adItem);
//                reycler.setAdapter(new NativeAdapter(items));
//            }
//            break;
//            case 2:
//            default: {
//                ItemData adItem = new ItemData();
//                adItem.type = ItemData.Type.NATIVE_AD_FEED;
//                adItem.data = nativeAd;
//                items.add(1, adItem);
//                reycler.setAdapter(new NativeAdapter(items));
//            }
//            break;
//        }
//    }

}
