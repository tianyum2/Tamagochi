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

public class ActivityForRightEgg extends AppCompatActivity {
    Button nextstage, eat21, play21;
    ImageView b21, Hp, Fun, food, evolveiv;
    CountDownTimer timer1, timer2;
    MediaPlayer ev;
    private int cFood = 0;
    private int cFun = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        eat21 = (Button) findViewById(R.id.eat21);
        play21 = (Button) findViewById(R.id.play21);
        nextstage = (Button) findViewById(R.id.nextstage);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_right_egg);
        ImageView b12 = (ImageView) findViewById(R.id.b21);
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
                ev = MediaPlayer.create(ActivityForRightEgg.this,R.raw.evolvebgm);
                ev.start();
                startActivity(new Intent(ActivityForRightEgg.this, RightEggSecondStage.class));
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
        b21 = (ImageView) findViewById(R.id.b21);
        eat21 = (Button) findViewById(R.id.eat21);
        eat21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cFood++;
                eat21.setVisibility(View.INVISIBLE);
                b21.setImageResource(R.drawable.e21);
                AnimationDrawable eat12 = (AnimationDrawable) b21.getDrawable();
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
        eat21 = (Button) findViewById(R.id.eat21);
        timer1 = new CountDownTimer(2700, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                eat21.setVisibility(View.VISIBLE);
                b21.setImageResource(R.drawable.basic21);
                AnimationDrawable basic21 = (AnimationDrawable) b21.getDrawable();
                basic21.start();
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
        play21 = (Button) findViewById(R.id.play21);
        timer1 = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                play21.setVisibility(View.VISIBLE);
                b21.setImageResource(R.drawable.basic21);
                AnimationDrawable basic21 = (AnimationDrawable) b21.getDrawable();
                basic21.start();
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
        play21 = (Button) findViewById(R.id.play21);
        play21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cFun++;
                play21.setVisibility(View.INVISIBLE);
                b21.setImageResource(R.drawable.play21);
                AnimationDrawable p12 = (AnimationDrawable) b21.getDrawable();
                p12.start();
                startTimerPlay();
                visibility(v);

            }
        });
    }
}
