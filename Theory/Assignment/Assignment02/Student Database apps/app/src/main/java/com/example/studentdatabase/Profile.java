package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Profile extends AppCompatActivity  {

    private EditText name,phone,emailAdress,studentId,presentAddress,permanentAddress,birthDay ;
    private Button addInfo,skipPage;
    private Spinner schoolName, departmentName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = findViewById(R.id.editTextTextPersonName);
        phone = findViewById(R.id.editTextPhone);
        emailAdress = findViewById(R.id.editTextTextEmailAddress);
        studentId = findViewById(R.id.studentid);
        presentAddress = findViewById(R.id.presentAddressText);
        permanentAddress = findViewById(R.id.Permanent_address_id);
        birthDay = findViewById(R.id.Birth_Date);
        addInfo = (Button) findViewById(R.id.profile_save_btn);
        skipPage = findViewById(R.id.skip_btn_btn);
        schoolName = findViewById(R.id.spinner);
        departmentName = findViewById(R.id.spinner2);


        addInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (name.getText().toString().isEmpty()
                        || phone.getText().toString().isEmpty()
                        || emailAdress.getText().toString().isEmpty()
                        || studentId.getText().toString().isEmpty()
                        || presentAddress.getText().toString().isEmpty()
                        || permanentAddress.getText().toString().isEmpty()
                        || birthDay.getText().toString().isEmpty()
                        || schoolName.toString().isEmpty()
                        || departmentName.toString().isEmpty()

                ) {
                    Toast.makeText(Profile.this, "Please fill up all Section", Toast.LENGTH_SHORT).show();

                } else {
                    String name1 = name.getText().toString().trim();
                    String phone1 = phone.getText().toString().trim();
                    String emailadress1 = emailAdress.getText().toString().trim();
                    String studentid1 = studentId.getText().toString().trim();
                    String presentadress1 = presentAddress.getText().toString().trim();
                    String permanentadress1 = permanentAddress.getText().toString().trim();
                    String birthDay1 = birthDay.getText().toString().trim();
                    String schoolName1=schoolName.toString().trim();
                    String departmentName1=departmentName.toString().trim();
                    StudentRepository studentRepository = new StudentRepository(getApplicationContext());
                    Student student = new Student(Integer.parseInt(studentid1),name1,phone1,emailadress1,presentadress1,permanentadress1,schoolName1,departmentName1);
                    studentRepository.InsertTask(student);
                    name.setText("");
                    phone.setText("");
                    studentId.setText("");
                    emailAdress.setText("");
                    presentAddress.setText("");
                    permanentAddress.setText("");
                    birthDay.setText("");


                }

            }

        });
        skipPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Profile.this,viewActivity.class);
                startActivity(intent);
           }
        });

    }
}