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
    EditText username;
    EditText password;
    EditText Fname;
    EditText Lname;
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

        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EE82EE")));
    }

    private void initlzeViews(){
        final EditText FName = (EditText) findViewById(R.id.eFirstName);
        final EditText Lname = (EditText) findViewById(R.id.eLastName);
        final EditText username = (EditText) findViewById(R.id.eUsername);
        final EditText password = (EditText) findViewById(R.id.ePassword);
        final EditText Age = (EditText) findViewById(R.id.eAge);
        final Button registerBtn = (Button) findViewById(R.id.RegisterBtn);
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
                break;

            case R.id.linkAlready:
                finish();
                break;
        }
    }

    private void emptyEditText(){
        username.setText(null);
        password.setText(null);
        Fname.setText(null);
        Lname.setText(null);
    }
}
