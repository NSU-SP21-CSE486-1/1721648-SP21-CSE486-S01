package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Profile extends AppCompatActivity  {

    private EditText name,phone,emailAdress,studentId,presentAddress,permanentAddress,birthDay ;
    private Button button,skippage;
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
        button = (Button) findViewById(R.id.profile_save_btn);
        skippage = findViewById(R.id.skip_btn_btn);
        schoolName = findViewById(R.id.spinner);
        departmentName = findViewById(R.id.spinner2);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (name.getText().toString().isEmpty()
                        || phone.getText().toString().isEmpty()
                        || emailAdress.getText().toString().isEmpty()
                        || studentId.getText().toString().isEmpty()
                        || presentAddress.getText().toString().isEmpty()
                        || permanentAddress.getText().toString().isEmpty()
                        || birthDay.getText().toString().isEmpty()

                ) {
                    Toast.makeText(Profile.this, "Please fill up all Section", Toast.LENGTH_SHORT).show();

                } else {
                    String name1 = name.getText().toString().trim();
                    String phone1 = phone.getText().toString();
                    String emailadress1 = emailAdress.getText().toString();
                    String studentid1 = studentId.getText().toString();
                    String presentadress1 = presentAddress.getText().toString();
                    String permanentadress1 = permanentAddress.getText().toString();
                    String birthDay1 = birthDay.getText().toString();
                    StudentRepository studentRepository = new StudentRepository(getApplicationContext());
                    Student student = new Student(Integer.parseInt(studentid1),name1,phone1,emailadress1,presentadress1,permanentadress1);
                    studentRepository.InsertTask(student);


                }

            }

        });

    }
}