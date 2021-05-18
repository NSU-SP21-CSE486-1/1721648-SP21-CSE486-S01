package com.example.nsucpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MemberStudentPortal extends AppCompatActivity {
    ImageButton studentPortal , cpcMemberPortal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_student_portal);
        studentPortal=findViewById(R.id.studentportalbtn);
        cpcMemberPortal=findViewById(R.id.cpcMemberPortalButton);
        studentPortal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MemberStudentPortal.this,StudentLogIn.class);
                startActivity(intent);

            }
        });
        cpcMemberPortal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MemberStudentPortal.this,logInCpcMember.class);
                startActivity(intent);

            }
        });
    }
}