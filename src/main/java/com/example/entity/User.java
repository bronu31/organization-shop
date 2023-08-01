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
    private Long id;

    private String email;

    private String password;

    private Float Balance;


    //private List<Integer> bought_prod;

    public User(Long id, String email, String password, Float balance) {
        this.id = id;
        this.email = email;
        this.password = password;
        Balance = balance;
    }


}
