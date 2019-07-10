package com.superads.android.adsdkdemostandalone.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.superads.android.adsdkdemostandalone.R;
import com.superads.android.adsdkdemostandalone.adapters.NativeBannerAdapter;
import com.superads.android.adsdkdemostandalone.adapters.NativeFeedAdapter;
import com.superads.android.adsdkdemostandalone.models.DataType;
import com.superads.android.adsdkdemostandalone.models.NativeData;

import java.util.ArrayList;
import java.util.List;

public class NativeActivity extends Activity {

    private RecyclerView reycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native);
        init();
    }

    private void init() {
        reycler = findViewById(R.id.recycler);
        reycler.setHasFixedSize(true);
        reycler.setLayoutManager(new LinearLayoutManager(this));
        if (getIntent().hasExtra("adType")) {
            DataType adType = (DataType) getIntent().getSerializableExtra("adType");
            switch (adType) {
                case NATIVE_BANNER:
                    setNativeBannerRecyclerData();
                    break;
                case NATIVE_FEED:
                default:
                    setNativeFeedRecyclerData();
                    break;
            }
        }
    }

    private void setNativeBannerRecyclerData() {
        List<NativeData> items = new ArrayList<>();
        String[] titles = getResources().getStringArray(R.array.item_titles);
        String[] descriptions = getResources().getStringArray(R.array.item_descriptions);
        int adDelimiter = 4;
        for (int i = 0; i < titles.length; i++) {
            NativeData data = new NativeData();
            data.setTitle(titles[i]);
            data.setDesc(descriptions[i]);
            data.setType(DataType.NORMAL);
            items.add(data);
        }

        for (int i = 1; i < titles.length; i++) {
            if (i % adDelimiter == 0) {
                NativeData data = new NativeData();
                data.setType(DataType.NATIVE_BANNER);
                items.add(i, data);
            }
        }
        reycler.setAdapter(new NativeBannerAdapter(items));
    }

    private void setNativeFeedRecyclerData() {
        List<NativeData> items = new ArrayList<>();
        int[] imageRes = {R.drawable.product2, R.drawable.product3};
        for (int imageRe : imageRes) {
            NativeData data = new NativeData();
            data.setImgRes(imageRe);
            data.setType(DataType.NORMAL);
            items.add(data);
        }
        NativeData data = new NativeData();
        data.setType(DataType.NATIVE_FEED);
        items.add(1, data);
        reycler.setAdapter(new NativeFeedAdapter(items));
    }


}
