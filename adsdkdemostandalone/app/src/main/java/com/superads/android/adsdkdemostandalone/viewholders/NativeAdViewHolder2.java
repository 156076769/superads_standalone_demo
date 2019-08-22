package com.superads.android.adsdkdemostandalone.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.superads.android.adsdkdemostandalone.R;

public class NativeAdViewHolder2 extends RecyclerView.ViewHolder {

    public NativeAdViewHolder2(@NonNull View v, View adView) {
        super(v);
        ViewGroup container = v.findViewById(R.id.adContainer);
        container.addView(adView);
    }
}
