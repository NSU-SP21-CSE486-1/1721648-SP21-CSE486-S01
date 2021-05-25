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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class PostJobActivity extends AppCompatActivity {
    private FloatingActionButton fabBtn;
    private RecyclerView recyclerView;
    private FirebaseAuth mAuth;
    private DatabaseReference JobPostDatabase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job);
        fabBtn=(FloatingActionButton)findViewById(R.id.floatingActionButtonAddPost);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String uId = mUser.getUid();
        JobPostDatabase = FirebaseDatabase.getInstance().getReference().child("Job Post").child(uId);
        recyclerView = findViewById(R.id.recycler_job_post_id);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);

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
    @Override
    protected void onStart(){
        super.onStart();

        FirebaseRecyclerOptions<Data > firebaseRecyclerOptions;
        firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<Data>()
                .setQuery(JobPostDatabase, Data.class)
                .build();


        FirebaseRecyclerAdapter<Data, MyViewHolder> adapter = new FirebaseRecyclerAdapter<Data, MyViewHolder>(firebaseRecyclerOptions) {

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_post_item,parent,false);
                return new MyViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i, @NonNull Data model) {

                viewHolder.setJobTitle(model.getTitle());
                viewHolder.setcompanytitle(model.getCompanytitle());
                viewHolder.setJobDate(model.getDate());
                viewHolder.setJoblocation(model.getJoblocation());
                viewHolder.setJobSkills(model.getSkill());
                viewHolder.setJobSalary(model.getSalary());
            }

        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }
    

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        View myview ;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            myview = itemView;
        }
        public void setJobTitle(String title){
            TextView mTitle=myview.findViewById(R.id.jobTitleCard);
            mTitle.setText(title);
        }
        public void setJobDate(String date){
            TextView mDate=myview.findViewById(R.id.dateTextCard);
            mDate.setText(date);
        }
        public void setJoblocation (String joblocation){
            TextView mJoblocation=myview.findViewById(R.id.jobDescriptionCrad);
            mJoblocation.setText(joblocation);
        }
        public void setJobSkills (String skill){
            TextView mSkills=myview.findViewById(R.id.cpcSkillsCard);
            mSkills.setText(skill);
        }
        public void setJobSalary (String salary){
            TextView mSalary=myview.findViewById(R.id.cpcSalaryCard);
            mSalary.setText(salary);
        }
        public void setcompanytitle (String companytitle){
            TextView mcompanytitle=myview.findViewById(R.id.companyNameCardCPC);
            mcompanytitle.setText(companytitle);
        }

    }


    private class FirebaseRecyclerOptions<T> {
        public class Builder<T> {
        }
    }

    private abstract class FirebaseRecyclerAdapter<T, T1> extends RecyclerView.Adapter {
        public FirebaseRecyclerAdapter(FirebaseRecyclerOptions<T> firebaseRecyclerOptions) {
        }

        public void startListening() {
        }

        @NonNull
        public abstract MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

        @Override
        public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
            
        }

        @Override
        public int getItemCount() {
            return 0;
        }

        protected abstract void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i, @NonNull Data model);
    }
}