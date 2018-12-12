package com.example.a2.tamagochi;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        song = MediaPlayer.create(MainActivity.this,R.raw.bgm);
        song.start();
        Right();
        Left();
    }
    private void Left() {
        Button toLeftEgg = findViewById(R.id.EGG_left);
        toLeftEgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.release();
                startActivity(new Intent(MainActivity.this, ActivityForLeftEgg.class));
            }
        });

    }
    private void Right() {
        Button toRightEgg = findViewById(R.id.EGG_right);
        toRightEgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.release();
                startActivity(new Intent(MainActivity.this, ActivityForRightEgg.class));
            }
        });
    }
}
