package com.example.titanvapeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_checkout);

        ListView checkoutView = (ListView) findViewById(R.id.checkoutView);
        checkoutAdapter checkoutAdapter = new checkoutAdapter(this, cart.checkoutLists);
        checkoutView.setAdapter(checkoutAdapter);

        ImageButton checkout_back = findViewById(R.id.checkout_back);
        checkout_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(checkout.this,cart.class);
                startActivity(i);
                finish();
            }
        });
        TextView chcktTotal = findViewById(R.id.chcktTotal);
        chcktTotal.setText(cart.total);

        Button doneBtn = findViewById(R.id.doneBtn);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(checkout.this,Thankyou.class);
                startActivity(i);
                finish();
            }
        });
    }
}