package com.superads.android.adsdkdemostandalone.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.superads.android.adsdkdemostandalone.App;
import com.superads.android.adsdkdemostandalone.R;

public class MainActivity extends BaseActivity {

    private final String TAG = MainActivity.class.getSimpleName();

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
        tv1.setText("SuperADS Demo");

        Log.d(TAG, "publisherId: " + App.publisherId + "\n" +
                "appId: " + App.appId + "\n");

        tv1.setText("publisherId: " + App.publisherId + "\n" +
                "appId: " + App.appId + "\n");

//        Bitmap bmp= BitmapFactory.decodeResource(getResources(), R.id.logo);
//        int bwidht=bmp.getWidth();
//        int bheight=bmp.getHeight();
//        Matrix matrix = new Matrix();
//        matrix.postScale((float)0.5,(float)0.5); //长和宽放大缩小的比例
//        final Bitmap newb = Bitmap.createBitmap(bmp,0,0,bwidht, bheight,matrix,true );
//        ImageView imageView = findViewById(R.id.logo);
//        imageView.setImageBitmap(newb);
    }

    public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.main_list_item, viewGroup, false);
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
        private TextView tv1;
        private TextView tv2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }

        Class target;
        Intent intent;
        public void bindData(int i) {
            tv1.setText(data[i]);
            tv2.setText(desc[i]);

            target = null;
            if (i == 0) {
                target = PlayableExamplesActivity.class;
                intent = new Intent(MainActivity.this, target);
            } else if (i == 1) {
                target = VideoActivity.class;
                intent = new Intent(MainActivity.this, target);
            } else if (i == 2) {
                target = VideoActivity.class;
                intent = new Intent(MainActivity.this, target);
            } else if (i == 3) {
                target = NativeExamplesActivity.class;
                intent = new Intent(MainActivity.this, target);
            } else if (i == 4) {
                target = InterstitialActivity.class;
                intent = new Intent(MainActivity.this, target);
            } else if (i == 5) {
                target = BannerActivity.class;
                intent = new Intent(MainActivity.this, target);
            } else if (i == 6) {
                target = AboutActivity.class;
                intent = new Intent(MainActivity.this, target);
                //tv.setTextColor(getResources().getColor(R.color.colorAccent));
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (intent != null) {
                        MainActivity.this.startActivity(intent);
                    }
                }
            });

        }
    }

    String[] data = {"Playable", "Video",  "Rewarded Video", "Native", "Interstitial", "Banner", "About SuperADS", "Contact: monetize@superads.cn"};
    String[] desc = {"Full Screen ads. Interactive ad experience", "Full screen ads. Video", "Full screen ads. Rewarded Video", "In-content ads that blend in seamlessly", "Full screen ads. Graphic", "320*50 Classic banner ads", "", ""};
}
