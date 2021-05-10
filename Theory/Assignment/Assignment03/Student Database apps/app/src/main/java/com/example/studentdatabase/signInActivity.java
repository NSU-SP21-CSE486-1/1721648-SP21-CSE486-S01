package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signInActivity extends AppCompatActivity implements View.OnClickListener {
     EditText logInemailText,logInPasswardText;
     Button loginbtn;
     TextView signUpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        this.setTitle("Log In Activity");
        logInemailText=findViewById(R.id.editTextTextEmailAddress2);
        logInPasswardText=findViewById(R.id.loginPasswardText);
        loginbtn=findViewById(R.id.logInButton);
        signUpTextView=findViewById(R.id.signUpTextViewId);
        signUpTextView.setOnClickListener(this);
        loginbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.logInButton:

                break;
            case R.id.signinTextViewId:
                Intent intent=new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);

                break;
        }

    }
}