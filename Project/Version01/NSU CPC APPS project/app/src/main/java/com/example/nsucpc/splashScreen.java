package com.example.nsucpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler=new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(splashScreen.this,MemberStudentPortal.class));
            finish();

        },3000
        
        );
        Toast.makeText(this,"Welcome to NSU CPC",Toast.LENGTH_SHORT).show();
    }
}