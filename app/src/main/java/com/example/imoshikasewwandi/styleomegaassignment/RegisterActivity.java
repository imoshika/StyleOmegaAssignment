package com.example.imoshikasewwandi.styleomegaassignment;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imoshikasewwandi.styleomegaassignment.HELPER_PKG.ValidationInput;
import com.example.imoshikasewwandi.styleomegaassignment.MODEL_user.User;
import com.example.imoshikasewwandi.styleomegaassignment.SQL_DATABASE.HelperDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private final AppCompatActivity act = RegisterActivity.this;

    EditText cust_username;
    EditText cust_password;
    EditText Fname;
    EditText Lname;
    EditText Contact_number;
    EditText Email;
    TextView linkAlready;
    Button registerBtn;

    private ValidationInput inputValidation;
    private HelperDatabase dbHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        initlzeViews();
        initlzeListeners();
        initlzeObjects();

        /*ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EE82EE")));*/
    }

    private void initlzeViews(){
        Fname = (EditText) findViewById(R.id.eFirstName);
        Lname = (EditText) findViewById(R.id.eLastName);
        cust_username = (EditText) findViewById(R.id.eUsername);
        cust_password = (EditText) findViewById(R.id.ePassword);
        Contact_number = (EditText) findViewById(R.id.eContact);
        Email = (EditText) findViewById(R.id.eEmail);
        registerBtn = (Button) findViewById(R.id.RegisterBtn);
        linkAlready = (TextView) findViewById(R.id.linkAlready);
    }

    private void initlzeListeners(){
        registerBtn.setOnClickListener(this);
        linkAlready.setOnClickListener(this);
    }

    private void initlzeObjects(){
        dbHelper = new HelperDatabase(act);
        user = new User();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.RegisterBtn:
                DataToSQLite();
                break;

            case R.id.linkAlready:
                finish();
                break;
        }
    }

    private void DataToSQLite(){
        if(!dbHelper.CheckCustomer(cust_username.getText().toString().trim(), cust_password.getText().toString().trim())){
            user.setID(user.getID());
            user.setU_fname(Fname.getText().toString().trim());
            user.setU_lname(Lname.getText().toString().trim());
            user.setUsername(cust_username.getText().toString().trim());
            user.setU_password(cust_password.getText().toString().trim());
            user.setU_email(Email.getText().toString().trim());
            user.setContact(Contact_number.getText().toString().trim());

            dbHelper.addCustomer(user);

            Toast.makeText(getApplicationContext(), "You have successfully been registered", Toast.LENGTH_LONG).show();
            Intent correctLogin = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(correctLogin);

            emptyEditText();
        }
        else{
            Toast.makeText(getApplicationContext(), "registration unsuccessful", Toast.LENGTH_LONG).show();
        }
    }

    private void emptyEditText(){
        cust_username.setText(null);
        cust_password.setText(null);
        Fname.setText(null);
        Lname.setText(null);
        Contact_number.setText(null);
        Email.setText(null);
    }
}
