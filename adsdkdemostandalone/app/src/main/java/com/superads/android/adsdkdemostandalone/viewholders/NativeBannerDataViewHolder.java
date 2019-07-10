package com.superads.android.adsdkdemostandalone.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.superads.android.adsdkdemostandalone.R;
import com.superads.android.adsdkdemostandalone.models.NativeData;

public class NativeBannerDataViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle;
    private TextView tvDesc;

    public NativeBannerDataViewHolder(@NonNull View v) {
        super(v);
        tvTitle = v.findViewById(R.id.tvTitle);
        tvDesc = v.findViewById(R.id.tvDesc);
    }

    public void bindData(NativeData data) {
        tvTitle.setText(data.getTitle());
        tvDesc.setText(data.getDesc());
    }
}
