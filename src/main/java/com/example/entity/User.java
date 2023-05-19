package com.example.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

//@Entity
@NoArgsConstructor
public class User {
@Id
@GeneratedValue
    private Integer id;

    private String email;

    private String password;

    private Float Balance;

    private Boolean admin;

    //private List<Integer> bought_prod;

    public User(Integer id, String email, String password, Float balance) {
        this.id = id;
        this.email = email;
        this.password = password;
        Balance = balance;
        this.admin = false;
    }

    public User(Integer id, String email, String password, Float balance, Boolean admin) {
        this.id = id;
        this.email = email;
        this.password = password;
        Balance = balance;
        this.admin = admin;
    }
}
