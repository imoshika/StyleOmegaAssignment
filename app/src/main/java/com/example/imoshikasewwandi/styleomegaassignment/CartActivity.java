package com.example.imoshikasewwandi.styleomegaassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.imoshikasewwandi.styleomegaassignment.SQL_DATABASE.HelperDatabase;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements View.OnClickListener{

    ListView cartList;
    Cart cart;
    HelperDatabase db;
    CartAdapter cAdapter;
    List<Cart> listCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartList = (ListView) findViewById(R.id.cartdetails);
        listCart = new ArrayList<>();
        //listCart = db.getCartItem();
        db = new HelperDatabase(this);
        cart = new Cart();

    }

    public void populateList(){

        //cAdapter = new CartAdapter(this, listCart);
        cartList.setAdapter(cAdapter);
        cartList.setClickable(true);
    }

    @Override
    public void onClick(View v) {

    }
}
