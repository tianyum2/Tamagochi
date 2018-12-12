package com.example.a2.tamagochi;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class LeftEggSecondStage extends AppCompatActivity {

    Button nextstage, eat12, play12;
    ImageView b12, Hp, Fun, food, evolveiv;
    CountDownTimer timer1, timer2;
    private int cFood = 0;
    private int cFun = 0;
    MediaPlayer ev, song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        eat12 = (Button) findViewById(R.id.eat12);
        play12 = (Button) findViewById(R.id.play12);
        nextstage = (Button) findViewById(R.id.nextstage);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_egg_second_stage);
        song = MediaPlayer.create(LeftEggSecondStage.this,R.raw.bgm);
        song.start();
        ImageView b12 = (ImageView) findViewById(R.id.b12);
        AnimationDrawable basic12 = (AnimationDrawable) b12.getDrawable();
        basic12.start();
        nextStage();
        setEat11();
        setPlay11();
    }
    private void nextStage() {
        nextstage = findViewById(R.id.nextstage);
        nextstage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.release();
                ev = MediaPlayer.create(LeftEggSecondStage.this,R.raw.evolvebgm);
                ev.start();
                startActivity(new Intent(LeftEggSecondStage.this, LeftEggThirdStage.class));
            }
        });
    }
    public void visibility(View v) {
        evolveiv = (ImageView) findViewById(R.id.evolveiv);
        if (cFood >= 5 && cFun >= 5) {
            nextstage.setVisibility(View.VISIBLE);
            evolveiv.setVisibility(View.VISIBLE);
            AnimationDrawable evolve11 = (AnimationDrawable) evolveiv.getDrawable();
            evolve11.start();
            //invisible at first;
            //make it visible;
        }
    }
    public void setEat11() {
        food = (ImageView) findViewById(R.id.food);
        final Random rdm = new Random();
        b12 = (ImageView) findViewById(R.id.b12);
        eat12 = (Button) findViewById(R.id.eat12);
        eat12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eat12.setVisibility(View.INVISIBLE);
                cFood++;
                b12.setImageResource(R.drawable.eat12);
                AnimationDrawable eat12 = (AnimationDrawable) b12.getDrawable();
                eat12.start();
                food.setVisibility(View.VISIBLE);
                int i = rdm.nextInt(4);
                if (i == 0) {
                    food.setImageResource(R.drawable.cake);
                    AnimationDrawable fod = (AnimationDrawable) food.getDrawable();
                    fod.start();
                } else if (i == 1) {
                    food.setImageResource(R.drawable.fries);
                    AnimationDrawable fod = (AnimationDrawable) food.getDrawable();
                    fod.start();
                } else if (i == 2) {
                    food.setImageResource(R.drawable.hotdog);
                    AnimationDrawable fod = (AnimationDrawable) food.getDrawable();
                    fod.start();
                } else {
                    food.setImageResource(R.drawable.banana);
                    AnimationDrawable fod = (AnimationDrawable) food.getDrawable();
                    fod.start();
                }
                startTimerEat();
                visibility(v);

                //start the xml of that animation
            }
        });
    }
    public void startTimerEat() {
        Hp = (ImageView) findViewById(R.id.Hp);
        eat12 = (Button) findViewById(R.id.eat12);
        timer1 = new CountDownTimer(2700, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                eat12.setVisibility(View.VISIBLE);
                b12.setImageResource(R.drawable.basic12);
                AnimationDrawable basic12 = (AnimationDrawable) b12.getDrawable();
                basic12.start();
                if (cFood == 1) {
                    Hp.setImageResource(R.drawable.star1);
                } else if (cFood == 2) {
                    Hp.setImageResource(R.drawable.star2);
                } else if (cFood == 3) {
                    Hp.setImageResource(R.drawable.star3);
                } else if (cFood == 4) {
                    Hp.setImageResource(R.drawable.star4);
                } else {
                    Hp.setImageResource(R.drawable.star5);
                }
                food.setVisibility(View.INVISIBLE);
            }
        }.start();
    }
    public void startTimerPlay() {
        Fun = (ImageView) findViewById(R.id.Fun);
        play12 = (Button) findViewById(R.id.play12);
        timer1 = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                play12.setVisibility(View.VISIBLE);
                b12.setImageResource(R.drawable.basic12);
                AnimationDrawable basic12 = (AnimationDrawable) b12.getDrawable();
                basic12.start();
                if (cFun == 1) {
                    Fun.setImageResource(R.drawable.star1);
                } else if (cFun == 2) {
                    Fun.setImageResource(R.drawable.star2);
                } else if (cFun == 3) {
                    Fun.setImageResource(R.drawable.star3);
                } else if (cFun == 4) {
                    Fun.setImageResource(R.drawable.star4);
                } else {
                    Fun.setImageResource(R.drawable.star5);
                }
            }
        }.start();
    }
    public void setPlay11() {
        play12 = (Button) findViewById(R.id.play12);
        play12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play12.setVisibility(View.INVISIBLE);
                cFun++;
                b12.setImageResource(R.drawable.p12);
                AnimationDrawable p12 = (AnimationDrawable) b12.getDrawable();
                p12.start();
                startTimerPlay();
                visibility(v);

            }
        });
    }
}
