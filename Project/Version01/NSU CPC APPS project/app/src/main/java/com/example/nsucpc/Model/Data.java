package com.example.nsucpc.Model;


import android.text.style.TtsSpan;

public class Data extends TtsSpan.Builder<TtsSpan.Builder> {

    String title,companytitle,salary,skill,workexperience,jobdescription,id,date;

    public Data(){

    }

    public Data(String title, String companytitle, String salary, String skill, String workexperience, String jobdescription, String id, String date) {
        this.title = title;
        this.companytitle = companytitle;
        this.salary = salary;
        this.skill = skill;
        this.workexperience = workexperience;
        this.jobdescription = jobdescription;
        this.id = id;
        this.date = date;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanytitle() {
        return companytitle;
    }

    public void setCompanytitle(String companytitle) {
        this.companytitle = companytitle;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getWorkexperience() {
        return workexperience;
    }

    public void setWorkexperience(String workexperience) {
        this.workexperience = workexperience;
    }



    public String getJoblocation() {
        return jobdescription;
    }

    public void setJoblocation(String joblocation) {
        this.jobdescription = joblocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
