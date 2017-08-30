package com.example.imoshikasewwandi.styleomegaassignment;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ProductsDisplayScreen_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_display_screen_);
       /* ListView product_list = (ListView) findViewById(R.id.productList);
        SimpleCursorAdapter CAdapter;


        //String []product_Pro ={content_provider.PRODUCT_NAME,content_provider.P_DESC,content_provider.P_TYPE};
        int[] product_items = {R.drawable.background1, R.drawable.background2};
        String URL = "content://com.example.styleomegaassignment.content_provider";


        Uri products = Uri.parse(URL);
       // Cursor c = managedQuery(content_provider.CONTENT_URI2, product_Pro,content_provider.PRODUCT_NAME,null,null);

        CAdapter = new SimpleCursorAdapter(getApplicationContext(),R.layout.activity_products_display_screen_,c,product_Pro,product_items,0);
        product_list.setAdapter(CAdapter);*/
    }
}
