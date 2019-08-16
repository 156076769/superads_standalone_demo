package com.superads.android.adsdkdemostandalone.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.superads.android.adsdkdemostandalone.R;
import com.superads.android.adsdkdemostandalone.models.ItemData;
import com.superads.android.adsdkdemostandalone.viewholders.ItemViewHolder;
import com.superads.android.adsdkdemostandalone.viewholders.NativeBannerAdViewHolder;
import com.superads.android.adsdkdemostandalone.viewholders.NativeFeedAdViewHolder;

import java.util.List;

public class NativeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemData> list;
    private final int NORMAL = 0;
    private final int NATIVE_AD_BANNER = 1;
    private final int NATIVE_AD_FEED = 2;
    public NativeAdapter(List<ItemData> items) {
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
            View adContainer = LayoutInflater.from(parent.getContext()).inflate(R.layout.superads_native_ad_container, parent, false);
            View adView = LayoutInflater.from(parent.getContext()).inflate(R.layout.superads_native_ad_banner, parent, false);
            return new NativeBannerAdViewHolder(adContainer, adView);
        }  if (viewType == NATIVE_AD_FEED) {
                View adContainer = LayoutInflater.from(parent.getContext()).inflate(R.layout.superads_native_ad_container, parent, false);
                View adView = LayoutInflater.from(parent.getContext()).inflate(R.layout.superads_native_ad_feed, parent, false);
                return new NativeFeedAdViewHolder(adContainer, adView);
        } else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            return new ItemViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemData data = list.get(position);
//        if (list.get(position).type.equals(ItemData.Type.NATIVE_AD_BANNER)) {
//            NativeAd nativeAd = (NativeAd)data.data;
//            NativeBannerAdViewHolder nativeAdViewHolder = (NativeBannerAdViewHolder)holder;
//            nativeAdViewHolder.bindData(nativeAd);
//        } else if (list.get(position).type.equals(ItemData.Type.NATIVE_AD_FEED)) {
//            NativeAd nativeAd = (NativeAd)data.data;
//            NativeFeedAdViewHolder nativeAdViewHolder = (NativeFeedAdViewHolder)holder;
//            nativeAdViewHolder.bindData(nativeAd);
//        } else
            {
            String txt = (String) data.data;
            ((ItemViewHolder) holder).bindData(txt);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
