package com.example.studentdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey
    public int studentid;

    @ColumnInfo(name="studentname")
    public String studentname;

    @ColumnInfo(name="phonenumber")
    public String phonenumber;

    @ColumnInfo(name = "email_adress")
    public String email_adress;

    @ColumnInfo(name = "present_adress")
    public String present_adress;

    @ColumnInfo(name = "permanent_adress")
    public String permanent_adress;

    @ColumnInfo(name = "school")
    public String school;


    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    @ColumnInfo(name = "departmentname")
    public String departmentname;


    public Student(int studentid, String studentname, String phonenumber, String email_adress, String present_adress, String permanent_adress , String school , String departmentname ) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.phonenumber = phonenumber;
        this.email_adress = email_adress;
        this.present_adress = present_adress;
        this.permanent_adress = permanent_adress;
        this.school = school;
        this.departmentname = departmentname;
    }
}
