package com.example.expenza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class thirdScreen extends AppCompatActivity {

    Button btnGetStarted, btnAlreadyHaveAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_screen);
        init();
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(thirdScreen.this,registration_page.class);
                startActivity(intent);
                finish();
            }
        });
        btnAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(thirdScreen.this,LoginPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void init()
    {
        btnGetStarted=findViewById(R.id.btnGetStarted);
        btnAlreadyHaveAccount=findViewById(R.id.btnAlreadyHaveAccount);
    }
}