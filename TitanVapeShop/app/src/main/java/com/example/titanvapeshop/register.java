package com.example.titanvapeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    public static int id = 0;
    EditText nameReg, addressReg, emailReg, passReg, conpassReg;
    Button regBtn_register;
    TextView loginBtn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

        nameReg = findViewById(R.id.nameReg);
        addressReg = findViewById(R.id.addressReg);
        emailReg = findViewById(R.id.emailReg);
        passReg = findViewById(R.id.passReg);
        conpassReg = findViewById(R.id.conpassReg);

        regBtn_register = findViewById(R.id.regBtn_register);
        loginBtn_register = findViewById(R.id.loginBtn_register);

        regBtn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, address, email, pass, conpass;

                name = nameReg.getText().toString();
                address = addressReg.getText().toString();
                email = emailReg.getText().toString();
                pass = passReg.getText().toString();
                conpass = conpassReg.getText().toString();

                if(name.equals("")){
                    Toast.makeText(register.this, "Name is Empty", Toast.LENGTH_LONG).show();
                }
                else if(address.equals("")){
                    Toast.makeText(register.this, "Address is Empty", Toast.LENGTH_LONG).show();
                }
                else if(email.equals("")){
                    Toast.makeText(register.this, "Email is Empty", Toast.LENGTH_LONG).show();
                }
                else if(pass.equals("")){
                    Toast.makeText(register.this, "Password is Empty", Toast.LENGTH_LONG).show();
                }
                else if(conpass.equals("")){
                    Toast.makeText(register.this, "Confirm Password is Empty", Toast.LENGTH_LONG).show();
                }
                else if(!pass.equals(conpass)){
                    Toast.makeText(register.this, "Password do not match", Toast.LENGTH_LONG).show();
                }
                else if(email.equals(users.email)){
                    Toast.makeText(register.this, "Gamit na email mo pre", Toast.LENGTH_LONG).show();
                }else{
                    users users = new users(id, name, address, email, pass);
//                    System.out.println(users.id +" "+ users.name+ " "+ users.address+ " "+users.email+ " "+users.password);
                    id++;

                    nameReg.setText("");
                    addressReg.setText("");
                    emailReg.setText("");
                    passReg.setText("");
                    conpassReg.setText("");
                }

            }
        });

        loginBtn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(register.this,login.class);
                startActivity(i);
                finish();
            }
        });
    }
}