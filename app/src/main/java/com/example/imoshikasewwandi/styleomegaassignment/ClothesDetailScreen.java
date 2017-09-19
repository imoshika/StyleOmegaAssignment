package com.example.imoshikasewwandi.styleomegaassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imoshikasewwandi.styleomegaassignment.MODEL_item.Item;
import com.example.imoshikasewwandi.styleomegaassignment.SQL_DATABASE.HelperDatabase;

public class ClothesDetailScreen extends AppCompatActivity implements View.OnClickListener{

    Item item;

    TextView productPDesc;
    TextView productPPrice;
    ImageView productPImage;
    ImageButton imagePButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_detailed_screen);
        HelperDatabase db = new HelperDatabase(this);

        productPDesc = (TextView) findViewById(R.id.productPDesc);
        productPPrice = (TextView) findViewById(R.id.productPPrice);
        productPImage = (ImageView) findViewById(R.id.productPImage);
        imagePButton = (ImageButton) findViewById(R.id.imagePButton);

        Intent i = getIntent();
        String desc = i.getStringExtra("desc");
        item = db.getItem(desc);

        String j = item.getP_desc();
        productPDesc.setText(j);
        productPPrice.setText(String.valueOf(item.getP_price()));
        productPImage.setImageResource(this.getResources().getIdentifier(item.getImage(), "drawable", this.getPackageName()));

        imagePButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(imagePButton.getId() == R.id.imagePButton){
            Toast.makeText(getApplicationContext(), item.getP_desc()+"is added to your cart", Toast.LENGTH_LONG).show();
        }
    }

}
