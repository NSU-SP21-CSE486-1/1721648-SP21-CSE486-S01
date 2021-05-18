package com.example.nsucpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class StudentSignUp extends AppCompatActivity implements View.OnClickListener {
    TextView studentSigninTextViewId;
    EditText studentSignUpName,studentSignUpEmail,studentSignUpPassward,studentSignUpId,studentSignUpPhone ;
    Button buttonSignUpStudent ;
    CheckBox termAgree;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);
        mAuth = FirebaseAuth.getInstance();
        studentSigninTextViewId=findViewById(R.id.signinTextViewIdstudent);
        studentSignUpName=findViewById(R.id.editTextPersonName);
        studentSignUpEmail=findViewById(R.id.editTextStudentEmailAddress);
        studentSignUpPassward=findViewById(R.id.editTextStudentPassword);
        studentSignUpId=findViewById(R.id.editTextStudentId);
        studentSignUpPhone=findViewById(R.id.editTextStudentPhone);
        buttonSignUpStudent=findViewById(R.id.buttonSignUpStudent);
        termAgree=findViewById(R.id.termAgree);
        studentSigninTextViewId.setOnClickListener(this);
        buttonSignUpStudent.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signinTextViewIdstudent:
                startActivity(new Intent(this,StudentLogIn.class));
                break;
            case R.id.buttonSignUpStudent:
                StudentSignUp();
                break;
        }

    }
    private void  StudentSignUp(){
        String editTextStudentEmailAddress=studentSignUpEmail.getText().toString().trim();
        String editTextPersonName= studentSignUpName.getText().toString().trim();
        String editTextStudentPassword= studentSignUpPassward.getText().toString().trim();
        String editTextStudentId= studentSignUpId.getText().toString().trim();
        String editTextStudentPhone=studentSignUpPhone.getText().toString().trim();


        if(editTextStudentEmailAddress.isEmpty()){
            studentSignUpEmail.setError("Nsu Mail id is Required");
            studentSignUpEmail.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(editTextStudentEmailAddress).matches()){
            studentSignUpEmail.setError("Please input valid mail address");
            studentSignUpEmail.requestFocus();
            return;

        }
        if(editTextPersonName.isEmpty()){
            studentSignUpName.setError("Fill Up Your name");
            studentSignUpName.requestFocus();
            return;
        }
        if(editTextStudentPassword.isEmpty()){
            studentSignUpPassward.setError("Fill Up passward field");
            studentSignUpPassward.requestFocus();
            return;
        }
        if(editTextStudentId.isEmpty()){
            studentSignUpId.setError("Fill Up your nsu student id");
            studentSignUpId.requestFocus();
            return;
        }
        if(editTextStudentPhone.isEmpty()){
            studentSignUpPhone.setError("Fill Up Your Mobile Number");
            studentSignUpPhone.requestFocus();
            return;
        }


    }
}