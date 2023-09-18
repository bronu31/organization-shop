package com.example.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//@Entity
@NoArgsConstructor
@Entity
@Getter
@Setter
@AllArgsConstructor
public class User {
@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq",sequenceName = "user_seq",allocationSize = 1,initialValue = 1)
    private Long id;

    @NotBlank
    private String email;

    @NotBlank
    private String name;
    @NotBlank
    private String password;

    private Float balance;

    @OneToMany
    @PrimaryKeyJoinColumn
    private List<Product> bought_prod;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.balance=0.0f;
        this.bought_prod=new LinkedList<>();
    }
}
