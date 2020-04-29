package com.demotxt.myapp.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.demotxt.myapp.myapplication.R;

public class FirstScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);
        Button signupFirstScreen=findViewById(R.id.first_screen_signup);
        Button loginFirstScreen=findViewById(R.id.first_screen_login);
        signupFirstScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupactivity=new Intent(FirstScreen.this,SignupActivity.class);
                startActivity(signupactivity);
            }
        });


        loginFirstScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginActivity=new Intent(FirstScreen.this,LoginActivity.class);
                startActivity(loginActivity);
            }
        });
    }
}
