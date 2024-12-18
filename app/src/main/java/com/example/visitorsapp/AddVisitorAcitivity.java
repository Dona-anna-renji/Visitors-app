package com.example.visitorsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddVisitorAcitivity extends AppCompatActivity {

    EditText e1,e2,e3,e4;

    Button b1,b2;

    String getstr1,getStr2,getStr3,getStr4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_visitor);

        e1=(EditText) findViewById(R.id.fname);
        e2=(EditText) findViewById(R.id.lname);
        e3=(EditText) findViewById(R.id.purpose);
        e4=(EditText) findViewById(R.id.whomtomeet);
        b1=(Button) findViewById(R.id.submit);
        b2=(Button) findViewById(R.id.back);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getstr1=e1.getText().toString();
                getStr2=e2.getText().toString();
                getStr3=e3.getText().toString();
                getStr4=e4.getText().toString();


                Toast.makeText(getApplicationContext(),getstr1+" "+getStr2+" "+getStr3+" "+getStr4,Toast.LENGTH_LONG).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent o= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(o);
            }
        });


    }
}