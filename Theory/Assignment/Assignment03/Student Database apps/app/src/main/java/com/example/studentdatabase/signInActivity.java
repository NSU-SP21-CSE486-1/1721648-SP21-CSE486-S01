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

public class signInActivity extends AppCompatActivity implements View.OnClickListener {
    EditText logInemailText, logInPasswardText;
    Button loginbtn;
    TextView signUpTextView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        this.setTitle("Log In Activity");
        mAuth = FirebaseAuth.getInstance();
        logInemailText = findViewById(R.id.editTextTextEmailAddress2);
        logInPasswardText = findViewById(R.id.loginPasswardText);
        loginbtn = findViewById(R.id.logInButton);
        signUpTextView = findViewById(R.id.signUpTextViewId);
        signUpTextView.setOnClickListener(this);
        loginbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logInButton:
                userLogin();

                break;
            case R.id.signinTextViewId:
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);

                break;
        }

    }

    private void userLogin() {
        String email = logInemailText.getText().toString().trim();
        String password = logInPasswardText.getText().toString().trim();
        //checking the validity of the email
        if (email.isEmpty()) {
            logInemailText.setError("Enter an email address");
            logInemailText.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            logInemailText.setError("Enter a valid email address");
            logInemailText.requestFocus();
            return;
        }

        //checking the validity of the password
        if (password.isEmpty()) {
            logInPasswardText.setError("Enter a password");
            logInPasswardText.requestFocus();
            return;
        }
        if (password.length() < 6) {
            logInPasswardText.setError("Minimum length of a password should be 6");
            logInPasswardText.requestFocus();
            return;


        }
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    finish();
                    Intent intent=new Intent(getApplicationContext(),Profile.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);


                } else {
                    Toast.makeText(getApplicationContext(),"Log in unsuccessful",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}