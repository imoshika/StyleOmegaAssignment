package com.example.imoshikasewwandi.styleomegaassignment;

import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.imoshikasewwandi.styleomegaassignment.HELPER_PKG.ValidationInput;
import com.example.imoshikasewwandi.styleomegaassignment.MODEL_user.User;
import com.example.imoshikasewwandi.styleomegaassignment.SQL_DATABASE.HelperDatabase;
import com.idescout.sql.SqlScoutServer;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    EditText username;
    EditText password;
    Button LoginBtn;
    TextView linkText;


    private final AppCompatActivity act = LoginActivity.this;
    private NestedScrollView nestedScrollView;

    private ValidationInput inputValidation;
    private HelperDatabase dbHelper;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        SqlScoutServer.create(this, getPackageName());

        initlzeViews();
        initlzeListeners();
        initlzeObjects();

        /*ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EE82EE")));*/
    }

    private void initlzeViews(){
        username = (EditText) findViewById(R.id.eUsername);
        password = (EditText) findViewById(R.id.ePassword);
        LoginBtn = (Button) findViewById(R.id.eLogin);
        linkText = (TextView) findViewById(R.id.registerhere);
    }

    private void initlzeListeners(){
        LoginBtn.setOnClickListener(this);
        linkText.setOnClickListener(this);
    }

    private void initlzeObjects(){
        dbHelper = new HelperDatabase(act);
        inputValidation = new ValidationInput(act);
        user = new User();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.eLogin:
                Verify();
                break;
            case R.id.registerhere:
                Intent register = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(register);
                break;
        }

    }


    private void Verify(){
        if(dbHelper.CheckCustomer(username.getText().toString().trim(), password.getText().toString().trim())){
            Intent products = new Intent(act, MainScreen.class);
            startActivity(products);
        }
        else{

        }
    }

}
