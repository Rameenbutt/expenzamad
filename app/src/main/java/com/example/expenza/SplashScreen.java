package com.example.expenza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    ImageView ivLogo, ivExpenza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        init();
        Animation logoAnim= AnimationUtils.loadAnimation(SplashScreen.this,R.anim.logo_anim);
        ivLogo.setAnimation(logoAnim);
        Animation expenzaAnim= AnimationUtils.loadAnimation(SplashScreen.this,R.anim.expenza_anim);
        ivLogo.setAnimation(expenzaAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){

                SharedPreferences sPref = getSharedPreferences("userdata", MODE_PRIVATE);
                String text = sPref.getString("USERNAME_KEY", "");
                Intent intent;
                if(text.isEmpty())
                {
                    intent = new Intent(SplashScreen.this, firstScreen.class);
                }
                else {
                    intent = new Intent(SplashScreen.this, MainActivity.class);
                }
                startActivity(intent);
                finish();

            }
        },5000);
    }
    public void init()
    {
        ivLogo=findViewById(R.id.ivLogo);
        ivExpenza=findViewById(R.id.ivExpenza);
    }
}