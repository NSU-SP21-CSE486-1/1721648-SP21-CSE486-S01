package com.example.nsucpc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nsucpc.Model.Data;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PostJobActivity extends AppCompatActivity {
    private FloatingActionButton fabBtn;
    private RecyclerView recyclerView;
    private FirebaseAuth mAuth;
    private DatabaseReference JobPostDatabase;
    CustomAdapterCpc myCustomAdapterCpc;
    ArrayList<Data> list;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job);
        fabBtn=(FloatingActionButton)findViewById(R.id.floatingActionButtonAddPost);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String uId = mUser.getUid();
        JobPostDatabase = FirebaseDatabase.getInstance().getReference().child("public database").child(uId);
        recyclerView = findViewById(R.id.recycler_job_post_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        list=new ArrayList<>();
        myCustomAdapterCpc=new CustomAdapterCpc(this,list );
        recyclerView.setAdapter(myCustomAdapterCpc);
        JobPostDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
               for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                 Data data =dataSnapshot.getValue(Data.class);
                 list.add(data);
               }
                myCustomAdapterCpc.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });




        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);



        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),InsertJobPostActivity.class);
                startActivity(intent);


            }
        });

    }

}