package com.example.imoshikasewwandi.styleomegaassignment;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

    private DrawerLayout dLayout;
    private ActionBarDrawerToggle tog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        dLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        tog = new ActionBarDrawerToggle(this, dLayout, R.string.open, R.string.close);

        dLayout.addDrawerListener(tog);
        tog.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(tog.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
