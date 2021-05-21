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

public class logInCpcMember extends AppCompatActivity implements View.OnClickListener {
    private TextView cpcMemberLoginActReg ,cpcMemberLoginForgotPass;
    private EditText cpcLogInEmail ,cpcLogInPassward ;
    private Button cpcLogInButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_cpc_member);
        cpcMemberLoginActReg = (TextView) findViewById(R.id.cpcMemberLoginActReg);
        cpcLogInEmail=(EditText)findViewById(R.id.cpcLogInEmail) ;
        cpcLogInPassward=(EditText)findViewById(R.id.cpcMemberLoginPassword) ;
        cpcLogInButton=(Button)findViewById(R.id.cpcMemberLoginButton) ;
        cpcMemberLoginForgotPass=(TextView)findViewById(R.id.cpcMemberLoginForgotPass);
        mAuth=FirebaseAuth.getInstance();
        
        cpcMemberLoginActReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cpcMemberLoginActReg:
                startActivity(new Intent(this, CpcmemberSignUpActivity.class));
                break;
            case R.id.cpcMemberLoginForgotPass:
                startActivity(new Intent(this,StudentForgotPassward.class));
                break;
            case R.id.cpcMemberLoginButton:
                cpcUserLogin();
                break;

        }
    }
    private void cpcUserLogin() {
        String email=cpcLogInEmail.getText().toString().trim();
        String password=cpcLogInPassward.getText().toString().trim();
        if(email.isEmpty()){
            cpcLogInEmail.setError("Nsu Mail id is Required");
            cpcLogInEmail.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            cpcLogInEmail.setError("Please input valid mail address");
            cpcLogInEmail.requestFocus();
            return;

        }

        if(password.isEmpty()){
            cpcLogInPassward.setError("Fill Up passward field");
            cpcLogInPassward.requestFocus();
            return;
        }
        if(password.length()<6){
            cpcLogInPassward.setError("Min passward length should be 6 characters");
            cpcLogInPassward.requestFocus();
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