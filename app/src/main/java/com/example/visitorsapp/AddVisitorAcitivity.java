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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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

                if(getstr1.isEmpty()||getStr2.isEmpty()||getStr3.isEmpty()||getStr4.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "all the filed need to be filled", Toast.LENGTH_SHORT).show();
                }
                else{
                    callApi();
                }
            }

            private void callApi() {

                String apiUrl="https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data= new JSONObject();
                try {
                    data.put("firstname",getstr1);
                    data.put("lastname",getStr2);
                    data.put("purpose",getStr3);
                    data.put("whomToMeet",getStr4);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                JsonObjectRequest request = new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,
                        data,
                        response -> Toast.makeText(getApplicationContext(), "Successfully added", Toast.LENGTH_SHORT).show(),
                        error -> Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_SHORT).show()

                );

                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                queue.add(request);

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
