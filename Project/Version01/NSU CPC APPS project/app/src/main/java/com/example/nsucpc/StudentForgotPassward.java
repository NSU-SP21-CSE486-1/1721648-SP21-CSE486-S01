package com.example.nsucpc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class StudentForgotPassward extends AppCompatActivity {
    private EditText forgotPassStudentEmailAddress;
    private Button studentResetPassButton;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_forgot_passward);
        studentResetPassButton=(Button)findViewById(R.id.studentResetPassButton);
        forgotPassStudentEmailAddress=(EditText)findViewById(R.id.forgotPassStudentEmailAddress);

        auth = FirebaseAuth.getInstance();

        studentResetPassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentResetPassward();

            }
        });


    }
    private void studentResetPassward(){
        String studentMail =forgotPassStudentEmailAddress.getText().toString().trim();
        if(studentMail.isEmpty()){
            forgotPassStudentEmailAddress.setError("Nsu Mail id is Required");
            forgotPassStudentEmailAddress.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(studentMail).matches()){
            forgotPassStudentEmailAddress.setError("Please input valid mail address");
            forgotPassStudentEmailAddress.requestFocus();
            return;

        }
        auth.sendPasswordResetEmail(studentMail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull  Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Check Your email to reset Passward",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Try again ! something wrong happened",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}