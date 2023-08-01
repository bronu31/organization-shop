package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_seq")
    private Long id;

    private List<Product> productsOnSale;

    private Byte saleSize;

    private Date saleEnd;
}
