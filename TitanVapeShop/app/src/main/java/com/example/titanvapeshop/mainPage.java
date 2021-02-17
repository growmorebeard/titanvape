package com.example.titanvapeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.ArrayList;
import java.util.List;

public class mainPage extends AppCompatActivity {
    int totalQty;
    public static int a;
    public static int cart_badge = 0;
    String categories[] = {"All Category", "Vape", "Juice"};
    public static  String itemDesc;
    public static String itemTitle;
    public static Double itemPrice;
    public static Double totalPrice;
    public static int itemDrawable;
    public static int itemQuantity;
    public static ArrayList<itemList> itemLists = new ArrayList<>();
    NotificationBadge badge;
    ImageView cart_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_page);

        totalQty = 0;
        for (int i = 0; i<cart.checkoutLists.size(); i++){
            totalQty = totalQty + cart.checkoutLists.get(i).quantity;
        }
        itemDescription.cartCount = totalQty;

        ImageSlider imageSlider = findViewById(R.id.slider);

        cart_icon = findViewById(R.id.cart_icon);
        cart_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mainPage.this, cart.class);
                startActivity(i);
                finish();
            }
        });

        List<SlideModel> slidemodels = new ArrayList<>();
        slidemodels.add(new SlideModel("https://i.imgur.com/669c5OD.png"));
        slidemodels.add(new SlideModel("https://i.imgur.com/RixzmaY.png"));
        slidemodels.add(new SlideModel("https://i.imgur.com/bMbii1S.png"));
        imageSlider.setImageList(slidemodels, true);


        Spinner spinnerCategory = (Spinner) findViewById(R.id.spinnerCategory);
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, R.layout.category_item, R.id.textCategory, categories);

        spinnerCategory.setAdapter(categoryAdapter);

        if(cart_badge == 0){
            itemLists.add(new itemList(R.drawable.vape1, "Titan 1 Budget Vape", 1000, " Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 1, 1000));
            cart_badge++;
            itemLists.add(new itemList(R.drawable.vape2, "Titan 2 Mid Budget Vape", 2000, " Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 1, 2000));
            cart_badge++;
            itemLists.add(new itemList(R.drawable.vape3, "Titan 3 Not so Budget Vape", 3000, " Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 1, 3000));
            cart_badge++;
            itemLists.add(new itemList(R.drawable.vape4, "Titan 4 Special Pricey Vape", 4000, " Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 1, 4000));
            cart_badge++;
            itemLists.add(new itemList(R.drawable.juice1, "Vape Juice Strawberry", 250, " Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 1, 250));
            cart_badge++;
            itemLists.add(new itemList(R.drawable.juice2, "Vape Juice Watermelon", 400, " Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 1, 400));
            cart_badge++;
            itemLists.add(new itemList(R.drawable.juice3, "Vape Juice Rainbow", 500, " Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 1, 500));
            cart_badge++;
        }


        GridView gvItems = (GridView) findViewById(R.id.gvItems);
        itemAdapter itemAdapter = new itemAdapter(this, itemLists);
        gvItems.setAdapter(itemAdapter);

        badge = (NotificationBadge) findViewById(R.id.badge);
        if(itemDescription.cartCount == 0){
            badge.setVisibility(View.INVISIBLE);
        }else{
            badge.setVisibility(View.VISIBLE);
        }
        String itemCount = Integer.toString(itemDescription.cartCount);
        badge.setText(itemCount);
        gvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                a = Integer.valueOf(position);
                itemDrawable = itemLists.get(position).drawable;
                itemTitle = itemLists.get(position).item;
                itemPrice = itemLists.get(position).price;
                itemDesc = itemLists.get(position).description;
                itemQuantity = itemLists.get(position).quantity;
                totalPrice = itemLists.get(position).totalPrice;
                Intent i = new Intent(mainPage.this,itemDescription.class);
                startActivity(i);
                finish();
            }
        });
    }
}