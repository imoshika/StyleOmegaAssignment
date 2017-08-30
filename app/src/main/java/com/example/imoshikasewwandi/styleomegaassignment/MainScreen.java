package com.example.imoshikasewwandi.styleomegaassignment;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        final TextView linkBuy = (TextView) findViewById(R.id.linkBuy);
        final TextView linkAddtocart = (TextView) findViewById(R.id.addToCart);
        final TextView linkSearch = (TextView) findViewById(R.id.searchLink);
        final TextView linkShare = (TextView) findViewById(R.id.shareLink);
        final TextView linkCheckout = (TextView) findViewById(R.id.linkCheckout);
        final TextView linkContact = (TextView) findViewById(R.id.linkContact);

        linkBuy.setOnClickListener(new View.OnClickListener(){
            ContentValues NewValue = new ContentValues();
            @Override
            public void onClick(View v) {
                Intent products = new Intent(MainScreen.this,ProductsDisplayScreen_Activity.class);
                MainScreen.this.startActivity(products);
                //NewValue.put(content_provider.P_TYPE,"Casual Wear");
                //NewValue.put(content_provider.PRODUCT_ID,"1");
                //NewValue.put(content_provider.PRODUCT_NAME,"Blouse");
                //NewValue.put(content_provider.P_DESC,"Top quality custom made 100% cotton women sleeve top blouse");
                //NewValue.put(content_provider.PRICE,1500.00);
                //NewValue.put(content_provider.QUANTITY,2);

                //Uri uri = getContentResolver().insert(content_provider.CONTENT_URI2, NewValue);
            }
        });
    }
}
