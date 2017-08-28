package com.example.imoshikasewwandi.styleomegaassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        //getActionBar().setTitle("StyleOmega");
        final EditText username = (EditText) findViewById(R.id.eUsername);
        final EditText password = (EditText) findViewById(R.id.ePassword);
        final TextView welcomeMsg = (TextView) findViewById(R.id.eWelcomeMsg);

    }
}
