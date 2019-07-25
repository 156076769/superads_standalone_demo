package com.superads.android.adsdkdemostandalone.models;

public class ItemData {
    public Object data;
    public Type type;

    public static enum Type {
        NORMAL, NATIVE_AD_BANNER, NATIVE_AD_FEED
    }
}
