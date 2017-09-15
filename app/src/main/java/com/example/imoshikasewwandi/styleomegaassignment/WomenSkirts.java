package com.example.imoshikasewwandi.styleomegaassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.imoshikasewwandi.styleomegaassignment.MODEL_item.Item;
import com.example.imoshikasewwandi.styleomegaassignment.SQL_DATABASE.HelperDatabase;

import java.util.ArrayList;
import java.util.List;

public class WomenSkirts extends AppCompatActivity {

    List<Item> items;
    ListView womenSkirtsList;
    HelperDatabase db;
    Item i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_skirts);

        womenSkirtsList = (ListView) findViewById(R.id.womenSkirtList);
        items = new ArrayList<>();
        db = new HelperDatabase(this);
        i = new Item();

        populateList();
    }

    public void populateList(){
        items = db.getAllProductItems();

        ArrayList <Item> onlySkirts = new ArrayList<>();
        Item item = null;
        for(int i = 0; i<items.size(); i++){
            item = items.get(i);
            if(item.getP_name().equals("Women skirt")){
                onlySkirts.add(item);
            }
        }

        ProductsAdapter pItemAdapter = new ProductsAdapter(this, R.layout.user_row, onlySkirts);
        womenSkirtsList.setAdapter(pItemAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_catagories, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.womenDress) {
            Intent dress = new Intent(WomenSkirts.this, WomenDresses.class);
            startActivity(dress);

        } else if (id == R.id.womenJeans) {
            Intent jean = new Intent(WomenSkirts.this, WomenJeans.class);
            startActivity(jean);

        } else if (id == R.id.womenSkirts) {
            Intent skirt = new Intent(WomenSkirts.this, WomenSkirts.class);
            startActivity(skirt);
        } else if (id == R.id.womenSweaters) {
            Intent sweater = new Intent(WomenSkirts.this, WomenSweaters.class);
            startActivity(sweater);

        } else if (id == R.id.womenTopWear) {
            Intent tops = new Intent(WomenSkirts.this, WomenTopwear.class);
            startActivity(tops);

        } else if (id == R.id.womenJumpsuits) {
            Intent jumpsuit = new Intent(WomenSkirts.this, WomenJumpsuits.class);
            startActivity(jumpsuit);
        }

        return super.onOptionsItemSelected(item);
    }
}
