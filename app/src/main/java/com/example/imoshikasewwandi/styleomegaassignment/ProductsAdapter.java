package com.example.imoshikasewwandi.styleomegaassignment;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imoshikasewwandi.styleomegaassignment.MODEL_item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imoshika Sewwandi on 9/9/2017.
 */

public class ProductsAdapter extends ArrayAdapter<Item> {
    Context context;
  //  List<Item> productitems = null;
    List<Item> productitems =new ArrayList<>();
    int Lid;


    public ProductsAdapter(Context context, int Lid, List<Item> productitems) {
        super(context, Lid, productitems);
        this.context = context;
        this.Lid = Lid;
        this.productitems = productitems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ItemView = convertView;

        LayoutInflater productInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ItemView = productInflater.inflate(R.layout.user_row, null);

        Item item = getItem(position);
        TextView productDesc = (TextView) ItemView.findViewById(R.id.productDesc);
        TextView productPrice = (TextView) ItemView.findViewById(R.id.productPrice);
        ImageView image = (ImageView) ItemView.findViewById(R.id.productImage);
        ImageButton btnCart = (ImageButton) ItemView.findViewById(R.id.cartImage);
        productDesc.setText(item.getP_desc());
        productPrice.setText(String.valueOf(item.getP_price()));

        //int id = context.getResources().getIdentifier(item.getImage(), "drawable", context.getPackageName());
        int id = getContext().getResources().getIdentifier(item.getImage(), null, null);
        image.setImageResource(id);


        return ItemView;
    }
}
