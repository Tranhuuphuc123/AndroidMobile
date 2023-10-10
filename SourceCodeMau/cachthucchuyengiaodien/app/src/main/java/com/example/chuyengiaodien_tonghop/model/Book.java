package com.example.chuyengiaodien_tonghop.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Book implements Serializable {
    /* 1/ Chức năng chính của lớp Serializable là cho phép một đối tượng có thể được chuyển đổi
     thành chuỗi byte và ngược lại

      2/  Một khi một đối tượng được đánh dấu là Serializable, nó có thể được truyền đi qua mạng,
     lưu trữ vào tệp, hoặc chuyển đổi thành chuỗi byte để lưu trữ hoặc truyền tải dữ liệu.*/

    private String id;
    private String name;
    private double price;

    public Book(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        String result =  "Book Info"
                + "\n ID:    " + this.getId()
                + "\n name:  " + this.getName()
                + "\n Price: " + this.getPrice();

        return result;
    }
}
