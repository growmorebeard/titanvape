package com.example.titanvapeshop;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class checkoutAdapter extends ArrayAdapter<itemList> {
    public checkoutAdapter(Context context, ArrayList<itemList> items){
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        itemList itemlist = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.checkout_item, parent,false);
        }

        TextView checkout_Title = (TextView) convertView.findViewById(R.id.checkout_Title);
        TextView checkout_price = (TextView) convertView.findViewById(R.id.checkout_price);
        TextView qtyyy = (TextView) convertView.findViewById(R.id.qtyyy);

        checkout_Title.setText(itemlist.item);
        qtyyy.setText(Integer.toString(itemlist.quantity));
        String price1 = Double.toString(itemlist.totalPrice);
        checkout_price.setText(price1);

        return convertView;
    }
}
