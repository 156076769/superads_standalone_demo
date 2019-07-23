package com.superads.android.adsdkdemostandalone.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.superads.android.adsdk.ads.providers.models.NativeAd;
import com.superads.android.adsdkdemostandalone.R;
import com.superads.android.adsdkdemostandalone.models.ItemData;
import com.superads.android.adsdkdemostandalone.viewholders.ItemViewHolder;
import com.superads.android.adsdkdemostandalone.viewholders.NativeAdViewHolder;

import java.util.List;

public class NativeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemData> list;
    private final int NORMAL = 0;
    private final int AD = 1;

    public NativeAdapter(List<ItemData> items) {
        list = items;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).type != 100) {
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
                    .inflate(R.layout.list_item, parent, false);
            return new ItemViewHolder(v);
        } else {
            final View adContainer = LayoutInflater.from(parent.getContext()).inflate(R.layout.superads_native_ad_container, null);
            final View adView = LayoutInflater.from(parent.getContext()).inflate(R.layout.superads_native_ad, null);
            return new NativeAdViewHolder(adContainer, adView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemData data = list.get(position);
        if (data.type != 100) {
            String txt = (String) data.data;
            ((ItemViewHolder) holder).bindData(txt);
        } else {
            NativeAd nativeAd = (NativeAd)data.data;
            NativeAdViewHolder nativeAdViewHolder = (NativeAdViewHolder)holder;
            nativeAdViewHolder.bindData(nativeAd);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
