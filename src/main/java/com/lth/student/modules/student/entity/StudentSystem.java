package com.lth.student.modules.student.entity;


import java.io.Serializable;

public class StudentSystem implements Serializable{
    public int id;
    public String student_name;
    public String student_department;
    public String student_competition;
    public String student_copyright;
    public String student_patent;
    public String student_paper;
    public String student_project;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_department() {
        return student_department;
    }

    public void setStudent_department(String student_department) {
        this.student_department = student_department;
    }

    public String getStudent_competition() {
        return student_competition;
    }

    public void setStudent_competition(String student_competition) {
        this.student_competition = student_competition;
    }

    public String getStudent_copyright() {
        return student_copyright;
    }

    public void setStudent_copyright(String student_copyright) {
        this.student_copyright = student_copyright;
    }

    public String getStudent_patent() {
        return student_patent;
    }

    public void setStudent_patent(String student_patent) {
        this.student_patent = student_patent;
    }

    public String getStudent_paper() {
        return student_paper;
    }

    public void setStudent_paper(String student_paper) {
        this.student_paper = student_paper;
    }

    public String getStudent_project() {
        return student_project;
    }

    public void setStudent_project(String student_project) {
        this.student_project = student_project;
    }
}
