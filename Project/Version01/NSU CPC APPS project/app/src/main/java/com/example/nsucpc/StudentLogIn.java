package com.example.nsucpc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.FirebaseDatabase;

public class StudentLogIn extends AppCompatActivity implements View.OnClickListener {
    private TextView studentlogInActRigText ,studentForgotPassward;
    private EditText studentLogInEmail ,studentLogInPassward ;
    private Button studentLogInButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_log_in);
        studentlogInActRigText=(TextView) findViewById(R.id.studentrlogactRigText);
        studentLogInEmail=(EditText)findViewById(R.id.editTextTextEmailAddressStLogin);
        studentLogInPassward=(EditText)findViewById(R.id.editTextTextPasswordStLogin);
        studentLogInButton=(Button)findViewById(R.id.studentLoginButton);
        studentForgotPassward=(TextView)findViewById(R.id.studentForgotPassward);
        mAuth=FirebaseAuth.getInstance();
        studentlogInActRigText.setOnClickListener(this);
        studentLogInButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.studentrlogactRigText:
               startActivity(new Intent(this,StudentSignUp.class));
               break;
           case R.id.studentLoginButton:
               studerUserLogin();

       }

    }

    private void studerUserLogin() {
        String email=studentLogInEmail.getText().toString().trim();
        String password=studentLogInPassward.getText().toString().trim();
        if(email.isEmpty()){
            studentLogInEmail.setError("Nsu Mail id is Required");
            studentLogInEmail.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            studentLogInEmail.setError("Please input valid mail address");
            studentLogInEmail.requestFocus();
            return;

        }

        if(password.isEmpty()){
            studentLogInPassward.setError("Fill Up passward field");
            studentLogInPassward.requestFocus();
            return;
        }
        if(password.length()<6){
            studentLogInPassward.setError("Min passward length should be 6 characters");
            studentLogInPassward.requestFocus();
            return;

        }
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    finish();
                    Intent intent=new Intent(getApplicationContext(),MemberStudentPortal.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }

                else{
                    Toast.makeText(getApplicationContext(),"Failed to log in! Please check your credentials",Toast.LENGTH_SHORT).show();
                }

                        }
                    });


    }

}