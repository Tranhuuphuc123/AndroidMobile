package com.example.asignment1.model;

import androidx.annotation.NonNull;

public class student {
    private String rollno;
    private String name;
    private String term;
    private String date;

    public student(String rollno, String name, String term, String date) {
        this.rollno = rollno;
        this.name = name;
        this.term = term;
        this.date = date;
    }


    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
