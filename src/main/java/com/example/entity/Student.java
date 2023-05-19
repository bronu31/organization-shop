package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


import java.beans.ConstructorProperties;
@Entity
@Table(name="students")
@Getter
@Setter
@ToString
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "coarses",nullable = true)
    private String coarses;



    public Student(String name, String surname, String email, String coarses) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.coarses = coarses;
    }

    public Student() {

    }

}
