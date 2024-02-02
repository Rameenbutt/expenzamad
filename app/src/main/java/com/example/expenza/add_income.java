package com.example.expenza;

import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class add_income extends AppCompatActivity {
    ImageView ivBack;
    TextInputEditText etPurpose,etAmount;
    Button btnAdd;
    String category;
    String[] income={"Salary","Freelance","Side Hustle","Investment","Gift","Rent","Others"};
    AutoCompleteTextView dropdown_category;
    ArrayAdapter<String> adapterIncome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);
        init();
        adapterIncome=new ArrayAdapter<String>(this,R.layout.single_item_dropdown,income);
        dropdown_category.setAdapter(adapterIncome);

        dropdown_category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                category=parent.getItemAtPosition(position).toString();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                Date date=new Date();
                String Purpose= Objects.requireNonNull(etPurpose.getText()).toString().trim();
                String Category=Objects.requireNonNull(category);
                String  Amount=Objects.requireNonNull(etAmount.getText()).toString().trim();

                HashMap<String,Object> data=new HashMap<>();
                data.put("Purpose",Purpose);
                data.put("Category",Category);
                data.put("Amount",parseInt(Amount));
                data.put("TimeStamp",formatter.format(date));
                FirebaseDatabase.getInstance()
                        .getReference()
                        .child("Incomes")
                        .push()
                        .setValue(data)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(add_income.this, "Income Added!!", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(add_income.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(add_income.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(add_income.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void init(){
        ivBack=findViewById(R.id.ivBack);
        etPurpose=findViewById(R.id.etPurpose);
        etAmount=findViewById(R.id.etAmount);
        btnAdd=findViewById(R.id.btnAdd);
        dropdown_category=findViewById(R.id.category);
    }
}