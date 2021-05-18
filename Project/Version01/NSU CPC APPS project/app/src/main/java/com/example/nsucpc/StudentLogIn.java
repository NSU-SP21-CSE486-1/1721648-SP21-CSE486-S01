package com.example.nsucpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudentLogIn extends AppCompatActivity {
    TextView studentlogInActRigText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_log_in);
        studentlogInActRigText=findViewById(R.id.studentrlogactRigText);
        studentlogInActRigText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentLogIn.this,StudentSignUp.class);
                startActivity(intent);
            }
        });
    }
}