package com.example.titanvapeshop;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.ArrayList;

public class myCartAdapter extends ArrayAdapter<itemList> {
    private Activity myCartAdapter;
    public myCartAdapter(Context context, ArrayList<itemList> items, Activity myCartAdapter){
        super(context, 0, items);
        this.myCartAdapter = myCartAdapter;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        itemList itemlist = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cart_item, parent,false);
        }

        ImageView imageCart = (ImageView) convertView.findViewById(R.id.imageCart);
        TextView titleCart = (TextView) convertView.findViewById(R.id.titleCart);
        TextView priceCart = (TextView) convertView.findViewById(R.id.priceCart);

        ImageView imgDelete = (ImageView) convertView.findViewById(R.id.imgDelete);
        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(myCartAdapter);
                alertDialogBuilder.setTitle("Confirmation");
                alertDialogBuilder.setMessage("Are you sure you want to delete?");
                alertDialogBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cart.checkoutLists.remove(cart.checkoutLists.get(position));
                        Intent i = new Intent(myCartAdapter,cart.class);
                        myCartAdapter.startActivity(i);
                        myCartAdapter.finish();
                    }
                });
                alertDialogBuilder.setNegativeButton("Cancel", null);
                alertDialogBuilder.show();
            }
        });
        Drawable myDrawable = imageCart.getResources().getDrawable(itemlist.drawable);
        titleCart.setText(itemlist.item);
        String price1 = Double.toString(itemlist.price);
        priceCart.setText(price1);
        imageCart.setImageDrawable(myDrawable);

        ElegantNumberButton button = (ElegantNumberButton) convertView.findViewById(R.id.number_button);
        button.setNumber(String.valueOf(cart.checkoutLists.get(position).quantity));

        button.setOnValueChangeListener((view, oldValue, newValue) -> {
            int count = Integer.parseInt(button.getNumber());
            cart.checkoutLists.get(position).quantity = count;
            cart.checkoutLists.get(position).totalPrice = cart.checkoutLists.get(position).price *cart.checkoutLists.get(position).quantity;

            double sum = 0;
            for (int i = 0; i < cart.checkoutLists.size(); i++){
                sum = sum + cart.checkoutLists.get(i).totalPrice;
            }
            cart.total = Double. toString(sum);
            cart.totalPrice.setText(cart.total);
        });

        return convertView;
    }
}
