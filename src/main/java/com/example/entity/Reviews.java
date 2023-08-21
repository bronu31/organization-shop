package com.example.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviews_seq")
    @SequenceGenerator(name = "reviews_seq",sequenceName = "reviews_seq",allocationSize = 1,initialValue = 1)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @NotNull
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @NotNull
    private Product product;
    @NotNull
    private Byte score;

    private String reviewText;
}
