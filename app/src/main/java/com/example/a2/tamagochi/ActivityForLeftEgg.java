package com.example.a2.tamagochi;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class ActivityForLeftEgg extends AppCompatActivity {
    Button nextstage, eat11, play11;
    ImageView b11, Hp, Fun, food, evolveiv;
    CountDownTimer timer1, timer2;

    private int cFood = 0;
    private int cFun = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        eat11 = (Button) findViewById(R.id.eat11);
        play11 = (Button) findViewById(R.id.play11);
        nextstage = (Button) findViewById(R.id.nextstage);
        evolveiv = (ImageView) findViewById(R.id.evolveiv);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_left_egg);
        BackToMain();
        nextStage();
        ImageView b11 = (ImageView) findViewById(R.id.b11);
        AnimationDrawable basic11 = (AnimationDrawable) b11.getDrawable();
        basic11.start();

        setEat11();
        setPlay11();
    }
    private void BackToMain() {
        Button backToMain = findViewById(R.id.BackToMain);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void nextStage() {
        nextstage = findViewById(R.id.nextstage);
        nextstage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityForLeftEgg.this, LeftEggSecondStage.class));
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
        b11 = (ImageView) findViewById(R.id.b11);
        eat11 = (Button) findViewById(R.id.eat11);
        eat11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cFood++;
                b11.setImageResource(R.drawable.eat11);
                AnimationDrawable eat11 = (AnimationDrawable) b11.getDrawable();
                eat11.start();
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
        food = (ImageView) findViewById(R.id.food);
        Hp = (ImageView) findViewById(R.id.Hp);
        timer1 = new CountDownTimer(2700, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                b11.setImageResource(R.drawable.basic11);
                AnimationDrawable basic11 = (AnimationDrawable) b11.getDrawable();
                basic11.start();
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
        timer1 = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                b11.setImageResource(R.drawable.basic11);
                AnimationDrawable basic11 = (AnimationDrawable) b11.getDrawable();
                basic11.start();
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
        play11 = (Button) findViewById(R.id.play11);
        play11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cFun++;
                b11.setImageResource(R.drawable.p11);
                AnimationDrawable p11 = (AnimationDrawable) b11.getDrawable();
                p11.start();
                startTimerPlay();
                visibility(v);

            }
        });
    }
}
