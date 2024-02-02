package com.example.expenza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class registration_page extends AppCompatActivity {
    TextInputEditText etName,etEmail,etPhone,etPassword,etConfirmPassword;
    Button btnSignup;
    TextView tvSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        init();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etName.getText().toString().trim();
                String email=etEmail.getText().toString().trim();
                String phone=etPhone.getText().toString().trim();
                String password = etPassword.getText().toString();
                String cPassword = etConfirmPassword.getText().toString();


                if(username.isEmpty())
                {
                    etName.setError("Username can't be empty");
                }
                if(email.isEmpty())
                {
                    etEmail.setError("E-mail can't be empty");
                }
                if(phone.isEmpty())
                {
                    etPhone.setError("Phone Number can't be empty");
                }
                if(password.isEmpty())
                {
                    etPassword.setError("Password can't be empty");
                }
                if(cPassword.isEmpty())
                {
                    etConfirmPassword.setError("Confirm Password can't be empty");
                }

                if(!password.isEmpty() && !cPassword.isEmpty() && !password.equals(cPassword))
                {
                    Toast.makeText(registration_page.this, "Password mis-matched", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(registration_page.this, LoginPage.class);
                    intent.putExtra("USERNAME_KEY",username);
                    intent.putExtra("EMAIL_KEY",email);
                    intent.putExtra("PASSWORD_KEY", password);
                    intent.putExtra("PHONE_KEY",phone);
                    startActivity(intent);
                    finish();
                }
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(registration_page.this,LoginPage.class);
                startActivity(intent);
                finish();
            }
        });


    }
    public void init()
    {
        etName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        etConfirmPassword=findViewById(R.id.etConfirmPassword);
        etPhone=findViewById(R.id.etPhone);
        btnSignup=findViewById(R.id.btnSignup);
        tvSignIn=findViewById(R.id.tvSignin);
    }
}