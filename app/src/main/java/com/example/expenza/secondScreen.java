package com.example.expenza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secondScreen extends AppCompatActivity {

    Button btnNext, btnSkip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        init();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(secondScreen.this,thirdScreen.class);
                startActivity(intent);
                finish();
            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(secondScreen.this,registration_page.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void init()
    {
        btnNext=findViewById(R.id.btnNext);
        btnSkip=findViewById(R.id.btnSkip);
    }
}