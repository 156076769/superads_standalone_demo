package com.superads.android.adsdkdemostandalone.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.superads.android.adsdkdemostandalone.App;
import com.superads.android.adsdkdemostandalone.R;
import com.superads.android.adsdkdemostandalone.adapters.NativeBannerAdapter;
import com.superads.android.adsdkdemostandalone.adapters.NativeFeedAdapter;
import com.superads.android.adsdkdemostandalone.models.DataType;
import com.superads.android.adsdkdemostandalone.models.NativeData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new MyAdapter());

        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText("" +
                "publisherId: " + App.publisherId + "\n" +
                "appId: " + App.appId + "\n" +
                "");
    }

    public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_view, viewGroup, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            ((MyViewHolder) viewHolder).bindData(i);
        }

        @Override
        public int getItemCount() {
            return data.length;
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv1);
        }

        public void bindData(int i) {
            tv.setText(data[i]);
            final Class target;
            if (i == 0) {
                target = BannerActivity.class;
            } else if (i == 1) {
                target = InterstitialActivity.class;
            } else if (i == 2) {
                target = NativeExamplesActivity.class;
            } else if (i == 3) {
                target = VideoActivity.class;
            } else{
                target = null;
            }
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, target);
                    MainActivity.this.startActivity(i);
                }
            });

        }
    }

    String[] data = {"Banner", "Interstitial", "Native", "Video"};

}
