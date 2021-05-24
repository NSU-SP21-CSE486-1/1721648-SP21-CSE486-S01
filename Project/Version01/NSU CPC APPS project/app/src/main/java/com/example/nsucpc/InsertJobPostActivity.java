package com.example.nsucpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nsucpc.Model.Data;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

public class InsertJobPostActivity extends AppCompatActivity {
    private EditText jobTitle,companyName,Salaryedit,skillEdit,workExperience,jobLocation;
    private ImageView upload;
    private Button PostJobButtonCPC ;
    
    //Firebase
    
    private FirebaseAuth mAuth;
    private DatabaseReference mJobPost;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_job_post);
        jobTitle=(EditText)findViewById(R.id.jobTtileEditText);
        companyName=(EditText)findViewById(R.id.companyNameEditText);
        Salaryedit=(EditText)findViewById(R.id.SalaryeditTextNumber);
        skillEdit=(EditText)findViewById(R.id.skilEditText);
        workExperience=(EditText)findViewById(R.id.workExperienceeditText);
        jobLocation=(EditText)findViewById(R.id.LocationEditText);
        PostJobButtonCPC=(Button)findViewById(R.id.addPostSaveButton);
        upload=(ImageView)findViewById(R.id.imageViewPdf);

        mAuth=FirebaseAuth.getInstance();
        //CurentUserId
        FirebaseUser mUser=mAuth.getCurrentUser();
        String uId=mUser.getUid();
        mJobPost= FirebaseDatabase.getInstance().getReference().child("Job Post").child(uId);
        

        PostJobButtonCPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=jobTitle.getText().toString().trim();
                String companytitle=companyName.getText().toString().trim();
                String salary=Salaryedit.getText().toString().trim();
                String skill=skillEdit.getText().toString().trim();
                String workexperience=workExperience.getText().toString().trim();
                String joblocation=jobLocation.getText().toString().trim();
                if(TextUtils.isEmpty(title)){
                    jobTitle.setError("Please Fill Up Job Title");
                    return;
                    
                }
                if(TextUtils.isEmpty(companytitle)){
                    companyName.setError("Please Fill Up company Name ");
                    return;

                }
                if(TextUtils.isEmpty(salary)){
                    Salaryedit.setError("Please Fill Up Salary amount ");
                    return;

                }
                if(TextUtils.isEmpty(skill)){
                    skillEdit.setError("Please Fill Up skill Field");
                    return;

                }
                if(TextUtils.isEmpty(workexperience)){
                    workExperience.setError("Please Fill Up workExperience Field ");
                    return;

                }
                if(TextUtils.isEmpty(joblocation)){
                    jobLocation.setError("Please Fill Up jobLocation Field ");
                    return;

                }
                
                String id=mJobPost.push().getKey();
                String date= DateFormat.getDateInstance().format(new Date());
                
                Data data = new Data(title,companytitle,salary,skill,workexperience,joblocation,id,date);
                mJobPost.child(id).setValue(data);
                
                Toast.makeText(getApplicationContext(),"Successfull add post",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),PostJobActivity.class));
                
                
                
            }
        });
        
        
        
    }
    
}