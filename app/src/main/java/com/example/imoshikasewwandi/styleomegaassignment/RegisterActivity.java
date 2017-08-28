package com.example.imoshikasewwandi.styleomegaassignment;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //getActionBar().setTitle("StyleOmega");

        final EditText FName = (EditText) findViewById(R.id.eFirstName);
        final EditText Lname = (EditText) findViewById(R.id.eLastName);
        final EditText username = (EditText) findViewById(R.id.eUsername);
        final EditText password = (EditText) findViewById(R.id.ePassword);
        final EditText Age = (EditText) findViewById(R.id.eAge);
        final Button registerBtn = (Button) findViewById(R.id.RegisterBtn);

        registerBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //add a new customer record
                ContentValues values = new ContentValues();
                values.put(content_provider.FNAME, ((EditText)findViewById(R.id.eFirstName)).getText().toString());
                values.put(content_provider.LNAME, ((EditText)findViewById(R.id.eLastName)).getText().toString());
                values.put(content_provider.USERNAME, ((EditText)findViewById(R.id.eUsername)).getText().toString());
                values.put(content_provider.PASSWORD, ((EditText)findViewById(R.id.ePassword)).getText().toString());
                values.put(content_provider.AGE, ((EditText)findViewById(R.id.eAge)).getText().toString());

                Uri uri = getContentResolver().insert(content_provider.CONTENT_URI1, values);
                Intent login = new Intent(RegisterActivity.this,LoginActivity.class);
                RegisterActivity.this.startActivity(login);
            }
        });


    }
}
