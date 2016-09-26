package com.feicui.cn.jxh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import entity.TelclassInfo;


public class LogoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        ImageView img_logo = (ImageView) findViewById(R.id.iv_Logo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_logo);

        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(LogoActivity.this, TelmsgActivity.class);
                startActivity(intent);
                finish();
            }
        });
        img_logo.startAnimation(animation);
        animation.start();
    }



}


