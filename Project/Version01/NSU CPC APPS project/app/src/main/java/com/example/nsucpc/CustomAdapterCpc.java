package com.example.nsucpc;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nsucpc.Model.Data;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomAdapterCpc  extends RecyclerView.Adapter<CustomAdapterCpc.MyViewHolder>{
    Context context;
    ArrayList<Data> list;

    public CustomAdapterCpc(Context context, ArrayList<Data> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_post_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CustomAdapterCpc.MyViewHolder holder, int position) {
     Data data =list.get(position);
        holder.setJobTitle(data.getTitle());
        holder.setcompanytitle(data.getCompanytitle());
        holder.setJobDate(data.getDate());
        holder.setJoblocation(data.getJoblocation());
        holder.setJobSkills(data.getSkill());
        holder.setJobSalary(data.getSalary());

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
}
