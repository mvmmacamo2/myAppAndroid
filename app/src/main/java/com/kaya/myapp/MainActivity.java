package com.kaya.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.text_view);
        imageView = findViewById(R.id.image_view);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.mytransition);

         final Intent HomeActivity = new Intent(this, HomeActivity.class);

        textView.startAnimation(animation);
        imageView.startAnimation(animation);
        Thread timer = new Thread() {
            public void run () {
                try {
                  sleep(5000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(HomeActivity);
                    finish();
                }
            }
        };
        timer.start();

    }
}
