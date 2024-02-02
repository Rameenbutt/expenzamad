package com.example.expenza;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class about_fragment extends Fragment {

    Button logout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
        logout=findViewById(R.id.logout);
        SharedPreferences sPref = getSharedPreferences("userdata", MODE_PRIVATE);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sPref.edit();
                editor.remove("USERNAME_KEY");
                editor.commit();

                startActivity(new Intent(about.this, registration_page.class));
                finish();
            }
        });*/
        return inflater.inflate(R.layout.fragment_about_fragment, container, false);

    }
}