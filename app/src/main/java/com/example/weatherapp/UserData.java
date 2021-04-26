package com.example.weatherapp;

public class UserData {
    private String Email;
    private String firstn;
    private String lastn;
    private String phoneNum;
    private int Id;
    UserData(){

    }

    public UserData(String Email, String firstn, String lastn, String phoneNum, int Id) {
        this.Email = Email;
        this.firstn = firstn;
        this.lastn = lastn;
        this.phoneNum = phoneNum;
        this.Id = Id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getfirstn() {
        return firstn;
    }

    public void setfirstn(String firstn) {
        this.firstn = firstn;
    }

    public String getlastn() {
        return lastn;
    }

    public void setlastn(String lastn) {
        this.lastn = lastn;
    }

    public String getphoneNum() {
        return phoneNum;
    }

    public void setphoneNum(String phoneNum) {
        phoneNum = phoneNum;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
}