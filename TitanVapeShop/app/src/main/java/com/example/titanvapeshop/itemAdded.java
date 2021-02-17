package com.example.titanvapeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class itemAdded extends AppCompatActivity {
    ImageButton backBtn_checkout;
    ImageView checkoutImg;
    TextView checkoutTitle;
    Button gotoCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_item_added);

        checkoutImg = findViewById(R.id.checkoutImg);
        checkoutTitle = findViewById(R.id.checkoutTitle);

        Drawable myDrawable = checkoutImg.getResources().getDrawable(mainPage.itemDrawable);
        checkoutTitle.setText(mainPage.itemTitle);
        checkoutImg.setImageDrawable(myDrawable);

        backBtn_checkout = findViewById(R.id.backBtn_checkout);
        backBtn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(itemAdded.this,mainPage.class);
                startActivity(i);
                finish();
            }
        });
        gotoCart = findViewById(R.id.gotoCart);
        gotoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(itemAdded.this, cart.class);
                startActivity(i);
                finish();
            }
        });
        GridView gvSuggested = (GridView) findViewById(R.id.gvSuggested);
        itemAdapter itemAdapter = new itemAdapter(this, mainPage.itemLists);
        gvSuggested.setAdapter(itemAdapter);
    }
}