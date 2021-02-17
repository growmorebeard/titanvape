package com.example.titanvapeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText email, pass;
    Button loginBtn, fbBtn;
    TextView regBtn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);

        loginBtn = findViewById(R.id.loginBtn);
        fbBtn = findViewById(R.id.fbBtn);
        regBtn_login = findViewById(R.id.regBtn_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail, pas;

                mail = email.getText().toString();
                pas = pass.getText().toString();

                if(mail.equals("")){
                    Toast.makeText(login.this,"Email is Empty", Toast.LENGTH_LONG).show();
                }
                if(pas.equals("")){
                    Toast.makeText(login.this,"Password is Empty", Toast.LENGTH_LONG).show();
                }else{
                    //Authentication
                }
            }
        });
        fbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this,mainPage.class);
                startActivity(i);
                finish();
            }
        });
        regBtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this,register.class);
                startActivity(i);
                finish();
            }
        });
    }
}