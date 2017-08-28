package com.example.imoshikasewwandi.styleomegaassignment;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.imoshikasewwandi.styleomegaassignment.content_provider.PASSWORD;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getActionBar().setTitle("StyleOmega");
        final String []pro ={content_provider.USERNAME,content_provider.PASSWORD};
        final EditText username = (EditText) findViewById(R.id.eUsername);
        final EditText password = (EditText) findViewById(R.id.ePassword);
        final Button LoginBtn = (Button) findViewById(R.id.eLogin);
        final String userinputUsername = username.getText().toString();
        final String userInputPassword = password.getText().toString();
        final TextView linkText = (TextView) findViewById(R.id.registerhere);

            linkText.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent register = new Intent(LoginActivity.this,RegisterActivity.class);
                    LoginActivity.this.startActivity(register);
                }
            });

        LoginBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String URL = "content://com.example.styleomegaassignment.content_provider";

                Uri customers = Uri.parse(URL);
                Cursor c = managedQuery(content_provider.CONTENT_URI1, pro,userinputUsername,null,null);
                while (c.moveToNext()) {
                    if (userinputUsername.equals(content_provider.USERNAME) && userInputPassword.equals(content_provider.PASSWORD)) {
                        LoginBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent mainscreen = new Intent(LoginActivity.this, MainScreen.class);
                                LoginActivity.this.startActivity(mainscreen);
                            }
                        });

                    } else {
                        //Toast.makeText(getBaseContext(),uri.toString(),Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }


}
