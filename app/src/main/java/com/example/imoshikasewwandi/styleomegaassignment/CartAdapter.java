package com.example.imoshikasewwandi.styleomegaassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.imoshikasewwandi.styleomegaassignment.SQL_DATABASE.HelperDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imoshika Sewwandi on 9/20/2017.
 */

public class CartAdapter extends ArrayAdapter<Cart> implements View.OnClickListener{
    Context context;
    List<Cart> cartItems =new ArrayList<>();
    int Lid;
    HelperDatabase db;

    public CartAdapter(Context context, int Lid, List<Cart> cartItems) {
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

        Cart cart = getItem(position);
        TextView pDesc = (TextView) ItemView.findViewById(R.id.pDesc);
        TextView pPrice = (TextView) ItemView.findViewById(R.id.pPrice);
        ImageView image = (ImageView) ItemView.findViewById(R.id.pImage);
        ImageButton removeCart = (ImageButton) ItemView.findViewById(R.id.removecartImage);

        db = new HelperDatabase(getContext());

        pDesc.setText(cart.getP_desc());
        pPrice.setText(String.valueOf(cart.getPrice()));

        int id = context.getResources().getIdentifier(cart.getImage(), "drawable", context.getPackageName());
        image.setImageResource(id);

        return ItemView;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }


    @Override
    public void onClick(View v) {

    }
}
