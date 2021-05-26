package com.example.nsucpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class JobDetailsActivity extends AppCompatActivity {
    private TextView JobTtile,companyNameDetails,postDate,skillDetails,salaryDetails,workexDetails,jobDescrptionDetails;
    private Button documentsPdfShow,applyJobButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);
        JobTtile=(TextView)findViewById(R.id.JobTitleDetails);
        companyNameDetails=(TextView)findViewById(R.id.companyNameJobDetails);
        postDate=(TextView)findViewById(R.id.date);
        salaryDetails=(TextView)findViewById(R.id.salaryjobDetails);
        skillDetails=(TextView)findViewById(R.id.skillJobDetails);
        workexDetails=(TextView)findViewById(R.id.workExperiencejobDetails);
        jobDescrptionDetails=(TextView)findViewById(R.id.jobDescrptionJobDetails);
        documentsPdfShow=(Button)findViewById(R.id.seePdfFileJobDetailsButton);
        applyJobButton=(Button)findViewById(R.id.JobApplyButton);
        //Receive data from all job activity using intent
        Intent intent =getIntent();
        String title=intent.getStringExtra("title");
        String date=intent.getStringExtra("date");
        String salary=intent.getStringExtra("salary");
        String companytitle=intent.getStringExtra("companytitle");
        String joblocation=intent.getStringExtra("joblocation");
        String workexperience=intent.getStringExtra("workexperience");
        String skill=intent.getStringExtra("skill");
        startActivity(intent);

        JobTtile.setText(title);
        companyNameDetails.setText(companytitle);
        postDate.setText(date);
        salaryDetails.setText(salary);
        jobDescrptionDetails.setText(joblocation);
        workexDetails.setText(workexperience);
        skillDetails.setText(skill);



    }
}