package com.example.nsucpc.Model;

public class Student {
    public String studentid;
    public String studentname;
    public String phonenumber;
    public String email_adress;
    public String present_adress;
    public String school;
    public String departmentname;
    public String permanent_adress;
    public String studentNid;

    public Student(String name1, String phone1, String emailadress1, String studentid1, String presentadress1, String permanentadress1, String birthDay1, String schoolName1, String departmentName1, String nid1){

    }

    public Student(String studentid, String studentname, String phonenumber, String email_adress, String present_adress, String school, String departmentname, String permanent_adress, String studentNid) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.phonenumber = phonenumber;
        this.email_adress = email_adress;
        this.present_adress = present_adress;
        this.school = school;
        this.departmentname = departmentname;
        this.permanent_adress = permanent_adress;
        this.studentNid = studentNid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail_adress() {
        return email_adress;
    }

    public void setEmail_adress(String email_adress) {
        this.email_adress = email_adress;
    }

    public String getPresent_adress() {
        return present_adress;
    }

    public void setPresent_adress(String present_adress) {
        this.present_adress = present_adress;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getPermanent_adress() {
        return permanent_adress;
    }

    public void setPermanent_adress(String permanent_adress) {
        this.permanent_adress = permanent_adress;
    }

    public String getStudentNid() {
        return studentNid;
    }

    public void setStudentNid(String studentNid) {
        this.studentNid = studentNid;
    }
}
