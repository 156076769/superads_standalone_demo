package com.superads.android.adsdkdemostandalone.viewholders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.superads.android.adsdkdemostandalone.R;

public class NativeBannerAdViewHolder extends RecyclerView.ViewHolder {
    private ViewGroup adContainer;
    private ViewGroup adView;

    private TextView titleTextView;
    private TextView descriptionsTextView;
    private TextView callToActionTextView;
    private ImageView iconImageView;

    public NativeBannerAdViewHolder(@NonNull View itemView, View adView) {
        super(itemView);

        this.adContainer = itemView.findViewById(R.id.adContainer);
        this.adView = (ViewGroup)adView;
        this.adContainer.addView(this.adView);

        this.titleTextView = itemView.findViewById(R.id.ad_txt_title);
        this.descriptionsTextView = itemView.findViewById(R.id.ad_txt_description);
        this.callToActionTextView = itemView.findViewById(R.id.ad_txt_cta);
        this.iconImageView = itemView.findViewById(R.id.ad_img_icon);
    }

//    public void bindData(NativeAd nativeAd) {
//        nativeAd.renderTitle(titleTextView);
//        nativeAd.renderDesc(descriptionsTextView);
//        nativeAd.renderCta(callToActionTextView);
//        nativeAd.renderIcon(iconImageView);
//        nativeAd.registerViewForInteraction(adView);
//    }
}
