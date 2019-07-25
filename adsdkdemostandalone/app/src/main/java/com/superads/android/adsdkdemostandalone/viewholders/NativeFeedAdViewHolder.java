package com.superads.android.adsdkdemostandalone.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.superads.android.adsdk.ads.providers.models.NativeAd;
import com.superads.android.adsdkdemostandalone.R;

public class NativeFeedAdViewHolder extends RecyclerView.ViewHolder {
    private ViewGroup adContainer;
    private ViewGroup adView;

    private TextView titleTextView;
    private TextView descriptionsTextView;
    private TextView callToActionTextView;
    private ImageView iconImageView;
    private ImageView bigImageImageView;

    public NativeFeedAdViewHolder(@NonNull View itemView, View adView) {
        super(itemView);

        this.adContainer = itemView.findViewById(R.id.adContainer);
        this.adView = (ViewGroup)adView;
        this.adContainer.addView(this.adView);

        this.titleTextView = itemView.findViewById(R.id.ad_txt_title);
        this.descriptionsTextView = itemView.findViewById(R.id.ad_txt_description);
        this.callToActionTextView = itemView.findViewById(R.id.ad_txt_cta);
        this.iconImageView = itemView.findViewById(R.id.ad_img_icon);
        this.bigImageImageView = itemView.findViewById(R.id.ad_img);
    }

    public void bindData(NativeAd nativeAd) {
        nativeAd.renderTitle(titleTextView);
        nativeAd.renderDesc(descriptionsTextView);
        nativeAd.renderCta(callToActionTextView);
        nativeAd.renderIcon(iconImageView);
        nativeAd.renderBigImgUrl(bigImageImageView);
        nativeAd.registerViewForInteraction(adView);
    }
}
