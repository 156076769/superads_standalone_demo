package com.superads.android.adsdkdemostandalone.viewholders;

import android.view.View;
import android.widget.TextView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.superads.android.adsdkdemostandalone.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private TextView txtView;

    public ItemViewHolder(@NonNull View v) {
        super(v);
        txtView = v.findViewById(R.id.tvTitle);
    }

    public void bindData(String txt) {
        txtView.setText(txt);
    }
}
