package com.example.nsucpc;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nsucpc.Model.Data;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;



    public class CustomAdapterStudent  extends RecyclerView.Adapter<com.example.nsucpc.CustomAdapterStudent.MyViewHolder>{
        Context context;
        ArrayList<Data> list;

        public CustomAdapterStudent(Context context, ArrayList<Data> list) {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @NotNull
        @Override
        public com.example.nsucpc.CustomAdapterStudent.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_all_job_cardview,parent,false);
            return new com.example.nsucpc.CustomAdapterStudent.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull com.example.nsucpc.CustomAdapterStudent.MyViewHolder holder, int position) {
            Data data =list.get(position);
            holder.setJobTitle(data.getTitle());
            holder.setCompanytitle(data.getCompanytitle());
            holder.setJobDate(data.getDate());
            holder.setJobSalary(data.getSalary());




            holder.myview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context.getApplicationContext(),JobDetailsActivity.class);
                    
                    intent.putExtra("title",data.getTitle());
                    intent.putExtra("date",data.getDate());
                    intent.putExtra("salary",data.getSalary());
                    intent.putExtra("companytitle",data.getCompanytitle());
                    intent.putExtra("joblocation",data.getJoblocation());
                    intent.putExtra("workexperience",data.getWorkexperience());
                    intent.putExtra("skill",data.getSkill());
                    Toast.makeText(context.getApplicationContext(),"Button Clicked",Toast.LENGTH_SHORT).show();
                    

                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder
        {

            View myview ;
            public MyViewHolder(@NonNull @NotNull View itemView) {
                super(itemView);
                myview = itemView;
            }
            public void setJobTitle(String title){
                TextView mTitle=myview.findViewById(R.id.student_jobTitleCard);
                mTitle.setText(title);
            }
            public void setJobDate(String date){
                TextView mDate=myview.findViewById(R.id.student_dateTextCard);
                mDate.setText(date);
            }

            public void setJobSalary (String salary){
                TextView mSalary=myview.findViewById(R.id.student_cpcSalaryCard);
                mSalary.setText(salary);
            }
            public void setCompanytitle (String companytitle){
                TextView mcompanytitle=myview.findViewById(R.id.student_companyNameCardCPC);
                mcompanytitle.setText(companytitle);
            }
            public void setJoblocation (String joblocation){
                TextView mJoblocation=myview.findViewById(R.id.jobDescrptionJobDetails);
                mJoblocation.setText(joblocation);
            }
            public void setWorkexperience (String workexperience){
                TextView mWorkexperience=myview.findViewById(R.id.workExperiencejobDetails);
                mWorkexperience.setText(workexperience);
            }
            public void setJobSkills (String skill){
                TextView mSkills=myview.findViewById(R.id.skillJobDetails);
                mSkills.setText(skill);
            }
        }
    }

