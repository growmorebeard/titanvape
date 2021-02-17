package com.example.titanvapeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Thankyou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_thankyou);

        ImageButton tyBtn = findViewById(R.id.tyBtn);
        tyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.checkoutLists.clear();
                Intent i = new Intent(Thankyou.this, mainPage.class);
                startActivity(i);
                finish();
            }
        });
    }
}