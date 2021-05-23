package com.example.nsucpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Profile extends AppCompatActivity implements View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonSignUpStudent:
                StudentAddProfile();
                break;
        }
    }
    private void StudentAddProfile(){

    }
}