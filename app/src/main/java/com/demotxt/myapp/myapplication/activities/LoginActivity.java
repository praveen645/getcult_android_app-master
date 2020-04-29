package com.demotxt.myapp.myapplication.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.demotxt.myapp.myapplication.R;

public class LoginActivity extends AppCompatActivity{
    String username;
    String password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        Button login= findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get();
                Toast.makeText(LoginActivity.this,"login!",Toast.LENGTH_SHORT).show();
            }
        });

    }



    public void get()
    {
        EditText edit_username=findViewById(R.id.login_username);
        EditText edit_password=findViewById(R.id.login_password);
        username = edit_username.getText().toString().trim();
        password = edit_password.getText().toString().trim();
        if(username.isEmpty())
        {
            Toast.makeText(LoginActivity.this,"enter a valid username",Toast.LENGTH_SHORT).show();
        }
        else if(username.isEmpty())
        {
            Toast.makeText(LoginActivity.this,"enter a valid password",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
        }
    }



}
