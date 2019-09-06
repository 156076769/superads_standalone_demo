package com.superads.android.adsdkdemostandalone.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.superads.android.adsdkdemostandalone.R;
import com.superads.android.adsdkdemostandalone.models.ItemData;
import com.superads.android.adsdkdemostandalone.viewholders.ItemViewHolder;
import com.superads.android.adsdkdemostandalone.viewholders.NativeAdViewHolder2;

import java.util.List;

import cn.superads.sdk.providers.models.NativeAdRequest;
import cn.superads.sdk.rendering.view.AdListener;
import cn.superads.sdk.rendering.view.NativeAd;

public class NativeAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemData> list;
    private final int NORMAL = 0;
    private final int NATIVE_AD_BANNER = 1;
    private final int NATIVE_AD_FEED = 2;

    public NativeAdapter2(List<ItemData> items) {
        list = items;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).type.equals(ItemData.Type.NATIVE_AD_BANNER)) {
            return NATIVE_AD_BANNER;
        } else if (list.get(position).type.equals(ItemData.Type.NATIVE_AD_FEED)) {
            return NATIVE_AD_FEED;
        } else {
            return NORMAL;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == NATIVE_AD_BANNER) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.superads_native_ad_container, parent, false);
            final View adView = LayoutInflater.from(parent.getContext()).inflate(R.layout.superads_native_ad_banner, null);
            NativeAdRequest.Builder builder = new NativeAdRequest.Builder(adView, "YOUR_PLACEMENT_ID_HERE")
                    .titleTextViewId(R.id.ad_txt_title)
                    .descriptionsTextViewId(R.id.ad_txt_description)
                    .callToActionTextViewId(R.id.ad_txt_cta)
                    .iconImageViewId(R.id.ad_img_icon);
            final NativeAd nativeAd = new NativeAd();
            nativeAd.loadAd(builder.build(), new AdListener() {
                @Override
                public void onAdLoaded() {
                    Log.i("NativeAdapter2","native ad loaded");
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Log.e("NativeAdapter2", "error generating ad, error code=" + errorCode);
                }
            });
            return new NativeAdViewHolder2(v, adView);
        } else if (viewType == NATIVE_AD_FEED) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.superads_native_ad_container, parent, false);
            final View adView = LayoutInflater.from(parent.getContext()).inflate(R.layout.superads_native_ad_feed, null);
            NativeAdRequest.Builder builder = new NativeAdRequest.Builder(adView, "YOUR_PLACEMENT_ID_HERE")
                    .titleTextViewId(R.id.ad_txt_title)
                    .descriptionsTextViewId(R.id.ad_txt_description)
                    .callToActionTextViewId(R.id.ad_txt_cta)
                    .bigImageViewId(R.id.ad_img)
                    .iconImageViewId(R.id.ad_img_icon);
            final NativeAd feedAd = new NativeAd();
            feedAd.loadAd(builder.build(), new AdListener() {
                @Override
                public void onAdLoaded() {
                    Log.i("NativeAdapter2","native ad loaded");
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Log.e("NativeAdapter2","error generating ad, error code=" + errorCode);
                }
            });
            return new NativeAdViewHolder2(v,adView);
        } else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            return new ItemViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemData data = list.get(position);
        if (list.get(position).type.equals(ItemData.Type.NORMAL)) {
            String txt = (String) data.data;
            ((ItemViewHolder) holder).bindData(txt);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
