package com.example.nsucpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class logInCpcMember extends AppCompatActivity implements View.OnClickListener {
    private TextView cpcMemberLoginActReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_cpc_member);
        cpcMemberLoginActReg = (TextView) findViewById(R.id.cpcMemberLoginActReg);
        cpcMemberLoginActReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cpcMemberLoginActReg:
                startActivity(new Intent(this, CpcmemberSignUpActivity.class));
                break;

        }
    }
}