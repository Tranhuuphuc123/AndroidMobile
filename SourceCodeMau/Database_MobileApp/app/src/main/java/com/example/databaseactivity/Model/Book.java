package com.example.databaseactivity.Model;

import androidx.annotation.NonNull;

public class Book {
    private int id;
    private String name;

    // contructor
    public Book( String name, int image) {
        this.name = name;
    }

    public Book(int id, String name, int image) {
        this.id = id;
        this.name = name;
    }


    //get and set
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
