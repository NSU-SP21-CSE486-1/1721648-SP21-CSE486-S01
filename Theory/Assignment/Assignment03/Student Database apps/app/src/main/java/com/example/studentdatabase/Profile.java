package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class Profile extends AppCompatActivity  {

    private EditText name,phone,emailAdress,studentId,presentAddress,permanentAddress,nId ;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private Button addInfo,skipPage;
    private Spinner schoolName;
    private AutoCompleteTextView departmentName;
    String[] DepartmentNames;

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
        nId = findViewById(R.id.Nid);


       // birthDay = findViewById(R.id.Birth_Date);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());

        addInfo = (Button) findViewById(R.id.profile_save_btn);
        skipPage = findViewById(R.id.skip_btn_btn);
         schoolName = findViewById(R.id.spinner);
        departmentName = findViewById(R.id.spinner2);
        DepartmentNames=getResources().getStringArray(R.array.Department_of_nsu);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,DepartmentNames);
        departmentName.setThreshold(1);
        departmentName.setAdapter(adapter);

        //Initialize Validation Style

        addInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (name.getText().toString().isEmpty()
                        || phone.getText().toString().isEmpty()
                        || emailAdress.getText().toString().isEmpty()
                        || studentId.getText().toString().isEmpty()
                        || presentAddress.getText().toString().isEmpty()
                        || permanentAddress.getText().toString().isEmpty()
                        || datePickerDialog.toString().isEmpty()
                        || schoolName.toString().isEmpty()
                        || departmentName.getText().toString().isEmpty()
                        ||nId.getText().toString().isEmpty()

                ) {
                    Toast.makeText(Profile.this, "Please fill up all Section", Toast.LENGTH_SHORT).show();

                }
                else if(phone.getText().toString().length()>11 || phone.getText().toString().length()<11){
                    Toast.makeText(Profile.this, "Please input valid mobile number of 11 digits", Toast.LENGTH_SHORT).show();
                }
                else if(studentId.getText().toString().length()>7 || studentId.getText().toString().length()<7  ){
                    Toast.makeText(Profile.this, "Please input your 7 digit of nsu id", Toast.LENGTH_SHORT).show();
                }
                else if(nId.getText().toString().length()>10 || nId.getText().toString().length()<10  ){
                    Toast.makeText(Profile.this, "Please input your 10 digit of National id", Toast.LENGTH_SHORT).show();
                }




                else {
                    String name1 = name.getText().toString().trim();
                    String phone1 = phone.getText().toString().trim();
                    String emailadress1 = emailAdress.getText().toString().trim();
                    String studentid1 = studentId.getText().toString().trim();
                    String presentadress1 = presentAddress.getText().toString().trim();
                    String permanentadress1 = permanentAddress.getText().toString().trim();
                    String birthDay1 = datePickerDialog.toString().trim();
                    String schoolName1=schoolName.toString().trim();
                    String departmentName1=departmentName.getText().toString().trim();
                    String Nid1=nId.getText().toString().trim();
                    StudentRepository studentRepository = new StudentRepository(getApplicationContext());
                    Student student = new Student(Integer.parseInt(studentid1),name1,phone1,emailadress1,presentadress1,permanentadress1,schoolName1,departmentName1);
                    studentRepository.InsertTask(student);
                    name.setText("");
                    phone.setText("");
                    studentId.setText("");
                    emailAdress.setText("");
                    presentAddress.setText("");
                    permanentAddress.setText("");
                    departmentName.setText("");






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

    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }
}
