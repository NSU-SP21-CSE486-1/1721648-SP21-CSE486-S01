package com.example.nsucpc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.FirebaseDatabase;

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
        if(editTextStudentPassword.length()<6){
            studentSignUpPassward.setError("Min passward length should be 6 characters");
            studentSignUpPassward.requestFocus();
            return;

        }
        if(editTextStudentId.isEmpty()){
            studentSignUpId.setError("Fill Up your nsu student id");
            studentSignUpId.requestFocus();
            return;
        }
        if(editTextStudentId.length()>7 ||editTextStudentId.length()<7){
            studentSignUpId.setError("Please input your 7 digit of nsu id");
            studentSignUpId.requestFocus();
            return;
        }
        if(editTextStudentPhone.isEmpty()){
            studentSignUpPhone.setError("Fill Up Your Mobile Number");
            studentSignUpPhone.requestFocus();
            return;
        }
        if(editTextStudentPhone.length()>11 ||editTextStudentPhone.length()<11){
            studentSignUpPhone.setError("Please input valid mobile number of 11 digits");
            studentSignUpPhone.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(editTextStudentEmailAddress, editTextStudentPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    studentUser studentuser =new studentUser(editTextPersonName, editTextStudentEmailAddress,editTextStudentId,editTextStudentPhone);
                    FirebaseDatabase.getInstance().getReference("StudentUsers")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(studentuser).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull  Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"User has been Registered successfully",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Failed to register !Try again!",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                    //finish();
                   // Intent intent=new Intent(getApplicationContext(),StudentLogIn.class);
                    //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    //startActivity(intent);


                }
                else if(task.getException() instanceof FirebaseAuthUserCollisionException)

                {
                    Toast.makeText(getApplicationContext(),"User is already Registered",Toast.LENGTH_SHORT).show();
                }

                else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(getApplicationContext(),"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}