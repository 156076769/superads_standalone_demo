package com.superads.android.adsdkdemostandalone.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.superads.android.adsdkdemostandalone.R;
import com.superads.android.adsdkdemostandalone.models.DataType;
import com.superads.android.adsdkdemostandalone.models.NativeData;
import com.superads.android.adsdkdemostandalone.viewholders.NativeAdViewHolder;
import com.superads.android.adsdkdemostandalone.viewholders.NativeFeedDataViewHolder;
import com.superads.android.adsdk.ads.providers.SuperAds;
import com.superads.android.adsdk.ads.providers.models.NativeAdRequest;
import com.superads.android.adsdk.ads.rendering.view.AdListener;
import com.superads.android.adsdk.ads.rendering.view.NativeAdLoader;

import java.util.List;

public class NativeFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NativeData> list;
    private final int NORMAL = 0;
    private final int AD = 1;

    public NativeFeedAdapter(List<NativeData> items) {
        list = items;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getType() == DataType.NORMAL) {
            return NORMAL;
        } else {
            return AD;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        if (viewType == NORMAL) {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.native_feed_item, parent, false);
            return new NativeFeedDataViewHolder(v);
        } else {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.native_banner_ad, parent, false);
            final View adView = LayoutInflater.from(parent.getContext()).inflate(R.layout.native_ad_example_feed_ad, null);
            NativeAdRequest.Builder builder = new NativeAdRequest.Builder(adView, SuperAds.genRandomPlacementId())
                    .titleTextViewId(R.id.ad_txt_title)
                    .descriptionsTextViewId(R.id.ad_txt_description)
                    .callToActionTextViewId(R.id.ad_txt_cta)
                    .bigImageViewId(R.id.ad_img)
                    .iconImageViewId(R.id.ad_img_icon);
            final NativeAdLoader feedAd = new NativeAdLoader();
            feedAd.loadAd(builder.build(), new AdListener() {
                @Override
                public void onAdLoaded() {
                    Log.i("NativeFeedAdapter", "native ad loaded");
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Log.e("NativeFeedAdapter", "error generating ad, error code=" + errorCode);
                }
            });
            return new NativeAdViewHolder(v,adView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NativeData data = list.get(position);
        if (data.getType() == DataType.NORMAL) {
            ((NativeFeedDataViewHolder) holder).bindData(data);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}