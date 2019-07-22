package com.superads.android.adsdkdemostandalone.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.superads.android.adsdkdemostandalone.R;

public class PlayableExamplesActivity extends Activity {

    Class target;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playable_examples);

        Button btnLoad = findViewById(R.id.btn_load);
        btnLoad.setOnClickListener(view -> {
            SharedPreferences sp = getSharedPreferences("common", MODE_PRIVATE);
            String game = sp.getString("last_play_game", "");
            boolean needLandscape = false;
            if (game.equals("Iteration")) {
                game = "eToro";
            } else if (game.equals("eToro")) {
                game = "Foodpanda";
            } else if (game.equals("Foodpanda")) {
                game = "Iteration";
            } else {
                game = "Iteration";
            }
            sp.edit().putString("last_play_game", game).apply();
            if (needLandscape) {
                target = PlayableActivity.class;
            } else {
                target = PlayableActivity.class;
            }
            intent = new Intent(PlayableExamplesActivity.this, target);
            intent.putExtra("game", game);
            Toast.makeText(PlayableExamplesActivity.this, "playable Ad load successfully", Toast.LENGTH_SHORT).show();
        });

        View btnShow = findViewById(R.id.btn_show);
        btnShow.setOnClickListener(view -> {
            if (intent != null) {
                PlayableExamplesActivity.this.startActivity(intent);
            }
        });
    }

}


