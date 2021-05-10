package com.example.studentdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    EditText signUpemailText,signUpPasswardText;
    Button signUpbtn;
    TextView logInTextView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign Up Activity");
        mAuth = FirebaseAuth.getInstance();
        signUpemailText=findViewById(R.id.signUpeditTextTextEmailAddress2);
        signUpPasswardText=findViewById(R.id.signUpPasswardText);
        signUpbtn=findViewById(R.id.signUpButton);
        logInTextView=findViewById(R.id.signinTextViewId);
        logInTextView.setOnClickListener(this);
        signUpbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.signUpButton:
                userRegister();

                break;
            case R.id.signinTextViewId:
                Intent intent=new Intent(getApplicationContext(),signInActivity.class);
                startActivity(intent);

                break;
        }

    }

    private void userRegister() {
        String email=signUpemailText.getText().toString().trim();
        String password=signUpPasswardText.getText().toString().trim();
        //checking the validity of the email
        if(email.isEmpty())
        {
            signUpemailText.setError("Enter an email address");
            signUpemailText.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signUpemailText.setError("Enter a valid email address");
            signUpemailText.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            signUpPasswardText.setError("Enter a password");
            signUpPasswardText.requestFocus();
            return;
        }
        if(password.length() <6)
        {
            signUpPasswardText.setError("Minimum length of a password should be 6");
            signUpPasswardText.requestFocus();
            return;

        }
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    finish();
                    Intent intent=new Intent(getApplicationContext(),Profile.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);


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


        //kk

    }
}