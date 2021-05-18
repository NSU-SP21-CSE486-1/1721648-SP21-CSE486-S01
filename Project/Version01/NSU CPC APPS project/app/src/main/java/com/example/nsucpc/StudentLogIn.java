package com.example.nsucpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudentLogIn extends AppCompatActivity implements View.OnClickListener {
    private TextView studentlogInActRigText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_log_in);
        studentlogInActRigText=(TextView) findViewById(R.id.studentrlogactRigText);
        studentlogInActRigText.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.studentrlogactRigText:
               startActivity(new Intent(this,StudentSignUp.class));
               break;

       }

    }
}