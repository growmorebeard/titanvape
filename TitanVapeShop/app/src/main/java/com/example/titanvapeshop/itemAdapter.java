package com.example.titanvapeshop;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class itemAdapter extends ArrayAdapter<itemList> {
    public itemAdapter(Context context, ArrayList<itemList> items){
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        itemList itemlist = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem, parent,false);
        }

        ImageView itemImage = (ImageView) convertView.findViewById(R.id.itemImage);
        TextView item = (TextView) convertView.findViewById(R.id.item);
        TextView price = (TextView) convertView.findViewById(R.id.price);

        Drawable myDrawable = itemImage.getResources().getDrawable(itemlist.drawable);
        item.setText(itemlist.item);
        String price1 = Double.toString(itemlist.price);
        price.setText(price1);
        itemImage.setImageDrawable(myDrawable);

        return convertView;
    }
}
