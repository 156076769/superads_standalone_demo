package com.superads.android.adsdkdemostandalone.activities;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.superads.android.adsdkdemostandalone.R;
import com.superads.android.adsdkdemostandalone.adapters.NativeAdapter2;
import com.superads.android.adsdkdemostandalone.models.ItemData;

import java.util.ArrayList;
import java.util.List;

public class NativeActivity2 extends BaseActivity {

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
        reycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        refreshRecycleView();
    }

    private void refreshRecycleView() {
        List<ItemData> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemData data = new ItemData();
            data.type = ItemData.Type.NORMAL;
            data.data = "txt";
            items.add(data);
        }

        int dataType = getIntent().getIntExtra("nativeAdType", 1);
        switch (dataType) {
            case 1: {
                ItemData adItem = new ItemData();
                adItem.type = ItemData.Type.NATIVE_AD_BANNER;
                adItem.data = null;
                items.add(1, adItem);
                reycler.setAdapter(new NativeAdapter2(items));
            }
            break;
            case 2:
            default: {
                ItemData adItem = new ItemData();
                adItem.type = ItemData.Type.NATIVE_AD_FEED;
                adItem.data = null;
                items.add(1, adItem);
                reycler.setAdapter(new NativeAdapter2(items));
            }
            break;
        }
    }

}
