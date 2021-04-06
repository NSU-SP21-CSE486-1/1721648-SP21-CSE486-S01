package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Profile extends AppCompatActivity implements OnClickListener {

    private EditText name,phone,emailAdress,studentId,presentAddress,permanentAddress,birthDay ;
    private Button addinfo,skippage;
    private Spinner schoolName, departmentName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name=findViewById(R.id.editTextTextPersonName);
        phone=findViewById(R.id.editTextPhone);
        emailAdress=findViewById(R.id.editTextTextEmailAddress);
        studentId=findViewById(R.id.studentid);
        presentAddress=findViewById(R.id.presentAddressText);
        permanentAddress=findViewById(R.id.Permanent_address_id);
        birthDay=findViewById(R.id.Birth_Date);
        addinfo=findViewById(R.id.profile_save_btn);
        skippage=findViewById(R.id.skip_btn_btn);
        schoolName=findViewById(R.id.spinner);
        departmentName=findViewById(R.id.spinner2);
        
    }

    @Override
    public void onClick(View v) {
            String name1 =name.getText().toString();
        String phone1 =phone.getText().toString();
        String emailadress1 =emailAdress.getText().toString();
        String studentid1 =studentId.getText().toString();
        String presentadress1 =presentAddress.getText().toString();
        String permanentadress1 =permanentAddress.getText().toString();
        String birthDay1=birthDay.getText().toString();
        addinfo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Profile.this, "name"+ name1, Toast.LENGTH_SHORT).show();

            }

        });


    }
}