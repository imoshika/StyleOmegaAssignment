package com.example.imoshikasewwandi.styleomegaassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.imoshikasewwandi.styleomegaassignment.MODEL_item.Item;
import com.example.imoshikasewwandi.styleomegaassignment.SQL_DATABASE.HelperDatabase;

import java.util.List;

public class MainScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    HelperDatabase db;
    List<Item> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_catagories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.updateInfo){
            Intent dress = new Intent(MainScreen.this, UpdateProfileActivity.class);
            startActivity(dress);
        }
        else if (id == R.id.womenDress) {
            Intent dress = new Intent(MainScreen.this, WomenDresses.class);
            startActivity(dress);


        } else if (id == R.id.womenJeans) {
            Intent jean = new Intent(MainScreen.this, WomenJeans.class);
            startActivity(jean);

        } else if (id == R.id.womenSkirts) {
            Intent skirt = new Intent(MainScreen.this, WomenSkirts.class);
            startActivity(skirt);
        }  else if (id == R.id.womenTopWear) {
            Intent tops = new Intent(MainScreen.this, WomenTopwear.class);
            startActivity(tops);

        } else if (id == R.id.womenJumpsuits) {
            Intent jumpsuit = new Intent(MainScreen.this, WomenJumpsuits.class);
            startActivity(jumpsuit);
        } else if(id == R.id.menShirts){
            Intent menShirts = new Intent(MainScreen.this, MenShirts.class);
            startActivity(menShirts);
        }else if(id == R.id.menJackets) {
            Intent menJackets = new Intent(MainScreen.this, MenJackets.class);
            startActivity(menJackets);
        }else if(id == R.id.menJeans) {
            Intent menJeans = new Intent(MainScreen.this, MenJeans.class);
            startActivity(menJeans);
        }
        else if(id == R.id.menShorts) {
            Intent menShorts = new Intent(MainScreen.this, MenShorts.class);
            startActivity(menShorts);
        }
        else if(id == R.id.menTshirts) {
            Intent mentshirt = new Intent(MainScreen.this, MenTShirts.class);
            startActivity(mentshirt);
        }else if(id == R.id.kidsWear){
            Intent kids = new Intent(MainScreen.this, KidsWear.class);
            startActivity(kids);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
