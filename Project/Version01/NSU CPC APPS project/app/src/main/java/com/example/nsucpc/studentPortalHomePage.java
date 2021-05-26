package com.example.nsucpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class studentPortalHomePage extends AppCompatActivity {
    private ImageButton allPostbutton,logoutButton,appliedJobButton,userProfileHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_portal_home_page);
        allPostbutton=(ImageButton)findViewById(R.id.viewallPostHome);
        logoutButton=(ImageButton)findViewById(R.id.logOutImgButton);
        appliedJobButton=(ImageButton)findViewById(R.id.appliedimgBtn);
        userProfileHomeButton=(ImageButton)findViewById(R.id.userprofileButton);

        allPostbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(studentPortalHomePage.this,StudentAllPost.class);
                startActivity(intent);

            }
        });

        userProfileHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(studentPortalHomePage.this,studentUser.class);
                startActivity(intent);

            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(studentPortalHomePage.this,studentUser.class));

               // Intent intent = new Intent(studentPortalHomePage.this,MemberStudentPortal.class);
               // startActivity(intent);

            }
        });







    }
}