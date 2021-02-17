package com.example.titanvapeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class itemDescription extends AppCompatActivity {
    ImageButton backBtn;
    ImageView itemImg;
    TextView itemDesc;
    TextView itemTitle;
    TextView itemPrice;
    Button addToCartBtn;
    Button buyNow;
    public static int cartCount = 0;
    EditText itemQTY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_item_description);

        itemImg = findViewById(R.id.itemImg);
        itemTitle = findViewById(R.id.itemTitle);
        itemDesc = findViewById(R.id.itemDesc);
        itemPrice = findViewById(R.id.itemPrice);

        Drawable myDrawable = itemImg.getResources().getDrawable(mainPage.itemDrawable);
        itemTitle.setText(mainPage.itemTitle);
        itemDesc.setText(mainPage.itemDesc);
        String price1 = Double.toString(mainPage.itemPrice);
        itemPrice.setText(price1);
        itemImg.setImageDrawable(myDrawable);

        backBtn = findViewById(R.id.backBtn);
        addToCartBtn = findViewById(R.id.addToCartBtn);
        buyNow = findViewById(R.id.buyNow);

        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stopper=0;
                for (int x = 0; x < cart.checkoutLists.size(); x++){
                    if(mainPage.itemTitle.equals(cart.checkoutLists.get(x).item)){
                        cart.checkoutLists.get(x).quantity++;
                        Intent i = new Intent(itemDescription.this,checkout.class);
                        startActivity(i);
                        finish();
                        stopper = 1;
                    }
                }
                if (stopper==0) {
                    cartCount++;
                    cart.checkoutLists.add(new itemList(mainPage.itemDrawable, mainPage.itemTitle, mainPage.itemPrice, mainPage.itemDesc, mainPage.itemQuantity, mainPage.totalPrice));
                    Intent i = new Intent(itemDescription.this, checkout.class);
                    startActivity(i);
                    finish();
                }
                double sum = 0;
                for (int i = 0; i < cart.checkoutLists.size(); i++){
                    sum = sum + cart.checkoutLists.get(i).totalPrice;
                }
                cart.total = Double. toString(sum);
                System.out.println(cart.total);
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stopper=0;
                for (int x = 0; x < cart.checkoutLists.size(); x++){
                    if(mainPage.itemTitle.equals(cart.checkoutLists.get(x).item)){
                        cart.checkoutLists.get(x).quantity++;
                        Intent i = new Intent(itemDescription.this,itemAdded.class);
                        startActivity(i);
                        finish();
                        stopper = 1;
                    }
                }
                if (stopper==0) {
                    cartCount++;
                    cart.checkoutLists.add(new itemList(mainPage.itemDrawable, mainPage.itemTitle, mainPage.itemPrice, mainPage.itemDesc, mainPage.itemQuantity, mainPage.totalPrice));
                    Intent i = new Intent(itemDescription.this, itemAdded.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(itemDescription.this,mainPage.class);
                startActivity(i);
                finish();
            }
        });

    }
}