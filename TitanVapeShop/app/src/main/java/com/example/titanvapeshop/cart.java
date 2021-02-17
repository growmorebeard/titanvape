package com.example.titanvapeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class cart extends AppCompatActivity {
    public static ArrayList<itemList> checkoutLists = new ArrayList<>();
    ImageButton backCheckoutBtn;
    Button checkoutBtn;
    public static TextView totalPrice;
    public static String total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cart);

        ListView checkout_cart = (ListView) findViewById(R.id.checkout_cart);
        myCartAdapter myCartAdapter = new myCartAdapter(this, checkoutLists, cart.this);
        checkout_cart.setAdapter(myCartAdapter);

        backCheckoutBtn = findViewById(R.id.backCheckoutBtn);
        backCheckoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(cart.this,mainPage.class);
                startActivity(i);
                finish();
            }
        });

        totalPrice = findViewById(R.id.totalPrice);
        double sum = 0;
        for (int i = 0; i < checkoutLists.size(); i++){
            sum = sum + checkoutLists.get(i).totalPrice;
        }
        total = Double. toString(sum);
        totalPrice.setText(total);

        checkoutBtn = findViewById(R.id.checkoutBtn);
        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkoutLists.size()==0){
                    Toast.makeText(cart.this, "Cart is empty", Toast.LENGTH_LONG).show();
                }else {
                Intent i = new Intent(cart.this, checkout.class);
                startActivity(i);
                finish();
                }
            }
        });
    }
}