package com.example.loginapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Username, Password;
    Button btnLogin;
    String set_username="admin";
    String set_password="admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = findViewById(R.id.username);
        Password = findViewById(R.id.editTextTextPassword);
        btnLogin = findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(Username.getText().toString()) || TextUtils.isEmpty(Password.getText().toString())) {
                    Toast.makeText(MainActivity.this, "please fillup username and passward field", Toast.LENGTH_SHORT).show();


                }else if (Username.getText().toString().equals(set_username)){
                    //check passward
                    if(Password.getText().toString().equals(set_password)){
                        Toast.makeText(MainActivity.this, "log in successful", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "invalid username or passward", Toast.LENGTH_SHORT).show();
                    }
                    
                }else{
                    Toast.makeText(MainActivity.this, "invalid username or passward", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}