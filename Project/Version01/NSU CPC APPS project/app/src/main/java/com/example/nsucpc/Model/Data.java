package com.example.nsucpc.Model;


public class Data  {

    String title,companytitle,salary,skill,workexperience,joblocation,id,date;

    public Data(){

    }

    public Data(String title, String companytitle, String salary, String skill, String workexperience, String joblocation, String id, String date) {
        this.title = title;
        this.companytitle = companytitle;
        this.salary = salary;
        this.skill = skill;
        this.workexperience = workexperience;
        this.joblocation = joblocation;
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
        return joblocation;
    }

    public void setJoblocation(String joblocation) {
        this.joblocation = joblocation;
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
