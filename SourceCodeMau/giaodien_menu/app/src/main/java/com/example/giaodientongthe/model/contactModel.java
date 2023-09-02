package com.example.giaodientongthe.model;

public class contactModel {
    private int id;
    private String name;
    private String nickName;
    private String number;
    private String address;
    private String notes;

    public contactModel() {
    }

    public contactModel(int id, String name, String nickName,
                        String number, String address, String notes) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.number = number;
        this.address = address;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
