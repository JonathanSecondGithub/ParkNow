package com.example.parknow;

public class user {
    String name;
    String carreg;
    String phone;
    String email;
    String pass;

    public user(String name, String carreg, String phone, String email, String pass) {
        this.name = name;
        this.carreg = carreg;
        this.phone = phone;
        this.email = email;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getCarreg() {
        return carreg;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}
