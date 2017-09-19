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
 * Created by Imoshika Sewwandi on 9/20/2017.
 */

public class CartAdapter extends ArrayAdapter<Cart_modelClass> {
    Context context;
    //  List<Item> productitems = null;
    List<Cart_modelClass> cartItems =new ArrayList<>();
    int Lid;


    public CartAdapter(Context context, int Lid, List<Cart_modelClass> cartItems) {
        super(context, Lid, cartItems);
        this.context = context;
        this.Lid = Lid;
        this.cartItems = cartItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ItemView = convertView;

        LayoutInflater productInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ItemView = productInflater.inflate(R.layout.cart_row, null);

        Cart_modelClass cart = getItem(position);
        /*TextView productDesc = (TextView) ItemView.findViewById(R.id.productDesc);
        TextView productPrice = (TextView) ItemView.findViewById(R.id.productPrice);
        ImageView image = (ImageView) ItemView.findViewById(R.id.productImage);
        ImageButton btnCart = (ImageButton) ItemView.findViewById(R.id.cartImage);
        productDesc.setText(item.getP_desc());
        productPrice.setText(String.valueOf(item.getP_price()));

        int id = context.getResources().getIdentifier(item.getImage(), "drawable", context.getPackageName());
        //int id = getContext().getResources().getIdentifier(item.getImage(), null, null);
        image.setImageResource(id);*/


        return ItemView;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }
}
