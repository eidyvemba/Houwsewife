package com.msmasters.housewife;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends Activity {
    private static int TIME = 5000;
    private ImageView imv_logo;
    private TextView txt_desc;
    private Animation anim_alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

       // imv_logo = (ImageView) findViewById(R.id.imv_logo);
        txt_desc = (TextView) findViewById(R.id.txt_desc);
        anim_alpha = AnimationUtils.loadAnimation(Splash.this, R.anim.alpha);
        //imv_logo.startAnimation(anim_alpha);
        txt_desc.startAnimation(anim_alpha);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(i);
                finish();
            }
        }, TIME);
    }
}
