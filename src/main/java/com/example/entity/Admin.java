package com.example.entity;

public class Admin extends User{
    public Admin(Integer id, String email, String password, Float balance) {
        super(id, email, password, balance, true);
    }
}
