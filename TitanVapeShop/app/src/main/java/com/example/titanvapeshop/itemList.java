package com.example.titanvapeshop;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class itemList {
    public int drawable;
    public String item;
    public double price;
    public String description;
    public int quantity;
    public double totalPrice;

    public itemList(int drawable, String item, double price, String description, int quantity, double totalPrice){
        this.drawable = drawable;
        this.item = item;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
