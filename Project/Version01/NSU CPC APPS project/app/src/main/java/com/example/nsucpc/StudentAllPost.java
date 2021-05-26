package com.example.nsucpc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nsucpc.Model.Data;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class StudentAllPost extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference JobPostDatabase;
    CustomAdapterStudent myCustomAdapterStudent;
    ArrayList<Data> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_all_post);

        recyclerView = findViewById(R.id.recyclerStudentAllJobPost);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        JobPostDatabase = FirebaseDatabase.getInstance().getReference().child("public database");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        list=new ArrayList<>();
        myCustomAdapterStudent=new CustomAdapterStudent(this,list );
        recyclerView.setAdapter(myCustomAdapterStudent);
        JobPostDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Data data =dataSnapshot.getValue(Data.class);
                    list.add(data);
                }
                myCustomAdapterStudent.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });




        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);




    }
}