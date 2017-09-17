package com.example.imoshikasewwandi.styleomegaassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imoshikasewwandi.styleomegaassignment.MODEL_user.User;
import com.example.imoshikasewwandi.styleomegaassignment.SQL_DATABASE.HelperDatabase;

public class UpdateProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private final AppCompatActivity act = UpdateProfileActivity.this;

    EditText cust_username;
    EditText cust_password;
    EditText Fname;
    EditText Lname;
    EditText Contact_number;
    EditText Email;
    Button updateBtn;

    private HelperDatabase dbHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        getSupportActionBar().hide();

        initlzeViews();
        initlzeListeners();
        initlzeObjects();
    }

    private void initlzeViews(){
        Fname = (EditText) findViewById(R.id.eFirstName);
        Lname = (EditText) findViewById(R.id.eLastName);
        cust_username = (EditText) findViewById(R.id.eUsername);
        cust_password = (EditText) findViewById(R.id.ePassword);
        Contact_number = (EditText) findViewById(R.id.eContact);
        Email = (EditText) findViewById(R.id.eEmail);
        updateBtn = (Button) findViewById(R.id.registerBtn);

    }

    private void initlzeListeners() {
        updateBtn.setOnClickListener(this);
    }

    private void initlzeObjects(){
        dbHelper = new HelperDatabase(act);
        user = new User();
    }

    @Override
    public void onClick(View v) {
        if(updateBtn.getId() == R.id.updateBtn){
            user.setU_fname(Fname.getText().toString().trim());
            user.setU_lname(Lname.getText().toString().trim());
            user.setUsername(cust_username.getText().toString().trim());
            user.setU_password(cust_password.getText().toString().trim());
            user.setU_email(Email.getText().toString().trim());
            user.setContact(Contact_number.getText().toString().trim());

            dbHelper.updateCustomer(user);
            Toast.makeText(getApplicationContext(), "your account has been successfully updated", Toast.LENGTH_LONG).show();
            Intent mainscreen = new Intent(act, MainScreen.class);
            startActivity(mainscreen);
        }
        else{
            Toast.makeText(getApplicationContext(), "your account has not been updated yet", Toast.LENGTH_LONG).show();
        }
    }


}
