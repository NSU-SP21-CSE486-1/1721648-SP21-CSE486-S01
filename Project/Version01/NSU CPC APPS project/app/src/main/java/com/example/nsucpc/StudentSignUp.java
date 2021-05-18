package com.example.nsucpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudentSignUp extends AppCompatActivity {
    TextView studentSigninTextViewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);
        studentSigninTextViewId=findViewById(R.id.signinTextViewIdCpc);
        studentSigninTextViewId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentSignUp.this,StudentLogIn.class);
                startActivity(intent);
            }
        });
    }
}