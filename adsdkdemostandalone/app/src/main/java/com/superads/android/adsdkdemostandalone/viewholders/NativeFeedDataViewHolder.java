package com.superads.android.adsdkdemostandalone.viewholders;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.superads.android.adsdkdemostandalone.R;
import com.superads.android.adsdkdemostandalone.models.NativeData;

public class NativeFeedDataViewHolder extends RecyclerView.ViewHolder {

    private ImageView imgItem;

    public NativeFeedDataViewHolder(@NonNull View v) {
        super(v);
        imgItem = v.findViewById(R.id.imgItem);
    }

    public void bindData(NativeData data) {
        Drawable drawable = ContextCompat.getDrawable(itemView.getContext(), data.getImgRes());
        if (drawable != null) {
            imgItem.setImageDrawable(drawable);
        }
        Bitmap bitmap = BitmapFactory.decodeResource(itemView.getContext().getResources(), data.getImgRes());
        Bitmap scale = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth()/4, bitmap.getHeight()/4, true);
        imgItem.setImageBitmap(scale);
    }
}
