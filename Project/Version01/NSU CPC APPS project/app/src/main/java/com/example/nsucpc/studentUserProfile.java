package com.example.nsucpc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class studentUserProfile extends AppCompatActivity {

    private FirebaseUser studentProfile;
    private DatabaseReference reference;
    private String studentUsersId;
    private Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_user_profile);
        updateBtn=(Button)findViewById(R.id.updateUserButton);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(studentUserProfile.this,Profile.class);
                startActivity(intent);

            }
        });


        studentProfile= FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("StudentUsers");
        studentUsersId=studentProfile.getUid();
        final TextView  fullnameTextView=(TextView)findViewById(R.id.userName);
        final TextView  emailIdTextView=(TextView)findViewById(R.id.emailUser);
        final TextView  studentIdTextView=(TextView)findViewById(R.id.studentIDUser);
        final TextView  mobileNumberTextView=(TextView)findViewById(R.id.mobileUser);

        reference.child(studentUsersId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                studentUser userProfile=snapshot.getValue(studentUser.class);
                if(userProfile !=null){
                    String fullName=userProfile.editTextPersonName;
                    String email=userProfile.editTextStudentEmailAddress;
                    String stuId=userProfile.editTextStudentId;
                    String stuMobileNumber=userProfile.editTextStudentPhone;

                    fullnameTextView.setText(fullName);
                    emailIdTextView.setText(email);
                    studentIdTextView.setText(stuId);
                    mobileNumberTextView.setText(stuMobileNumber);



                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(studentUserProfile.this,"Something is wrong Happened",Toast.LENGTH_LONG).show();

            }
        });




    }

}