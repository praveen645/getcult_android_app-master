package com.demotxt.myapp.myapplication.activities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.demotxt.myapp.myapplication.R;

public class SignupActivity extends AppCompatActivity implements LocationListener {


    private String name, email, password, college, postGraduation, portfolio, username, fieldsOfInterest;
    private String latitude, longitude;
    private static final String[] fields = new String[]
            {
                    "Finance", "ComputerScience", "Arts", "Commerce", "PublicSpeaking", "CodingChallenges", "Politics"
            };


    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText collegeEditText;
    private EditText postGraduationEditText;
    private EditText portfolioEditText;
    private EditText usernameEditText;

    private Button submit;

    protected LocationManager locationManager;
    protected LocationListener locationListener;

    private MultiAutoCompleteTextView multiAutoCompleteTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupform);

        nameEditText = findViewById(R.id.nameSignup);
        emailEditText = findViewById(R.id.emailSignup);
        passwordEditText = findViewById(R.id.passwordSignup);
        collegeEditText = findViewById(R.id.collegeSignup);
        postGraduationEditText = findViewById(R.id.postgraduationSignup);
        portfolioEditText = findViewById(R.id.portfolioSignup);
        usernameEditText = findViewById(R.id.usernameSignup);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        multiAutoCompleteTextView=findViewById(R.id.fieldsOfInterestSignup);
        multiAutoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fields));
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        submit=findViewById(R.id.submitSignup);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String collabTest=get();
                collabTest="latitude:"+latitude+" "+"longitude:"+longitude+" "+collabTest;
                Toast.makeText(SignupActivity.this,collabTest,Toast.LENGTH_LONG).show();
            }
        });
    }

    private String get()
    {
        String collab="";
        name=nameEditText.getText().toString().trim();
        email=emailEditText.getText().toString().trim();
        password=passwordEditText.getText().toString().trim();
        college=collegeEditText.getText().toString().trim();
        postGraduation=postGraduationEditText.getText().toString().trim();
        portfolio=portfolioEditText.getText().toString().trim();
        username=usernameEditText.getText().toString().trim();
        fieldsOfInterest=multiAutoCompleteTextView.getText().toString().trim();

        if(name.isEmpty() || email.isEmpty() || password.isEmpty() || college.isEmpty() || username.isEmpty())
        {
            Toast.makeText(SignupActivity.this, "enter all the mandatory fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            collab =name+" || "+email+" || "+password+" || "+college+" || "+postGraduation+" || "+portfolio+" || "+username+" || "+fieldsOfInterest;

        }
        return collab;
    }

    @Override
    public void onLocationChanged(Location location) {
    latitude=Double.toString(location.getLatitude());
    longitude=Double.toString(location.getLongitude());


    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }



}
