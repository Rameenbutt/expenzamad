package com.example.expenza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;
import java.util.Objects;

public class LoginPage extends AppCompatActivity {

    TextInputEditText etLoginEmail,etLoginPassword;
    TextView tvForgotPassword , tvSignup;
    Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Intent userDetails=getIntent();
        String username=userDetails.getStringExtra("USERNAME_KEY");
        String email=userDetails.getStringExtra("EMAIL_KEY");
        String password=userDetails.getStringExtra("PASSWORD_KEY");
        String phone=userDetails.getStringExtra("PHONE_KEY");

        init();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = etLoginEmail.getText().toString().trim();
                String userPassword = etLoginPassword.getText().toString();

                if(userEmail.equals(email) && userPassword.equals(password))
                {
                    HashMap<String, Object> data=new HashMap<>();
                    data.put("Name",username);
                    data.put("Email",email);
                    data.put("Password",password);
                    data.put("Phone",phone);

                    FirebaseDatabase.getInstance()
                            .getReference()
                            .child("Users")
                            .push()
                            .setValue(data)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(LoginPage.this, "logined successfully", Toast.LENGTH_SHORT).show();
                                    SharedPreferences sPref = getSharedPreferences("userdata", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sPref.edit();
                                    editor.putString("USERNAME_KEY",username);
                                    editor.commit();

                                    Intent intent = new Intent(LoginPage.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(LoginPage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

                    /*
                    tvresult.setText("Name:"+username+" Email"+email+" Password="+password+" Phone"+phone);
                    */
                }
                else {
                    Toast.makeText(LoginPage.this, "doesn't match", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void init()
    {
        etLoginEmail=findViewById(R.id.etEmail);
        etLoginPassword=findViewById(R.id.etPassword);
        btnSignIn=findViewById(R.id.btnSignIn);
        tvForgotPassword=findViewById(R.id.tvForgotPassword);
        tvSignup=findViewById(R.id.tvSignup);
        /*tvresult=findViewById(R.id.tvresult);
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Users");
        FirebaseRecyclerOptions<User> options =
                new FirebaseRecyclerOptions.Builder<User>()
                        .setQuery(query, User.class)
                        .build();*/
    }
}