package com.example.nsucpc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class studentPortalHomePage extends AppCompatActivity {
    private ImageButton allPostbutton,logoutButton,appliedJobButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_portal_home_page);
    }
}