package com.example.nsucpc;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nsucpc.Model.Data;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.text.DateFormat;
import java.util.Date;

public class InsertJobPostActivity extends AppCompatActivity {
    private EditText jobTitle,companyName,Salaryedit,skillEdit,workExperience,jobLocation;
    private ImageView uploadpdfFile;
    Uri imageuri = null;//uri is the URL THAT ARE MEANS FOR LOCAL STORAGE

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
        uploadpdfFile=(ImageView)findViewById(R.id.imageViewPdf);

        // After Clicking on this we will be
        // redirected to choose pdf
        uploadpdfFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);//fetch file

                // only pdf file is allow to upload
                //to offer a select file from file manager
                galleryIntent.setType("application/pdf");
                startActivityForResult(galleryIntent, 1);// launch intent
            }
        });
        //pdf file select task finish in on create */

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
    //pdf file upload Dialog

    ProgressDialog dialog;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //check pdf file ,if uploaded file is pdf then it will be upload
        if (resultCode == RESULT_OK) {

            // progress dialog box
            dialog = new ProgressDialog(this);
            dialog.setMessage("Your Selected File is Uploading");

            // this will show message uploading ,while pdf is uploading
            dialog.show();
            imageuri = data.getData();
            final String timestamp = "" + System.currentTimeMillis();
            StorageReference storageReference = FirebaseStorage.getInstance().getReference(); //RETURN ROOTS PATH

            final String messagePushID = timestamp;
            Toast.makeText(InsertJobPostActivity.this, imageuri.toString(), Toast.LENGTH_SHORT).show();

            // Here we are uploading the pdf in firebase storage with the name of current time
            final StorageReference filepath = storageReference.child(messagePushID + "." + "pdf");
            Toast.makeText(InsertJobPostActivity.this, filepath.getName(), Toast.LENGTH_SHORT).show();
            filepath.putFile(imageuri).continueWithTask((Continuation) task -> {
                if (!task.isSuccessful()) {
                    throw task.getException();
                }
                return filepath.getDownloadUrl();
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        // After uploading is done it progress dialog box will be dismissed
                        dialog.dismiss();
                        Uri uri = task.getResult();

                        String myurl;
                        myurl = uri.toString();
                        Toast.makeText(InsertJobPostActivity.this, "File Uploaded Successfully", Toast.LENGTH_SHORT).show();

                    }
                    else
                        {
                        dialog.dismiss();
                        Toast.makeText(InsertJobPostActivity.this, "File not uploaded please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


}

    
